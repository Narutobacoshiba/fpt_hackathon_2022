package mvc.backend_server.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private int id;

    @Column(columnDefinition = "DECIMAL(19)")
    private double price;

    @Column(name = "ticket_type", columnDefinition = "TinyInt(1)")
    private int type;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "travel_service_id", nullable = false)
    private TravelService travelService;
}
