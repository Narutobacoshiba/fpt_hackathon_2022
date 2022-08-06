package mvc.backend_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "country_id")
    private int id;

    @Column(name = "country_name")
    private String name;

    @OneToMany(mappedBy = "country", orphanRemoval = true)
    @JsonIgnore
    private List<City> cities;

}
