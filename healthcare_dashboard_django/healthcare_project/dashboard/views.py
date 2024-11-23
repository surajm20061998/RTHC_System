from django.shortcuts import render, get_object_or_404
from django.http import JsonResponse
from .models import (
    DeviceType, Staff, Patient, PatientMonitor, VitalRecord, Alert,
    DeviceTypeDefinesMonitor, MonitorRecordsVital, PatientHasVitalRecord,
    VitalRecordTriggersAlert, AlertRequiresAction, StaffTakesAction,
    StaffHandlesPatient, PatientMonitorAssignment
)
from django.core.serializers import serialize
from django.views.decorators.csrf import csrf_exempt
import json
from django.db.models import Prefetch

# =======================
# Views for DeviceType
# =======================

def device_type_list(request):
    device_types = DeviceType.objects.all()
    return render(request, 'dashboard/device_type_list.html', {'device_types': device_types})

def device_type_detail(request, device_type_id):
    device_type = get_object_or_404(DeviceType, pk=device_type_id)
    monitors = PatientMonitor.objects.filter(devicetypedefinesmonitor__device_type=device_type)
    return render(request, 'dashboard/device_type_detail.html', {
        'device_type': device_type,
        'monitors': monitors,
    })

# API view for DeviceType
def device_type_list_api(request):
    device_types = DeviceType.objects.values()
    return JsonResponse(list(device_types), safe=False)

# =======================
# Views for Staff
# =======================

def staff_list(request):
    staff_members = Staff.objects.all()
    return render(request, 'dashboard/staff_list.html', {'staff_members': staff_members})

def staff_detail(request, staff_id):
    staff_member = get_object_or_404(Staff, pk=staff_id)
    patients = Patient.objects.filter(primary_physician=staff_member)
    actions_taken = StaffTakesAction.objects.filter(staff=staff_member)
    return render(request, 'dashboard/staff_detail.html', {
        'staff_member': staff_member,
        'patients': patients,
        'actions_taken': actions_taken,
    })

# API view for Staff
def staff_list_api(request):
    staff_members = Staff.objects.values()
    return JsonResponse(list(staff_members), safe=False)

# =======================
# Views for Patient
# =======================

def patient_list(request):
    patients = Patient.objects.all()
    return render(request, 'dashboard/patient_list.html', {'patients': patients})

def patient_detail(request, patient_id):
    patient = get_object_or_404(Patient, pk=patient_id)
    vitals_records = VitalRecord.objects.filter(
        patienthasvitalrecord__patient=patient
    ).order_by('-timestamp')
    return render(request, 'dashboard/patient_detail.html', {
        'patient': patient,
        'vitals_records': vitals_records,
    })

# API view for Patient
def patient_list_api(request):
    patients = Patient.objects.values()
    return JsonResponse(list(patients), safe=False)

# =======================
# Views for PatientMonitor
# =======================

def monitor_list(request):
    monitors = PatientMonitor.objects.all()
    return render(request, 'dashboard/monitor_list.html', {'monitors': monitors})

def monitor_detail(request, monitor_id):
    monitor = get_object_or_404(PatientMonitor, pk=monitor_id)
    assigned_patients = PatientMonitorAssignment.objects.filter(monitor=monitor)
    vital_records = VitalRecord.objects.filter(
        monitorrecordsvital__monitor=monitor
    ).order_by('-timestamp')
    return render(request, 'dashboard/monitor_detail.html', {
        'monitor': monitor,
        'assigned_patients': assigned_patients,
        'vital_records': vital_records,
    })

# API view for PatientMonitor
def monitor_list_api(request):
    monitors = PatientMonitor.objects.values()
    return JsonResponse(list(monitors), safe=False)

# =======================
# Views for VitalRecord
# =======================

def vital_record_list(request):
    vital_records = VitalRecord.objects.all().order_by('-timestamp')
    return render(request, 'dashboard/vital_record_list.html', {'vital_records': vital_records})

def vital_record_detail(request, record_id):
    vital_record = get_object_or_404(VitalRecord, pk=record_id)
    patients = Patient.objects.filter(
        patienthasvitalrecord__vital_record=vital_record
    )
    alerts = Alert.objects.filter(
        vitalrecordtriggersalert__vital_record=vital_record
    )
    return render(request, 'dashboard/vital_record_detail.html', {
        'vital_record': vital_record,
        'patients': patients,
        'alerts': alerts,
    })

# API view for VitalRecord
def vital_record_list_api(request):
    vital_records = VitalRecord.objects.values()
    return JsonResponse(list(vital_records), safe=False)

# =======================
# Views for Alert
# =======================

def alert_list(request):
    alerts = Alert.objects.all().order_by('-timestamp')
    return render(request, 'dashboard/alert_list.html', {'alerts': alerts})

def alert_detail(request, alert_id):
    alert = get_object_or_404(Alert, pk=alert_id)
    vital_records = VitalRecord.objects.filter(
        vitalrecordtriggersalert__alert=alert
    )
    actions_required = AlertRequiresAction.objects.filter(alert=alert)
    actions_taken = StaffTakesAction.objects.filter(alert=alert)
    return render(request, 'dashboard/alert_detail.html', {
        'alert': alert,
        'vital_records': vital_records,
        'actions_required': actions_required,
        'actions_taken': actions_taken,
    })

# API view for Alert
def alert_list_api(request):
    alerts = Alert.objects.values()
    return JsonResponse(list(alerts), safe=False)

# =======================
# Views for StaffTakesAction
# =======================

def staff_takes_action_list(request):
    actions = StaffTakesAction.objects.all().order_by('-action_timestamp')
    return render(request, 'dashboard/staff_takes_action_list.html', {'actions': actions})


def staff_takes_action_detail(request, staff_id, alert_id, action_timestamp):
    # Parse the action_timestamp string into a datetime object
    action_timestamp = parse_datetime(action_timestamp)
    action = get_object_or_404(
        StaffTakesAction,
        staff_id=staff_id,
        alert_id=alert_id,
        action_timestamp=action_timestamp
    )
    return render(request, 'dashboard/staff_takes_action_detail.html', {'action': action})

# API view for StaffTakesAction
def staff_takes_action_list_api(request):
    actions = StaffTakesAction.objects.values()
    return JsonResponse(list(actions), safe=False)

# =======================
# Additional Views as Needed
# =======================

def dashboard_home(request):
    return render(request, 'dashboard/dashboard_home.html')

# You can continue defining views for other models like DeviceTypeDefinesMonitor,
# MonitorRecordsVital, PatientMonitorAssignment, etc., following similar patterns.

