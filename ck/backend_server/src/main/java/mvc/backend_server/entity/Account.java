package mvc.backend_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "account")
public class Account implements UserDetails {
    String ROLE_PREFIX = "ROLE_";

    @Id
    @Column(name = "account_id", columnDefinition = "VARCHAR(10)")
    private String id;

    @Column(name = "address")
    private String address;

    @Column(name = "date_of_birth")
    private Date DOB;

    @Column(name = "email")
    private String email;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "identity_card")
    private String identityCard;

    private String image;
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "register_date")
    private Date registerDate;

    @Column(name = "level")
    private Integer level;

    @Column(name = "level_point")
    private Integer levelPoint;

    @Column(columnDefinition = "TinyInt(1)")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
//    @Enumerated(EnumType.STRING)
    private Role role;

    private String username;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account", orphanRemoval = true)
    @JsonIgnore
    private List<Ticket> tickets;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account", orphanRemoval = true)
    private List<TravelerRating> ratings;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        System.out.println("Authority: " + role.getRoleName().toUpperCase());
        list.add(new SimpleGrantedAuthority(role.getRoleName().toUpperCase()));
        for (GrantedAuthority s: list) {
            System.out.println(s);
        }
        return list;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        if (this.getStatus() == 0) return false;
        else return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
