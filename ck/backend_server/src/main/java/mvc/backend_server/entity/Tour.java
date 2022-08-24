package mvc.backend_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tour")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_id")
    private int id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    //@ManyToOne
    @Column(name = "account_id", nullable = false)
    private String account;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tour", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<DayOfTrip> listDays;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public List<DayOfTrip> getListDays() {
        return listDays;
    }

    public void setListDays(List<DayOfTrip> listDays) {
        this.listDays = listDays;
    }

    public void addDay(DayOfTrip day){
        listDays.add(day);
        day.setTour(this);
    }
}
