package ca.unh.fhir.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Child")
public class PatientResource1 {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String resourceType;
	@ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "patient_id",referencedColumnName = "id")
	  private PatientEntity patient;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	  @JoinColumn(name = "child_id",referencedColumnName = "id")
    private List<IdentifierEntity> identifier;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	  @JoinColumn(name = "child_id",referencedColumnName = "id")
    private List<NameEntity> name;
    private String gender;
    private String birthDate;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "child_id",referencedColumnName = "id")
    private List<ExtensionEntity> extension;
    
    @OneToMany(targetEntity = PatientEntity.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "child_id", referencedColumnName = "id")
    private List<PatientEntity> patientEntity;
    
    

    // Getters and setters for all attributes

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<PatientEntity> getPatientEntity() {
		return patientEntity;
	}

	public void setPatientEntity(List<PatientEntity> patientEntity) {
		this.patientEntity = patientEntity;
	}


    public List<ExtensionEntity> getExtension() {
		return extension;
	}

	public void setExtension(List<ExtensionEntity> extension) {
		this.extension = extension;
	}

	public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public List<IdentifierEntity> getIdentifier() {
        return identifier;
    }

    public void setIdentifier(List<IdentifierEntity> identifier) {
        this.identifier = identifier;
    }

    public List<NameEntity> getName() {
        return name;
    }

    public void setName(List<NameEntity> name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}

