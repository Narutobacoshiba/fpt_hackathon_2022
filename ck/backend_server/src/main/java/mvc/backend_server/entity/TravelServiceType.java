package mvc.backend_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "travel_service_type")
public class TravelServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private int typeId;

    @Column(name = "type_name")
    private String typeName;

    @OneToMany(mappedBy = "travelServiceType", orphanRemoval = true)
    @JsonIgnore
    private List<TravelService> travelServiceList;
}
