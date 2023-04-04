package ca.unh.fhir.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ca.unh.fhir.entity.ChildResponse;
import ca.unh.fhir.entity.ExtensionEntity;
import ca.unh.fhir.entity.IdentifierEntity;
import ca.unh.fhir.entity.LoginResponse;
import ca.unh.fhir.entity.NameEntity;
import ca.unh.fhir.entity.OtpEntity;
import ca.unh.fhir.entity.PatientEntity;
import ca.unh.fhir.entity.PatientResource;
import ca.unh.fhir.entity.PatientResource1;
import ca.unh.fhir.entity.SmsEntity;
import ca.unh.fhir.helper.ChildIdGenerator;
import ca.unh.fhir.repository.ChildRepository;
import ca.unh.fhir.service.PatientService;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/fhir")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@Autowired
	private ChildIdGenerator childIdGenerator;
	
	@Autowired
	private ChildRepository childRepository;
	

	@PostMapping("/Patient")
	public PatientEntity savePatientEntity(@RequestBody PatientEntity patientEntity) {
		PatientEntity savePatientEntity = patientService.savePatientEntity(patientEntity);
		return savePatientEntity;
	}
	
	@PostMapping("/child")
	public PatientResource1 saveChildEntity(@RequestBody PatientResource1 patientResource1) {
		 List<ExtensionEntity> listExtension= new ArrayList<>();
         ExtensionEntity extensionEntity= new ExtensionEntity();
         extensionEntity.setUrl("http://example.com/extensions#childId");
         extensionEntity.setValueString(childIdGenerator.generateChildId());
         listExtension.add(extensionEntity);
        patientResource1.setExtension(listExtension);
        patientResource1.setId(extensionEntity.getValueString());
		PatientResource1 savePatientEntity = patientService.saveChildEntity(patientResource1);
		return savePatientEntity;
	}
	
	@GetMapping("/Patient/{id}")
	public Optional<PatientEntity> getPatientEntityById(@PathVariable long id) {
		Optional<PatientEntity> patientEntityById = patientService.getPatientEntityById(id);
		System.out.println("vijay"+patientEntityById);
		return patientEntityById;
	}
	
	@DeleteMapping("/Patient/{id}")
	public String deleteByPatientEntityById(@PathVariable long id) {
		String deleteByPatientEntityById = patientService.deleteByPatientEntityById(id);
		return deleteByPatientEntityById;
	}
	
	
	@PostMapping("/verifyOtp")
	public LoginResponse VerifyOtp(@RequestBody SmsEntity entity) {
		LoginResponse loginApi = patientService.verifyOtp1(entity);
		return loginApi;
		
	} 
	
	@GetMapping("/Patientuu/{phoneNumber}")
	public List<PatientEntity> getByPatientEntityByMobileNo(@PathVariable String phoneNumber) {
		List<PatientEntity> deleteByPatientEntityByMobileno = patientService.getPatientEntityByphoneNumber(phoneNumber);
		return deleteByPatientEntityByMobileno;
	}
	
	
	 @PostMapping("/sendOtp")
	    public SmsEntity sendOtp(@RequestBody SmsEntity entity) {
	        // send OTP to mobile number
	        SmsEntity saveOtp = patientService.saveOtp(entity);
	        return saveOtp;
	    }
	 
	 
	 @GetMapping("/hhhh")
	 private static void getEmployees()
	 {
	     final String uri = "http://localhost:8080/fhir/Patient/1";

	     RestTemplate restTemplate = new RestTemplate();
	     String result = restTemplate.getForObject(uri, String.class);

	     System.out.println(result);
	 }
	 
	 
	 @PostMapping("/post")
	 private static void creEmployees()
	 {
	     final String uri = "http://localhost:8080/fhir/Patient";
	     List<ExtensionEntity> listExtension= new ArrayList<>();
         ExtensionEntity extensionEntity= new ExtensionEntity();
         extensionEntity.setUrl("http://example.com/extensions#childId");
         extensionEntity.setValueString("Child00001");
         listExtension.add(extensionEntity);
	     RestTemplate restTemplate = new RestTemplate();
	     HttpHeaders headers = new HttpHeaders();
	     headers.setContentType(MediaType.APPLICATION_JSON);
	     PatientResource request = new PatientResource();
	     request.setResourceType("Patient");
	     request.setIdentifier(null);
	     request.setGender("male");
	     request.setBirthDate("1980-01-01");
	     request.setName(null);
	     request.setExtension(listExtension);
	     HttpEntity<PatientResource> entity = new HttpEntity<>(request, headers);
	     ResponseEntity<PatientResource> postForEntity = restTemplate.postForEntity(uri, entity, PatientResource.class);

	     System.out.println(postForEntity.getBody());
	 }
	 
	 @PostMapping("/patientpost")
	 private ResponseEntity<PatientResource> createEmployees(@RequestBody PatientResource patientResource)
	 {
	     final String uri = "http://localhost:8080/fhir/Patient";
	     RestTemplate restTemplate = new RestTemplate();
	     HttpHeaders headers = new HttpHeaders();
	     headers.setContentType(MediaType.APPLICATION_JSON);
	     List<ExtensionEntity> listExtension= new ArrayList<>();
         ExtensionEntity extensionEntity= new ExtensionEntity();
         extensionEntity.setUrl("http://example.com/extensions#childId");
         extensionEntity.setValueString(childIdGenerator.generateChildId());
         listExtension.add(extensionEntity);
         patientResource.setExtension(listExtension);
	     HttpEntity<PatientResource> entity = new HttpEntity<>(patientResource, headers);
	     ResponseEntity<PatientResource> postForEntity = restTemplate.postForEntity(uri, entity, PatientResource.class);
	     return postForEntity;
	 }
	 
	 
	 @GetMapping("/Patient1/{id}")
		public Optional<PatientEntity> getPatientEntityByChildID() {
			return null;
		//	Optional<PatientEntity> patientEntityById = patientService.getPatientEntityById(id);
		//	return patientEntityById;
		}
	 
	

	 @GetMapping("/childff1/{id}")
	 public  Optional<PatientResource> getPatientResource1ById1(@PathVariable String id) {
		 List<IdentifierEntity> listIdentifierEntities= new ArrayList<IdentifierEntity>();
		 List<NameEntity> listNameEntities= new ArrayList<NameEntity>();
		 List<ExtensionEntity> listExtensionEntities= new ArrayList<ExtensionEntity>();
		 PatientResource patientResource= new PatientResource();
		 Optional<PatientResource1> findById = childRepository.findById(id);
		 patientResource.setId(findById.get().getId());
		 patientResource.setResourceType(findById.get().getResourceType());
		 patientResource.setGender(findById.get().getGender());
		 patientResource.setBirthDate(findById.get().getBirthDate());
//		 patientResource.setExtension();
		 List<IdentifierEntity> identifier = findById.get().getIdentifier();
		 for (IdentifierEntity identifierEntity : identifier) {
			 IdentifierEntity identifierEntity2= new IdentifierEntity();
			 identifierEntity2.setValue(identifierEntity.getValue());
			 identifierEntity2.setSystem(identifierEntity.getSystem());
			 listIdentifierEntities.add(identifierEntity2);
		}
		 patientResource.setIdentifier(listIdentifierEntities);
		 List<NameEntity> name = findById.get().getName();
		 for (NameEntity nameEntity : name) {
			 NameEntity entity= new NameEntity();
			 entity.setGiven(nameEntity.getGiven());
			 entity.setFamily(nameEntity.getFamily());
			 listNameEntities.add(entity);
		}
		 patientResource.setName(listNameEntities);
		 List<ExtensionEntity> extension = findById.get().getExtension();
		 for (ExtensionEntity extensionEntity : extension) {
			 ExtensionEntity entity=new ExtensionEntity();
			 entity.setUrl(extensionEntity.getUrl());
			 entity.setValueString(extensionEntity.getValueString());
			 listExtensionEntities.add(entity);
		}
		 patientResource.setExtension(listExtensionEntities);
		 Optional<PatientResource> optionalChildResponse = Optional.of(patientResource);
		return optionalChildResponse;
	 }
	 
	 	 
	 @GetMapping("/home")
	 public List<PatientResource> findAllPatientResource1() {
	     List<PatientResource1> findAll = childRepository.findAll();
	     List<PatientResource> listResources = new ArrayList<>();
	     for (PatientResource1 patientResource1 : findAll) {
	         PatientResource patientResource = new PatientResource();
	         patientResource.setId(patientResource1.getId());
	         patientResource.setResourceType(patientResource1.getResourceType());
	         patientResource.setGender(patientResource1.getGender());
	         patientResource.setBirthDate(patientResource1.getBirthDate());

	         List<IdentifierEntity> listIdentifierEntities = new ArrayList<>();
	         for (IdentifierEntity identifierEntity : patientResource1.getIdentifier()) {
	             IdentifierEntity identifierEntity2 = new IdentifierEntity();
	             identifierEntity2.setValue(identifierEntity.getValue());
	             identifierEntity2.setSystem(identifierEntity.getSystem());
	             listIdentifierEntities.add(identifierEntity2);
	         }
	         patientResource.setIdentifier(listIdentifierEntities);

	         List<NameEntity> listNameEntities = new ArrayList<>();
	         List<NameEntity> name = patientResource1.getName();
	         for (NameEntity nameEntity : name) {
	             NameEntity entity = new NameEntity();
	             entity.setGiven(nameEntity.getGiven());
	             entity.setFamily(nameEntity.getFamily());
	             listNameEntities.add(entity);
	         }
	         patientResource.setName(listNameEntities);

	         List<ExtensionEntity> listExtensionEntities = new ArrayList<>();
	         List<ExtensionEntity> extension = patientResource1.getExtension();
	         for (ExtensionEntity extensionEntity : extension) {
	             ExtensionEntity entity = new ExtensionEntity();
	             entity.setUrl(extensionEntity.getUrl());
	             entity.setValueString(extensionEntity.getValueString());
	             listExtensionEntities.add(entity);
	         }
	         patientResource.setExtension(listExtensionEntities);

	         listResources.add(patientResource);
	     }
	     return listResources;
	 }

	   
	
}
