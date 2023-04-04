package ca.unh.fhir.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import ca.unh.fhir.entity.LoginResponse;
import ca.unh.fhir.entity.OtpEntity;
import ca.unh.fhir.entity.PatientEntity;
import ca.unh.fhir.entity.PatientResource1;
import ca.unh.fhir.entity.SmsEntity;
import ca.unh.fhir.repository.ChildRepository;
import ca.unh.fhir.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository repository;
	
	@Autowired
	private ChildRepository childRepository;

	@Autowired
	private StringRedisTemplate redisTemplate;



	@Override
	public PatientEntity savePatientEntity(PatientEntity patientEntity) {
	//	patientEntity.setOtp(generateOTP());
		PatientEntity savePatientEntity = repository.save(patientEntity);
		return savePatientEntity;
	}
	
	
	@Override
	public PatientResource1 saveChildEntity(PatientResource1 patientResource1) {
	//	patientEntity.setOtp(generateOTP());
		PatientResource1 savePatientEntity = repository.save(patientResource1);
		return savePatientEntity;
	}

	@Override
	public Optional<PatientEntity> getPatientEntityById(long id) {
		Optional<PatientEntity> byIdPatientEntity = repository.findById(id);
		return byIdPatientEntity;
	}

	@Override
	public String deleteByPatientEntityById(long id) {
		repository.deleteById(id);
		return "Delete Sucessfully->" + id;
	}

	public static String generateOTP() {
		int OTP_LENGTH = 4; // Set the length of the OTP code
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < OTP_LENGTH; i++) {
			sb.append(random.nextInt(10));
		}
		return sb.toString();
	}

	@Override
	public List<PatientEntity> getPatientEntityByphoneNumber(String phoneNumber) {
		List<PatientEntity> findByMobleNo = repository.findByPhoneNumber(phoneNumber);
        
		return findByMobleNo;
	}

	public SmsEntity saveOtp(SmsEntity entity) {
		int OTP_LENGTH = 4; // Set the length of the OTP code
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < OTP_LENGTH; i++) {
			sb.append(random.nextInt(10));
		}
		entity.setOtp(sb.toString());
		redisTemplate.opsForValue().set(entity.getMobileNo(), sb.toString(), 5, TimeUnit.MINUTES);
		return entity;
	}

	public String getOtp(String mobileNo) {
		return redisTemplate.opsForValue().get(mobileNo);
	}

	public void deleteOtp(String mobileNo) {
		redisTemplate.delete(mobileNo);
	}

	@Override
	public LoginResponse verifyOtp1(SmsEntity entity) {
		LoginResponse response = new LoginResponse();
		String cacheOtp = redisTemplate.opsForValue().get(entity.getMobileNo());
		String otpVerify;
		// System.out.println(findById.get().getOtp());
		if (cacheOtp.equals(entity.getOtp())) {
			otpVerify = "Otp is validate Successfully ";
			response.setStatus(otpVerify);
			List<PatientEntity> patientEntityBymobileNo = getPatientEntityByphoneNumber(entity.getMobileNo());
			if (!patientEntityBymobileNo.isEmpty()) {
				List<PatientEntity> findByPhoneNumber = repository.findByPhoneNumber(entity.getMobileNo());
				response.setUsertype("User_Exist");
				
				response.setEntities(findByPhoneNumber);
				deleteOtp(entity.getMobileNo());
			} else {
				response.setUsertype("New_User");
				deleteOtp(entity.getMobileNo());
			}

		} else {
			otpVerify = "Otp is InValid ";
			response.setStatus(otpVerify);
			response.setUsertype(null);
		}

		return response;
	}

}
