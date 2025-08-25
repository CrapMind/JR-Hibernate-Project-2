package dev.subotinov.entity.location;

import dev.subotinov.entity.base.BaseEntity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(schema = "movie")
public class City extends BaseEntity {
    @Column (length = 50)
    private String city;
    @ManyToOne(optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;
    @OneToMany (mappedBy = "city", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Address> addresses;
}
