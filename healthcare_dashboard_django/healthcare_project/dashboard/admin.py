from django.contrib import admin

from .models import (
    DeviceType, Staff, Patient, PatientMonitor, VitalRecord, Alert,
    DeviceTypeDefinesMonitor, MonitorRecordsVital, PatientHasVitalRecord,
    VitalRecordTriggersAlert, AlertRequiresAction, StaffTakesAction,
    StaffHandlesPatient, PatientMonitorAssignment
)

admin.site.register(DeviceType)
admin.site.register(Staff)
admin.site.register(Patient)
admin.site.register(PatientMonitor)
admin.site.register(VitalRecord)
admin.site.register(Alert)
# For intermediate models, you might create custom admin classes

