package mvc.backend_server.dto;

import lombok.Data;
import mvc.backend_server.dto.CityDTO;
import mvc.backend_server.entity.BusinessTour;

import javax.persistence.*;

@Data
public class POIDTO {

    private int POIId;
    private String name;
    private String description;
    private double totalRating;
    private double price;
    private String location;
    private int cityId;
    private int dayOfWeek;
}
