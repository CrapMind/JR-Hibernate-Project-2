package dev.subotinov.entity.location;

import dev.subotinov.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (schema = "movie")
@Getter @Setter
public class Address extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "address_id")
    private Short id;
    @Column (length = 50)
    private String address;
    @Column (length = 50)
    private String address2;
    @Column (length = 20)
    private String district;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "city_id", nullable = false)
    private City city;
    @Column (name = "postal_code", length = 10)
    private String postalCode;
    @Column (length = 20)
    private String phone;
}