package ca.unh.fhir.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.unh.fhir.entity.PatientEntity;
import ca.unh.fhir.entity.PatientResource1;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long>{

	PatientResource1 save(PatientResource1 patientResource1);
	
//	public PatientEntity findByOtp(String otp);
	public List<PatientEntity> findByPhoneNumber(String phoneNumber);
	
	

}
