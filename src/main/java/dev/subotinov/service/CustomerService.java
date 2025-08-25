package dev.subotinov.service;

import dev.subotinov.entity.Customer;

public interface CustomerService {
    void save(Customer customer);
    void returnRentalFilm(Customer customer);
}
