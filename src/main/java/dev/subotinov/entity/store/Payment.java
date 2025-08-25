package dev.subotinov.entity.store;

import dev.subotinov.entity.Customer;
import dev.subotinov.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table (schema = "movie")
@Getter @Setter
public class Payment extends BaseEntity {
    @OneToOne
    @JoinColumn (name = "customer_id")
    private Customer customer;
    @OneToOne
    @JoinColumn (name = "staff_id")
    private Staff staff;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "rental_id")
    private Rental rental;
    @Column (precision = 5, scale = 2)
    private BigDecimal amount;
    @Column (name = "payment_date", nullable = false, updatable = false)
    private LocalDateTime paymentDate;

    public Payment (Customer customer, Staff staff, Rental rental, BigDecimal amount) {
        this.customer = customer;
        this.staff = staff;
        this.rental = rental;
        this.amount = amount;
        this.paymentDate = LocalDateTime.now();
    }

    public Payment() {

    }
}
