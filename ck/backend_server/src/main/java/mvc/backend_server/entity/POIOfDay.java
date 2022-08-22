package mvc.backend_server.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "poi_of_day")
public class POIOfDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="number")
    private int number;

    @ManyToOne
    @JoinColumn(name = "poi_id", nullable = false)
    private POI poi;

    @ManyToOne
    @JoinColumn(name = "day_id", nullable = false)
    private DayOfTrip dayOfTrip;

    @Column(name = "start_time")
    private int startTime;

    @Column(name = "end_time")
    private int endTime;
}
