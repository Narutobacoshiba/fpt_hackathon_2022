package mvc.backend_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "POI")
public class POI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POI_id")
    private int POIId;

    @Column(name = "POI_name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "total_rating")
    private double totalRating;

    @Column(name = "price")
    private double price;

    @Column(name = "location")
    private String location;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @OneToMany(mappedBy = "startStation")
    @JsonIgnore
    private List<Distance> startStation;

    @OneToMany(mappedBy = "endStation")
    @JsonIgnore
    private List<Distance> endStation;
}
