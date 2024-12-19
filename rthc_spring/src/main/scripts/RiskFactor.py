import pandas as pd
import json

data = "Virtual Patient Models_Dataset.csv"
data = pd.read_csv(data)
def preprocess_data(data):
    # Map non-numeric values in specific columns to numeric equivalents
    mappings = {
        "fried": { 'Non frail': 0, 'Pre-frail': 1, 'Frail': 2},
        "vision": {'Sees moderately': 1, 'Sees poorly': 0, 'Sees well': 2},
        "audition": {'Hears moderately': 0, 'Hears well': 1},
        "weight_loss": {'No': 0, 'Yes': 1},
        "balance_single": {'test non realizable': 0, '>5 sec': 1, '<5 sec': 2},
        "gait_speed_slower": {'Yes': 0, 'No': 1},
        "grip_strength_abnormal": {'No': 0, 'Yes': 1},
        "low_physical_activity": {'No': 0, 'Yes': 1}
    }

    # Apply mappings to the columns
    for column, mapping in mappings.items():
        if column in data.columns:
            data[column] = data[column].replace(mapping).astype(float)

    # Handle missing or invalid values (convert to NaN and fill with 0)
    data = data.apply(pd.to_numeric, errors='coerce').fillna(0)

    return data
# Define normalization ranges for the dataset
normalization_ranges = {
    "fried": (0, 5),
    "age": (20, 90),
    "hospitalization_one_year": (0, 10),
    "hospitalization_three_years": (0, 30),
    "ortho_hypotension": (0, 100),
    "vision": (0, 10),
    "audition": (0, 10),
    "weight_loss": (0, 10),
    "exhaustion_score": (0, 10),
    "raise_chair_time": (0, 60),
    "balance_single": (0, 10),
    "gait_get_up": (0, 10),
    "gait_speed_4m": (0, 2),
    "gait_speed_slower": (0, 2),
    "grip_strength_abnormal": (0, 50),
    "low_physical_activity": (0, 1)
}
# Define weights for each feature
weights = {
    "fried": 0.2,
    "age": 0.1,
    "hospitalization_one_year": 0.15,
    "hospitalization_three_years": 0.05,
    "ortho_hypotension": 0.1,
    "vision": 0.05,
    "audition": 0.05,
    "weight_loss": 0.05,
    "exhaustion_score": 0.05,
    "raise_chair_time": 0.05,
    "balance_single": 0.05,
    "gait_get_up": 0.05,
    "gait_speed_4m": 0.1,
    "gait_speed_slower": 0.05,
    "grip_strength_abnormal": 0.05,
    "low_physical_activity": 0.1
}
# Normalize a value
def normalize(value, min_val, max_val):
    # print(type(value), type(min_val), type(max_val))
    value = float(value)
    min_val = float(min_val)
    max_val = float(max_val)
    return (value - min_val) / (max_val - min_val) if max_val > min_val else 0

# Calculate risk factor
def calculate_risk_factor(row, normalization_ranges, weights):
    risk_factor = 0
    for feature, weight in weights.items():
        value = row.get(feature, 0)
        min_val, max_val = normalization_ranges.get(feature, (0, 1))
        normalized_value = normalize(value, min_val, max_val)
        risk_factor += weight * normalized_value
    return risk_factor

# Determine risk level
def determine_risk_level(risk_factor):
    if risk_factor <= 0.3:
        return "Low Risk"
    elif risk_factor <= 0.6:
        return "Moderate Risk"
    else:
        return "High Risk"
# Add calculated risk factor and risk level columns to the dataset
data = preprocess_data(data)
data['risk_factor'] = data.apply(lambda row: calculate_risk_factor(row, normalization_ranges, weights), axis=1)
data['risk_level'] = data['risk_factor'].apply(determine_risk_level)
grouped_data = data.sort_values(['part_id', 'clinical_visit']).groupby('part_id').agg(
    risk_factor=('risk_factor', 'last'),
    risk_factor_avg_overall_clinical_visit=('risk_factor', 'mean'),
    risk_level=('risk_level', 'last')
).reset_index()

# grouped_data

# Convert grouped_data DataFrame to JSON format
grouped_data_json = grouped_data.to_dict(orient='records')

# Specify the output JSON file path
json_output_path = '../resources/static/data/riskFactor.json'

# Save the JSON data to a file
with open(json_output_path, 'w') as json_file:
    json.dump(grouped_data_json, json_file, indent=4)

print(f"JSON file has been saved to {json_output_path}")
