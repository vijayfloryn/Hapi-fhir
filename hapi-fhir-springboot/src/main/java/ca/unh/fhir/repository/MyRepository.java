package ca.unh.fhir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.unh.fhir.entity.PointEntity;

@Repository
public interface MyRepository extends JpaRepository<PointEntity, Long> {

}
