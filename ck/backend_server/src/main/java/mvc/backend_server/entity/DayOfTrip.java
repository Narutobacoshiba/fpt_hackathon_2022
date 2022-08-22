package mvc.backend_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "day_of_trip")
public class DayOfTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "day_id")
    private int id;

    @Column(name="number")
    private int number;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "tour_id", nullable = false)
    private Tour tour;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dayOfTrip")
    @JsonIgnore
    private List<POIOfDay> listPOIs;
}
