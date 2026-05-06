package finki.ukim.mk.lab_1_b.model.domain;

import finki.ukim.mk.lab_1_b.model.enums.AccommodationState;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
//@AllArgsConstructor
@Table(name = "hosts")
public class Host extends BaseAuditableEntity{
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id",nullable = false)
    private Country country;


    public Host(String name,String surname,Country country){
        this.name=name;
        this.surname=surname;
        this.country=country;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Host() {
    }
}
