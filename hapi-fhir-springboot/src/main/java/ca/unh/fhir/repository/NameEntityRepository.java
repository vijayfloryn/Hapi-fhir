package ca.unh.fhir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.unh.fhir.entity.NameEntity;

public interface NameEntityRepository extends JpaRepository<NameEntity, Long> {

}
