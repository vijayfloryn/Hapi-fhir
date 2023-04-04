package ca.unh.fhir.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "child_name")
public class NameEntity {
	 @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
    private List<String> given;
    private String family;
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

	public List<String> getGiven() {
        return given;
    }

    public void setGiven(List<String> given) {
        this.given = given;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}