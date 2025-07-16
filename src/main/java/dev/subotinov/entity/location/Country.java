package dev.subotinov.entity.location;

import dev.subotinov.entity.base.BaseEntity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table (schema = "movie")
public class Country extends BaseEntity {
    @Column (length = 50)
    private String country;
    @OneToMany (mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<City> cities;
}
