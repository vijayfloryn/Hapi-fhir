package ca.unh.fhir.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "child_extension")
public class ExtensionEntity {
	
	 @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	private String url;
	private String valueString;
	@ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "child_id")
	  private PatientResource1 child;
	
	
	public PatientResource1 getChild() {
		return child;
	}
	public void setChild(PatientResource1 child) {
		this.child = child;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getValueString() {
		return valueString;
	}
	public void setValueString(String valueString) {
		this.valueString = valueString;
	}
	
	
	
}
