package dev.subotinov.entity.store;

import dev.subotinov.entity.base.BaseEntity;
import dev.subotinov.entity.location.Address;
import jakarta.persistence.*;

@Entity
@Table (schema = "movie")
public class Store extends BaseEntity {
    @OneToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "manager_staff_id")
    private Staff manager;
    @OneToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "address_id", nullable = false)
    private Address address;
}
