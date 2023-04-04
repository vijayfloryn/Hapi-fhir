package ca.unh.fhir.entity;

import java.util.List;

public class PatientResource {
	
	private String id;
	private String resourceType;
    private List<IdentifierEntity> identifier;
    private List<NameEntity> name;
    private String gender;
    private String birthDate;
    private List<ExtensionEntity> extension;
    
    

    // Getters and setters for all attributes

   

    public List<ExtensionEntity> getExtension() {
		return extension;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
