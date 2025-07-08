package dev.subotinov.entity;

import dev.subotinov.entity.base.BaseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment extends BaseEntity {
    private Customer customer;
    private Staff staff;
    private Rental rental;
    private BigDecimal amount;
    private LocalDateTime paymentDate;
}
