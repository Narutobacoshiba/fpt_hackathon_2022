package mvc.backend_server.entity;

import lombok.Data;
import mvc.backend_server.repository.BusinessTourRepo;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "distance")
@IdClass(RelationshipPK.class)
public class Distance implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "start_station", nullable = false)
    private POI startStation;

    @Id
    @ManyToOne
    @JoinColumn(name = "end_station", nullable = false)
    private POI endStation;

    @Column(name = "distance")
    private double distance;

    public POI getStartStation() {
        return startStation;
    }

    public void setStartStation(POI startStation) {
        this.startStation = startStation;
    }

    public POI getEndStation() {
        return endStation;
    }

    public void setEndStation(POI endStation) {
        this.endStation = endStation;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
