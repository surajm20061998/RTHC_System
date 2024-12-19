import json
import pandas as pd
import xgboost as xgb
from sklearn.model_selection import train_test_split
import os
import datetime


# Load and clean data (same steps as before)
data_file = "forecast_data.xlsx"
data = pd.read_excel(data_file)

data = data.dropna(subset=['Date', 'Entry Time'])

# Convert 'Date' and time-related columns to datetime
data['Date'] = pd.to_datetime(data['Date'])
data['Entry Time'] = pd.to_datetime(data['Entry Time'], errors='coerce').dt.time
data['Post-Consultation Time'] = pd.to_datetime(data['Post-Consultation Time'], errors='coerce').dt.time
data['Completion Time'] = pd.to_datetime(data['Completion Time'], errors='coerce').dt.time

# Replace missing or invalid values for numerical columns
numerical_columns = ['Medication Revenue', 'Lab Cost', 'Consultation Revenue']

def clean_numeric_column(column):
    column = column.replace({'\\$': '', ',': '', '-': '0'}, regex=True)
    return pd.to_numeric(column, errors='coerce')

data.columns = data.columns.str.strip()

for col in numerical_columns:
    data[col] = clean_numeric_column(data[col])
    data[col] = data[col].fillna(0)

# Handle categorical columns
categorical_columns = ['Doctor Type', 'Financial Class']
for col in categorical_columns:
    data[col] = data[col].fillna('Unknown')

df1 = data.drop_duplicates(subset=['Patient ID'])

df3 = df1.copy()
df3['Date'] = pd.to_datetime(df3['Date'])
df3 = df3.sort_values('Date')
daily_data = df3.groupby(df3['Date'].dt.date).size().reset_index(name='patient_count')
daily_data.columns = ['date', 'patient_count']
daily_data['date'] = pd.to_datetime(daily_data['date'])
daily_data['day_of_week'] = daily_data['date'].dt.dayofweek
daily_data['is_weekend'] = daily_data['day_of_week'].isin([5, 6]).astype(int)
daily_data['month'] = daily_data['date'].dt.month
daily_data['year'] = daily_data['date'].dt.year

# Train XGBoost model
xgb_model = xgb.XGBRegressor(objective='reg:squarederror', n_estimators=100, random_state=42)
X = daily_data[['day_of_week', 'is_weekend', 'month', 'year']]
y = daily_data['patient_count']
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)
xgb_model.fit(X_train, y_train)

# Predict the next 7 days (for the upcoming week)
# next_7_days = pd.DataFrame({
#     'day_of_week': [0, 1, 2, 3, 4, 5, 6],  # Monday to Sunday
#     'is_weekend': [0, 0, 0, 0, 0, 1, 1],  # Saturday and Sunday are weekends
#     'month': [12, 12, 12, 12, 12, 12, 12],  # Same month (December for this example)
#     'year': [2023, 2023, 2023, 2023, 2023, 2023, 2023]  # Same year
# })

# predictions = xgb_model.predict(next_7_days)

start_date = datetime.date.today()
future_dates = [start_date + datetime.timedelta(days=i) for i in range(7)]

future_df = pd.DataFrame({'date': future_dates})
future_df['date'] = pd.to_datetime(future_df['date'])
future_df['day_of_week'] = future_df['date'].dt.dayofweek
future_df['is_weekend'] = future_df['day_of_week'].isin([5, 6]).astype(int)
future_df['month'] = future_df['date'].dt.month
future_df['year'] = future_df['date'].dt.year

predictions = xgb_model.predict(future_df[['day_of_week', 'is_weekend', 'month', 'year']])


# Prepare JSON data
forecast_data = []
for i in range(7):
    forecast_data.append({
        'day': future_df['date'].iloc[i].strftime("%Y-%m-%d"),
        'expected_patients': int(round(predictions[i], 2))
    })

forecast_json = json.dumps(forecast_data, indent=4)
# print(forecast_json)

# Define the path to save the JSON file
output_dir = "../resources/static/data/"
output_file = os.path.join(output_dir, "forecast.json")

# Make sure the directory exists
os.makedirs(output_dir, exist_ok=True)

# Write the JSON data to the file
with open(output_file, 'w') as json_file:
    json.dump(forecast_data, json_file, indent=4)

print(f"JSON file saved to: {output_file}")
