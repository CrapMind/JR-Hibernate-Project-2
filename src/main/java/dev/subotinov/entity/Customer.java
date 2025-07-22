package dev.subotinov.entity;

import dev.subotinov.entity.base.BaseEntity;
import dev.subotinov.entity.location.Address;
import dev.subotinov.entity.store.Store;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table (schema = "movie")
@Data
public class Customer extends BaseEntity {
    @ManyToOne
    @JoinColumn (name = "store_id")
    private Store store;
    @Column (name = "first_name", length = 45)
    private String firstName;
    @Column (name = "last_name", length = 45)
    private String lastName;
    @Column (length = 50)
    private String email;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "address_id", nullable = false)
    private Address address;
    @Column (nullable = false)
    private boolean active = true;
    @Column (name = "create_date", nullable = false, updatable = false)
    private LocalDateTime createDate;

    @PrePersist
    protected void onCreate() {
        this.createDate = LocalDateTime.now();
    }
}
