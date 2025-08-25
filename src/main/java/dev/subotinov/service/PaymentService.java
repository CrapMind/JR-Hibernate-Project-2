package dev.subotinov.service;

import dev.subotinov.entity.Customer;
import dev.subotinov.entity.store.Inventory;
import jakarta.persistence.EntityManager;

public interface PaymentService {
    void createPayment(Inventory inventory, Customer customer, EntityManager em);
}
