package ca.unh.fhir.entity;

import java.util.List;

public class LoginResponse {
	
	private String status;
	
	private String usertype;
	
	private List<PatientEntity> entities;

	
	public List<PatientEntity> getEntities() {
		return entities;
	}
	public void setEntities(List<PatientEntity> entities) {
		this.entities = entities;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

}
