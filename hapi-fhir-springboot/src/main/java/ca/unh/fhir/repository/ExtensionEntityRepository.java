package ca.unh.fhir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.unh.fhir.entity.ExtensionEntity;

@Repository
public interface ExtensionEntityRepository extends JpaRepository<ExtensionEntity, Long> {

}
