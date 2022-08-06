package mvc.backend_server.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;


@Data
@Entity
@Table(name = "travler_rating")
public class TravelerRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private int ratingId;

    @Column(name = "rate")
    private int rate;

    @Column(name = "comment")
    private String comment;

    @Column(name ="time_create")
    private Date timeCreate;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "travel_service_id", nullable = false)
    private TravelService travelService;
}
