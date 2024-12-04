from django.shortcuts import render, get_object_or_404
from .models import Patient, Vitalrecords, Staff

def patient_list(request):
    patients = Patient.objects.all()
    return render(request, 'healthcare_app/patient_list.html', {'patients': patients})

def patient_detail(request, patient_id):
    patient = get_object_or_404(Patient, pk=patient_id)
    vital_records = Vitalrecords.objects.filter(
        patient_has_vitalrecords__patient_id=patient_id
    )
    return render(request, 'healthcare_app/patient_detail.html', {
        'patient': patient,
        'vital_records': vital_records
    })
