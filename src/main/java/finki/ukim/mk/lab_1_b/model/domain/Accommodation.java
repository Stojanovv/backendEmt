package finki.ukim.mk.lab_1_b.model.domain;

import finki.ukim.mk.lab_1_b.model.enums.AccommodationCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
//@AllArgsConstructor

@Table( name = "accommodation")
public class Accommodation extends BaseAuditableEntity{
    @Column(nullable = false,unique = true)
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private AccommodationCategory category;

    @ManyToOne
    @JoinColumn(name = "host_id",nullable = false)
    private Host host;

    @Column(nullable = false)
    private Integer numRooms;


    public Accommodation(String name, AccommodationCategory category, Host host, Integer numRooms) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccommodationCategory getCategory() {
        return category;
    }

    public void setCategory(AccommodationCategory category) {
        this.category = category;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public Integer getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(Integer numRooms) {
        this.numRooms = numRooms;
    }
}
