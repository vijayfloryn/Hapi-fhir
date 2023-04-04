package ca.unh.fhir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.unh.fhir.entity.PointEntity;
import ca.unh.fhir.repository.MyRepository;
 
@Service
public class PointService {
 
    @Autowired
    private MyRepository pointRepository;
 
    public PointEntity save(PointEntity pointEntity) {
        return pointRepository.save(pointEntity);
    }
}
