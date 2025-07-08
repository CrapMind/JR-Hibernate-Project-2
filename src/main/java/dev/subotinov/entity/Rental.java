package dev.subotinov.entity;

import dev.subotinov.entity.base.BaseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Rental extends BaseEntity {
    private LocalDateTime rentalDate;
    private Inventory inventory;
    private Customer customer;
    private LocalDate returnDate;
    private Staff staff;
    private Payment payment;
}
