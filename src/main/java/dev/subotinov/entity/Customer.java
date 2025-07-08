package dev.subotinov.entity;

import dev.subotinov.entity.base.BaseEntity;

import java.sql.Date;
import java.time.LocalDate;

public class Customer extends BaseEntity {
    private Store store;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private short active;
    private LocalDate createDate;
    private Payment payment;
}
