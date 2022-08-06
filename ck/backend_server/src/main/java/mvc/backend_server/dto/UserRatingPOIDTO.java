package mvc.backend_server.dto;

import lombok.Data;
import mvc.backend_server.entity.Account;
import mvc.backend_server.entity.POI;

import javax.persistence.*;
import java.sql.Date;

@Data
public class UserRatingPOIDTO {

    private int ratingId;
    private int rate;
    private String comment;
    private Date timeCreate;
    private int accountId;
    private int poiId;
}
