package ca.unh.fhir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;

import ca.unh.fhir.entity.PointEntity;
import ca.unh.fhir.service.PointService;
 
@Controller
public class PointController {
 
    @Autowired
    private PointService pointService;
 
    @PostMapping("/points")
    @ResponseBody
    public PointEntity createPoint(@RequestBody PointEntity pointRequest) {
        Point point = new GeometryFactory(new PrecisionModel(), 4326).createPoint(new Coordinate(12.34,56.38 ));
//        PointEntity pointEntity = new PointEntity(point);
//        System.out.println(pointEntity.toString());
        pointRequest.setPoint(point);
        return pointService.save(pointRequest);
    }
 
    public static class PointRequest {
 
        private Double x;
        private Double y;
		public Double getX() {
			return x;
		}
		public void setX(Double x) {
			this.x = x;
		}
		public Double getY() {
			return y;
		}
		public void setY(Double y) {
			this.y = y;
		}
 
        // getters and setters
    }
}
