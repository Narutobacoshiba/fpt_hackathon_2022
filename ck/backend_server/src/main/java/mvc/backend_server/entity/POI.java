package mvc.backend_server.entity;

import lombok.Data;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "day_of_week", nullable = false)
    private BusinessTour businessTour;
}
