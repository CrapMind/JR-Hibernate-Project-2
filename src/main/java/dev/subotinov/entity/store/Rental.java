package dev.subotinov.entity.store;

import dev.subotinov.entity.Customer;
import dev.subotinov.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table (schema = "movie")
@Getter @Setter
public class Rental extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "rental_id")
    private Short id;
    @Column (name = "rental_date", nullable = false)
    private LocalDateTime rentalDate;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "inventory_id")
    private Inventory inventory;
    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "customer_id")
    private Customer customer;
    @Column (name = "return_date")
    private LocalDateTime returnDate;
    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "staff_id")
    private Staff staff;

    public Rental(Inventory inventory, Customer customer, Staff staff) {
        this.rentalDate = LocalDateTime.now();
        this.inventory = inventory;
        this.customer = customer;
        this.staff = staff;
    }

    public Rental() {

    }
}
