package ca.unh.fhir.service;

import java.util.List;
import java.util.Optional;

import ca.unh.fhir.entity.LoginResponse;
import ca.unh.fhir.entity.OtpEntity;
import ca.unh.fhir.entity.PatientEntity;
import ca.unh.fhir.entity.PatientResource1;
import ca.unh.fhir.entity.SmsEntity;

public interface PatientService {
	
	public PatientEntity savePatientEntity(PatientEntity patientEntity);
	public Optional<PatientEntity> getPatientEntityById(long id);
	public String deleteByPatientEntityById(long id);
	public List<PatientEntity> getPatientEntityByphoneNumber(String phoneNumber);
	public SmsEntity saveOtp(SmsEntity entity);
	public String getOtp(String mobileNo);
	 public void deleteOtp(String mobileNo);
	LoginResponse verifyOtp1(SmsEntity entity);
	PatientResource1 saveChildEntity(PatientResource1 patientResource1);
	

}
