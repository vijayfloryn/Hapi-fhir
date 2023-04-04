package ca.unh.fhir.entity;

import com.vividsolutions.jts.geom.Point;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "points")
public class PointEntity {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
  //  @Column(nullable = false, columnDefinition = "geometry(Point,4326)")
    private Point point;
 
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public PointEntity() {}
 
    public PointEntity(Point point) {
        this.point = point;
    }

	@Override
	public String toString() {
		return "PointEntity [id=" + id + ", point=" + point + "]";
	}
 
    // getters and setters
}
