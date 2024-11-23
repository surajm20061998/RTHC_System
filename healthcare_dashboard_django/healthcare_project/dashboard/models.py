from django.db import models

# DeviceType model
class DeviceType(models.Model):
    deviceType_id = models.AutoField(primary_key=True)
    name = models.CharField(max_length=255)
    description = models.TextField()
    manufacturer = models.CharField(max_length=255)
    model_series = models.CharField(max_length=255)
    monitoring_capabilities = models.TextField()

    class Meta:
        db_table = 'devicetype'

    def __str__(self):
        return f"{self.name}"

# Staff model
class Staff(models.Model):
    staff_id = models.AutoField(primary_key=True)
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    ssn = models.CharField(max_length=20, unique=True)
    date_of_birth = models.DateField(null=True, blank=True)
    email = models.EmailField(unique=True)
    phone = models.CharField(max_length=50)
    role = models.CharField(max_length=100)
    department = models.CharField(max_length=100)
    hire_date = models.DateField(null=True, blank=True)
    license_number = models.CharField(max_length=50)
    status = models.CharField(max_length=50)

    class Meta:
        db_table = 'staff'

    def __str__(self):
        return f"{self.first_name} {self.last_name}"

# Patient model
class Patient(models.Model):
    patient_id = models.AutoField(primary_key=True)
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    ssn = models.CharField(max_length=20, unique=True)
    date_of_birth = models.DateField(null=True, blank=True)
    gender = models.CharField(max_length=20)
    blood_type = models.CharField(max_length=5)
    primary_physician = models.ForeignKey(
        Staff, on_delete=models.SET_NULL, null=True, related_name='patients'
    )
    admission_date = models.DateField(null=True, blank=True)
    discharge_date = models.DateField(null=True, blank=True)
    status = models.CharField(max_length=50)

    class Meta:
        db_table = 'patient'

    def __str__(self):
        return f"{self.first_name} {self.last_name}"

# PatientMonitor model
class PatientMonitor(models.Model):
    monitor_id = models.AutoField(primary_key=True)
    serial_number = models.CharField(max_length=255, unique=True)
    manufacturer = models.CharField(max_length=255)
    model_number = models.CharField(max_length=255)
    last_maintenance_date = models.DateField(null=True, blank=True)
    calibration_date = models.DateField(null=True, blank=True)
    status = models.CharField(max_length=50)

    class Meta:
        db_table = 'patientmonitor'

    def __str__(self):
        return f"Monitor {self.serial_number}"

# VitalRecord model
class VitalRecord(models.Model):
    record_id = models.AutoField(primary_key=True)
    timestamp = models.DateTimeField()
    heart_rate = models.IntegerField(null=True, blank=True)
    blood_pressure_systolic = models.IntegerField(null=True, blank=True)
    blood_pressure_diastolic = models.IntegerField(null=True, blank=True)
    temperature = models.DecimalField(max_digits=5, decimal_places=2, null=True, blank=True)
    respiratory_rate = models.IntegerField(null=True, blank=True)
    oxygen_saturation = models.IntegerField(null=True, blank=True)

    class Meta:
        db_table = 'vitalrecords'

    def __str__(self):
        return f"Vital Record {self.record_id}"

# Alert model
class Alert(models.Model):
    alert_id = models.AutoField(primary_key=True)
    timestamp = models.DateTimeField()
    alert_type = models.CharField(max_length=100)
    severity = models.CharField(max_length=50)
    description = models.TextField()
    status = models.CharField(max_length=50)

    class Meta:
        db_table = 'alert'

    def __str__(self):
        return f"Alert {self.alert_id}"

# DeviceTypeDefinesMonitor model (Intermediate model with extra fields)
class DeviceTypeDefinesMonitor(models.Model):
    device_type = models.ForeignKey(DeviceType, on_delete=models.CASCADE)
    monitor = models.ForeignKey(PatientMonitor, on_delete=models.CASCADE)
    definition_date = models.DateField(null=True, blank=True)
    configured_by_staff = models.ForeignKey(
        Staff, on_delete=models.SET_NULL, null=True, blank=True
    )

    class Meta:
        db_table = 'devicetype_defines_monitor'
        unique_together = (('device_type', 'monitor'),)

    def __str__(self):
        return f"{self.device_type} defines {self.monitor}"

