package dev.subotinov.entity.store;

import dev.subotinov.entity.base.BaseEntity;
import dev.subotinov.entity.location.Address;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table (schema = "movie")
@Getter @Setter
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "store_id")
    private Byte id;
    @OneToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "manager_staff_id")
    private Staff manager;
    @OneToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "address_id", nullable = false)
    private Address address;
    @OneToMany(mappedBy = "store")
    private List<Inventory> inventories;
}
