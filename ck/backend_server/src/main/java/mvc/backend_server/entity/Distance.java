package mvc.backend_server.entity;

import lombok.Data;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "distance")
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
}
