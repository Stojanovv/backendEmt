package finki.ukim.mk.lab_1_b.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "countries")
public class Country extends BaseEntity{
    @Column(nullable = false,unique = true)
    @JoinColumn(name = "host_id", nullable = false)
    private String name;

    @Column(nullable = false)
    private String continent;

    public Country(String name,String country){
        this.name=name;
        this.continent=country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Country() {
    }
}
