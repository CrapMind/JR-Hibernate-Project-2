package dev.subotinov.service;
import dev.subotinov.entity.Customer;
import dev.subotinov.entity.location.Address;
import dev.subotinov.entity.store.Inventory;
import dev.subotinov.entity.store.Staff;
import dev.subotinov.entity.store.Store;

public interface StoreService {

    void saveStore(Address address, Staff manager);
    Store getStoreById(int id);
    Inventory getAvailableInventory(Store store);
    void createPayment(Customer customer, Inventory inventory, Store store);
    Inventory getInventoryById(int id);

}
