package dev.subotinov.entity.location;

import dev.subotinov.entity.base.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table (schema = "movie")
public class Address extends BaseEntity {
    @Column (length = 50)
    private String address;
    @Column (length = 50)
    private String address2;
    @Column (length = 20)
    private String district;
    @ManyToOne(optional = false)
    @JoinColumn (name = "city_id", nullable = false)
    private City city;
    @Column (name = "postal_code", length = 10)
    private String postalCode;
    @Column (length = 20)
    private String phone;
}