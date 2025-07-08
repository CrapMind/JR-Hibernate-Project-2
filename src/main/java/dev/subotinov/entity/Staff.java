package dev.subotinov.entity;

import dev.subotinov.entity.base.BaseEntity;

import java.sql.Blob;

public class Staff extends BaseEntity {
    private String firstName;
    private String lastName;
    private Address address;
    private Blob picture;
    private String email;
    private Store store;
    private short active;
    private String username;
    private String password;
    private Payment payment;
    private Rental rental;
}
