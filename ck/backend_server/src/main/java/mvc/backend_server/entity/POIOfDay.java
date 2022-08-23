package mvc.backend_server.entity;

import lombok.Data;
import mvc.backend_server.repository.BusinessTourRepo;

import javax.persistence.*;


@Data
@Entity
@Table(name = "poi_of_day")
public class POIOfDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="number")
    private int number;

    @ManyToOne
    @JoinColumn(name = "poi_id", nullable = false)
    private POI poi;

    @ManyToOne
    @JoinColumn(name = "day_id", nullable = false)
    private DayOfTrip dayOfTrip;

    @Column(name = "start_time")
    private int startTime;

    @Column(name = "end_time")
    private int endTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public POI getPoi() {
        return poi;
    }

    public void setPoi(POI poi) {
        this.poi = poi;
    }

    public DayOfTrip getDayOfTrip() {
        return dayOfTrip;
    }

    public void setDayOfTrip(DayOfTrip dayOfTrip) {
        this.dayOfTrip = dayOfTrip;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}