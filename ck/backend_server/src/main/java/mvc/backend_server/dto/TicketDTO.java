package mvc.backend_server.dto;

import lombok.Data;
import mvc.backend_server.entity.Account;
import mvc.backend_server.entity.TravelService;

import javax.persistence.*;

@Data
public class TicketDTO {

    private int id;
    private double price;
    private int type;
    private int accountId;
    private int travelServiceId;
}
