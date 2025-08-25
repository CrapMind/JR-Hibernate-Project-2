package dev.subotinov.service;

import dev.subotinov.entity.Customer;
import dev.subotinov.entity.location.Address;
import dev.subotinov.entity.store.Inventory;
import dev.subotinov.entity.store.Store;

public interface CustomerService {
    void saveCustomer(Address address, Store store);
    void customerReturnRentalFilm(Customer customer, Inventory inventory);
    void customerRentRandomFilm(Customer customer);
    Customer getCustomerById(int id);
}
