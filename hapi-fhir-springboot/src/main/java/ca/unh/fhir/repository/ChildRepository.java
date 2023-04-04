package ca.unh.fhir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.unh.fhir.entity.PatientResource1;

@Repository
public interface ChildRepository extends JpaRepository<PatientResource1, String> {

}
