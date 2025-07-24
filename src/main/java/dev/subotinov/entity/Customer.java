package dev.subotinov.entity;

import dev.subotinov.entity.base.BaseEntity;
import dev.subotinov.entity.location.Address;
import dev.subotinov.entity.store.Store;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table (schema = "movie")
@Getter @Setter
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "customer_id")
    private Short id;
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

    public Customer(Store store, String firstName, String lastName, String email, Address address) {
        this.store = store;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.createDate = LocalDateTime.now();
    }

    public Customer() {}

    public String toString() {
        return "Customer: " + firstName + " " + lastName + "; email: " + email;
    }
    @PrePersist
    protected void onCreate() {
        this.createDate = LocalDateTime.now();
    }
}
