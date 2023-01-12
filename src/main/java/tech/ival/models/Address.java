package tech.ival.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String province;
    public String city;
    public String district;


    @OneToOne
    @JoinColumn(name = "user_id" , referencedColumnName = "id")
    public User user;

    @JsonIgnore
    public User getUser() {
        return user;
    }

    @JsonSetter
    public void setUser(User user) {
        this.user = user;
    }
}
