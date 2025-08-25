package dev.subotinov.entity.location;

import dev.subotinov.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table (schema = "movie")
@Getter @Setter
public class Country extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "country_id")
    private Short id;
    @Column (length = 50, nullable = false)
    private String country;
    @OneToMany (mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<City> cities;

    public Country() {}

    public Country(String country) {
        this.country = country;
    }
}
