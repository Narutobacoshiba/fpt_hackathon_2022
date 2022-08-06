package mvc.backend_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "travel_service")
public class TravelService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "travel_service_id")
    private int id;

    @Column(name = "travel_service_name")
    private String name;

    @Column(name = "total_rating", columnDefinition = "DECIMAL(19)")
    private double totalRating;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @ManyToOne
    @JoinColumn(name = "travel_service_type_type_id", nullable = false)
    private TravelServiceType travelServiceType;

    @OneToMany(mappedBy = "travelService", orphanRemoval = true)
    @JsonIgnore
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "travelService", orphanRemoval = true)
    @JsonIgnore
    private List<TravelerRating> travelerRatingList;
}
