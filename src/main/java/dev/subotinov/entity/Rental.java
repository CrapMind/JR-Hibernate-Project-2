package dev.subotinov.entity;

import dev.subotinov.entity.base.BaseEntity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table (schema = "movie")
public class Rental extends BaseEntity {
    @Column (name = "rental_date", nullable = false)
    private LocalDateTime rentalDate;
    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "inventory_id")
    private Inventory inventory;
    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "customer_id")
    private Customer customer;
    @Column (name = "return_date")
    private LocalDate returnDate;
    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "staff_id")
    private Staff staff;
}
