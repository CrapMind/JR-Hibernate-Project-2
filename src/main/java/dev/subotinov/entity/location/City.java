package dev.subotinov.entity.location;

import dev.subotinov.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(schema = "movie")
@Getter @Setter
public class City extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "city_id")
    private Short id;
    @Column (length = 50)
    private String city;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;
    @OneToMany (mappedBy = "city", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Address> addresses;
}
