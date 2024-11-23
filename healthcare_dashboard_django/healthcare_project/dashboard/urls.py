from django.urls import path
from . import views

urlpatterns = [
    # DeviceType URLs
    path('device-types/', views.device_type_list, name='device_type_list'),
    path('device-types/<int:device_type_id>/', views.device_type_detail, name='device_type_detail'),
    path('api/device-types/', views.device_type_list_api, name='device_type_list_api'),
    
    # Staff URLs
    path('staff/', views.staff_list, name='staff_list'),
    path('staff/<int:staff_id>/', views.staff_detail, name='staff_detail'),
    path('api/staff/', views.staff_list_api, name='staff_list_api'),
    
    # Patient URLs
    path('patients/', views.patient_list, name='patient_list'),
    path('patients/<int:patient_id>/', views.patient_detail, name='patient_detail'),
    path('api/patients/', views.patient_list_api, name='patient_list_api'),
    
    # PatientMonitor URLs
    path('monitors/', views.monitor_list, name='monitor_list'),
    path('monitors/<int:monitor_id>/', views.monitor_detail, name='monitor_detail'),
    path('api/monitors/', views.monitor_list_api, name='monitor_list_api'),
    
    # VitalRecord URLs
    path('vital-records/', views.vital_record_list, name='vital_record_list'),
    path('vital-records/<int:record_id>/', views.vital_record_detail, name='vital_record_detail'),
    path('api/vital-records/', views.vital_record_list_api, name='vital_record_list_api'),
    
    # Alert URLs
    path('alerts/', views.alert_list, name='alert_list'),
    path('alerts/<int:alert_id>/', views.alert_detail, name='alert_detail'),
    path('api/alerts/', views.alert_list_api, name='alert_list_api'),
    
    # StaffTakesAction URLs
    path('actions/', views.staff_takes_action_list, name='staff_takes_action_list'),
    path('actions/<int:staff_id>/<int:alert_id>/<str:action_timestamp>/',views.staff_takes_action_detail,name='staff_takes_action_detail'),
    
    # Additional URLs as needed...
    
    # Home page redirecting to dashboard
    path('', views.dashboard_home, name='dashboard_home'),
]
