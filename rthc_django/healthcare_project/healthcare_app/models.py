# This is an auto-generated Django model module.
# You'll have to do the following manually to clean this up:
#   * Rearrange models' order
#   * Make sure each model has one field with primary_key=True
#   * Make sure each ForeignKey and OneToOneField has `on_delete` set to the desired behavior
#   * Remove `managed = False` lines if you wish to allow Django to create, modify, and delete the table
# Feel free to rename the models, but don't rename db_table values or field names.
from django.db import models


class Alert(models.Model):
    alert_id = models.AutoField(primary_key=True)
    timestamp = models.DateTimeField(blank=True, null=True)
    alert_type = models.CharField(max_length=100, blank=True, null=True)
    severity = models.CharField(max_length=50, blank=True, null=True)
    description = models.TextField(blank=True, null=True)
    status = models.CharField(max_length=50, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'Alert'


class AlertRequiresAction(models.Model):
    alert = models.OneToOneField(Alert, models.DO_NOTHING, primary_key=True)  # The composite primary key (alert_id, required_action_type) found, that is not supported. The first column is selected.
    required_action_type = models.CharField(max_length=100)
    required_response_time = models.IntegerField(blank=True, null=True)
    priority_level = models.CharField(max_length=50, blank=True, null=True)
    escalation_threshold = models.IntegerField(blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'Alert_Requires_Action'
        unique_together = (('alert', 'required_action_type'),)


class Devicetype(models.Model):
    devicetype_id = models.AutoField(db_column='deviceType_id', primary_key=True)  # Field name made lowercase.
    name = models.CharField(max_length=255, blank=True, null=True)
    description = models.TextField(blank=True, null=True)
    manufacturer = models.CharField(max_length=255, blank=True, null=True)
    model_series = models.CharField(max_length=255, blank=True, null=True)
    monitoring_capabilities = models.TextField(blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'DeviceType'


class DevicetypeDefinesMonitor(models.Model):
    devicetype = models.OneToOneField(Devicetype, models.DO_NOTHING, db_column='deviceType_id', primary_key=True)  # Field name made lowercase. The composite primary key (deviceType_id, monitor_id) found, that is not supported. The first column is selected.
    monitor = models.ForeignKey('Patientmonitor', models.DO_NOTHING)
    definition_date = models.DateField(blank=True, null=True)
    configured_by_staff = models.ForeignKey('Staff', models.DO_NOTHING, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'DeviceType_Defines_Monitor'
        unique_together = (('devicetype', 'monitor'),)


class MonitorRecordsVitals(models.Model):
    monitor = models.OneToOneField('Patientmonitor', models.DO_NOTHING, primary_key=True)  # The composite primary key (monitor_id, record_id) found, that is not supported. The first column is selected.
    record = models.ForeignKey('Vitalrecords', models.DO_NOTHING)
    recording_start_time = models.DateTimeField(blank=True, null=True)
    recording_end_time = models.DateTimeField(blank=True, null=True)
    data_quality_score = models.DecimalField(max_digits=5, decimal_places=2, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'Monitor_Records_Vitals'
        unique_together = (('monitor', 'record'),)


class Patient(models.Model):
    patient_id = models.AutoField(primary_key=True)
    first_name = models.CharField(max_length=255, blank=True, null=True)
    last_name = models.CharField(max_length=255, blank=True, null=True)
    ssn = models.CharField(unique=True, max_length=20, blank=True, null=True)
    date_of_birth = models.DateField(blank=True, null=True)
    gender = models.CharField(max_length=20, blank=True, null=True)
    blood_type = models.CharField(max_length=5, blank=True, null=True)
    primary_physician = models.ForeignKey('Staff', models.DO_NOTHING, blank=True, null=True)
    admission_date = models.DateField(blank=True, null=True)
    discharge_date = models.DateField(blank=True, null=True)
    status = models.CharField(max_length=50, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'Patient'


class Patientmonitor(models.Model):
    monitor_id = models.AutoField(primary_key=True)
    serial_number = models.CharField(unique=True, max_length=255, blank=True, null=True)
    manufacturer = models.CharField(max_length=255, blank=True, null=True)
    model_number = models.CharField(max_length=255, blank=True, null=True)
    last_maintenance_date = models.DateField(blank=True, null=True)
    calibration_date = models.DateField(blank=True, null=True)
    status = models.CharField(max_length=50, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'PatientMonitor'


class Patientmonitorassignment(models.Model):
    patient = models.OneToOneField(Patient, models.DO_NOTHING, primary_key=True)  # The composite primary key (patient_id, monitor_id, assignment_date) found, that is not supported. The first column is selected.
    monitor = models.ForeignKey(Patientmonitor, models.DO_NOTHING)
    assignment_date = models.DateTimeField()
    end_date = models.DateTimeField(blank=True, null=True)
    assigned_by_staff = models.ForeignKey('Staff', models.DO_NOTHING, blank=True, null=True)
    monitoring_protocol_id = models.CharField(max_length=255, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'PatientMonitorAssignment'
        unique_together = (('patient', 'monitor', 'assignment_date'),)


class PatientHasVitalrecords(models.Model):
    patient = models.OneToOneField(Patient, models.DO_NOTHING, primary_key=True)  # The composite primary key (patient_id, record_id) found, that is not supported. The first column is selected.
    record = models.ForeignKey('Vitalrecords', models.DO_NOTHING)
    recorded_by_staff = models.ForeignKey('Staff', models.DO_NOTHING, blank=True, null=True)
    recording_session_id = models.CharField(max_length=255, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'Patient_Has_VitalRecords'
        unique_together = (('patient', 'record'),)


class Staff(models.Model):
    staff_id = models.AutoField(primary_key=True)
    first_name = models.CharField(max_length=255, blank=True, null=True)
    last_name = models.CharField(max_length=255, blank=True, null=True)
    ssn = models.CharField(unique=True, max_length=20, blank=True, null=True)
    date_of_birth = models.DateField(blank=True, null=True)
    email = models.CharField(unique=True, max_length=255, blank=True, null=True)
    phone = models.CharField(max_length=50, blank=True, null=True)
    role = models.CharField(max_length=100, blank=True, null=True)
    department = models.CharField(max_length=100, blank=True, null=True)
    hire_date = models.DateField(blank=True, null=True)
    license_number = models.CharField(max_length=50, blank=True, null=True)
    status = models.CharField(max_length=50, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'Staff'


class StaffHandlesPatient(models.Model):
    staff = models.OneToOneField(Staff, models.DO_NOTHING, primary_key=True)  # The composite primary key (staff_id, patient_id, assignment_start_date) found, that is not supported. The first column is selected.
    patient = models.ForeignKey(Patient, models.DO_NOTHING)
    assignment_start_date = models.DateField()
    assignment_end_date = models.DateField(blank=True, null=True)
    care_role = models.CharField(max_length=100, blank=True, null=True)
    shift_schedule = models.CharField(max_length=100, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'Staff_Handles_Patient'
        unique_together = (('staff', 'patient', 'assignment_start_date'),)


class StaffTakesAction(models.Model):
    staff = models.OneToOneField(Staff, models.DO_NOTHING, primary_key=True)  # The composite primary key (staff_id, alert_id, action_timestamp) found, that is not supported. The first column is selected.
    alert = models.ForeignKey(Alert, models.DO_NOTHING)
    action_timestamp = models.DateTimeField()
    action_taken = models.TextField(blank=True, null=True)
    response_time = models.IntegerField(blank=True, null=True)
    follow_up_required = models.BooleanField(blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'Staff_Takes_Action'
        unique_together = (('staff', 'alert', 'action_timestamp'),)


class Vitalrecords(models.Model):
    record_id = models.AutoField(primary_key=True)
    timestamp = models.DateTimeField(blank=True, null=True)
    heart_rate = models.IntegerField(blank=True, null=True)
    blood_pressure_systolic = models.IntegerField(blank=True, null=True)
    blood_pressure_diastolic = models.IntegerField(blank=True, null=True)
    temperature = models.DecimalField(max_digits=5, decimal_places=2, blank=True, null=True)
    respiratory_rate = models.IntegerField(blank=True, null=True)
    oxygen_saturation = models.IntegerField(blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'VitalRecords'


class VitalrecordsTriggersAlert(models.Model):
    record = models.OneToOneField(Vitalrecords, models.DO_NOTHING, primary_key=True)  # The composite primary key (record_id, alert_id) found, that is not supported. The first column is selected.
    alert = models.ForeignKey(Alert, models.DO_NOTHING)
    trigger_threshold_value = models.DecimalField(max_digits=10, decimal_places=2, blank=True, null=True)
    trigger_condition = models.CharField(max_length=255, blank=True, null=True)
    trigger_timestamp = models.DateTimeField(blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'VitalRecords_Triggers_Alert'
        unique_together = (('record', 'alert'),)