# MonitorRecordsVital model (Intermediate model with extra fields)
class MonitorRecordsVital(models.Model):
    monitor = models.ForeignKey(PatientMonitor, on_delete=models.CASCADE)
    vital_record = models.ForeignKey(VitalRecord, on_delete=models.CASCADE)
    recording_start_time = models.DateTimeField(null=True, blank=True)
    recording_end_time = models.DateTimeField(null=True, blank=True)
    data_quality_score = models.DecimalField(max_digits=5, decimal_places=2, null=True, blank=True)

    class Meta:
        db_table = 'monitor_records_vitals'
        unique_together = (('monitor', 'vital_record'),)

    def __str__(self):
        return f"Monitor {self.monitor_id} records Vital {self.vital_record_id}"

# PatientHasVitalRecord model (Intermediate model with extra fields)
class PatientHasVitalRecord(models.Model):
    patient = models.ForeignKey(Patient, on_delete=models.CASCADE)
    vital_record = models.ForeignKey(VitalRecord, on_delete=models.CASCADE)
    recorded_by_staff = models.ForeignKey(
        Staff, on_delete=models.SET_NULL, null=True, blank=True
    )
    recording_session_id = models.CharField(max_length=255)

    class Meta:
        db_table = 'patient_has_vitalrecords'
        unique_together = (('patient', 'vital_record'),)

    def __str__(self):
        return f"Patient {self.patient_id} has Vital Record {self.vital_record_id}"

# VitalRecordTriggersAlert model (Intermediate model with extra fields)
class VitalRecordTriggersAlert(models.Model):
    vital_record = models.ForeignKey(VitalRecord, on_delete=models.CASCADE)
    alert = models.ForeignKey(Alert, on_delete=models.CASCADE)
    trigger_threshold_value = models.DecimalField(max_digits=10, decimal_places=2)
    trigger_condition = models.CharField(max_length=255)
    trigger_timestamp = models.DateTimeField()

    class Meta:
        db_table = 'vitalrecords_triggers_alert'
        unique_together = (('vital_record', 'alert'),)

    def __str__(self):
        return f"Vital Record {self.vital_record_id} triggers Alert {self.alert_id}"

# AlertRequiresAction model (Intermediate model with extra fields)
class AlertRequiresAction(models.Model):
    alert = models.ForeignKey(Alert, on_delete=models.CASCADE)
    required_action_type = models.CharField(max_length=100)
    required_response_time = models.IntegerField()
    priority_level = models.CharField(max_length=50)
    escalation_threshold = models.IntegerField()

    class Meta:
        db_table = 'alert_requires_action'
        unique_together = (('alert', 'required_action_type'),)

    def __str__(self):
        return f"Alert {self.alert_id} requires action {self.required_action_type}"

# StaffTakesAction model (Intermediate model with extra fields)
class StaffTakesAction(models.Model):
    staff = models.ForeignKey(Staff, on_delete=models.CASCADE)
    alert = models.ForeignKey(Alert, on_delete=models.CASCADE)
    action_timestamp = models.DateTimeField(primary_key=True)
    action_taken = models.TextField()
    response_time = models.IntegerField()
    follow_up_required = models.BooleanField()

    class Meta:
        db_table = 'staff_takes_action'
        unique_together = (('staff', 'alert', 'action_timestamp'),)
        # Remove managed = False if present

    def __str__(self):
        return f"Staff {self.staff.staff_id} takes action on Alert {self.alert.alert_id}"


# StaffHandlesPatient model (Intermediate model with extra fields)
class StaffHandlesPatient(models.Model):
    staff = models.ForeignKey(Staff, on_delete=models.CASCADE)
    patient = models.ForeignKey(Patient, on_delete=models.CASCADE)
    assignment_start_date = models.DateField()
    assignment_end_date = models.DateField(null=True, blank=True)
    care_role = models.CharField(max_length=100)
    shift_schedule = models.CharField(max_length=100)

    class Meta:
        db_table = 'staff_handles_patient'
        unique_together = (('staff', 'patient', 'assignment_start_date'),)

    def __str__(self):
        return f"Staff {self.staff_id} handles Patient {self.patient_id}"

# PatientMonitorAssignment model (Intermediate model with extra fields)
class PatientMonitorAssignment(models.Model):
    patient = models.ForeignKey(Patient, on_delete=models.CASCADE)
    monitor = models.ForeignKey(PatientMonitor, on_delete=models.CASCADE)
    assignment_date = models.DateTimeField()
    end_date = models.DateTimeField(null=True, blank=True)
    assigned_by_staff = models.ForeignKey(
        Staff, on_delete=models.SET_NULL, null=True, blank=True
    )
    monitoring_protocol_id = models.CharField(max_length=255)

    class Meta:
        db_table = 'patientmonitorassignment'
        unique_together = (('patient', 'monitor', 'assignment_date'),)

    def __str__(self):
        return f"Patient {self.patient_id} assigned Monitor {self.monitor_id}"

