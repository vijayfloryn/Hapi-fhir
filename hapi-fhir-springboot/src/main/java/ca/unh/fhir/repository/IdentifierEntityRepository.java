package ca.unh.fhir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.unh.fhir.entity.IdentifierEntity;

@Repository
public interface IdentifierEntityRepository extends JpaRepository<IdentifierEntity,Long > {

}
