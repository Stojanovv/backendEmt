package finki.ukim.mk.lab_1_b.model.domain;

import finki.ukim.mk.lab_1_b.model.enums.AccommodationCategory;
import finki.ukim.mk.lab_1_b.model.enums.AccommodationState;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Table( name = "accommodations")
@Data
@NamedEntityGraph(
        name = "Accommodation.host-country",
        attributeNodes = {
                @NamedAttributeNode(value = "host", subgraph = "host-subgraph")
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "host-subgraph",
                        attributeNodes = {
                                @NamedAttributeNode("country")
                        }
                )
        }
)
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

    @Column(nullable = false)
    private AccommodationState accommodationState;

    @Column(name = "date_opened")
    private LocalDate date_opened;


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

    public AccommodationState getAccommodationState() {
        return accommodationState;
    }

    public void setAccommodationState(AccommodationState accommodationState) {
        this.accommodationState = accommodationState;
    }

    public LocalDate getOpen() {
        return date_opened;
    }

    public void setOpen(LocalDate open) {
        this.date_opened = open;
    }

    public Accommodation() {
    }
}
