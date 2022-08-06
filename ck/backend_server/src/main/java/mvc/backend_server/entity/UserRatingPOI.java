package mvc.backend_server.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "user_rating_POI")
public class UserRatingPOI {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @JoinColumn(name = "POI_id", nullable = false)
    private POI poi;
}
