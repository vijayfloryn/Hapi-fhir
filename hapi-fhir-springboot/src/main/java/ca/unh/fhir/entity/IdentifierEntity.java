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
@Table(name = "child_identifier")
public class IdentifierEntity {
	
	 @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
    private String system;
    private String value;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "child_id")
    private PatientResource1 child;

    // Getters and setters for all attributes

    public PatientResource1 getChild() {
		return child;
	}

	public void setChild(PatientResource1 child) {
		this.child = child;
	}

	public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
