package dev.subotinov.service.imlp;
import dev.subotinov.entity.Customer;
import dev.subotinov.entity.location.Address;
import dev.subotinov.entity.store.*;
import dev.subotinov.repository.StoreRepository;
import dev.subotinov.service.StoreService;

public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository = new StoreRepository();

    @Override
    public Store getStoreById(int id) {
        return storeRepository.getStoreById(id);
    }
    @Override
    public void saveStore(Address address, Staff manager) {
        storeRepository.saveStore(address, manager);
    }
    @Override
    public Inventory getAvailableInventory(Store store) {
        return storeRepository.getAvailableInventory(store);
    }
    @Override
    public void createPayment(Customer customer, Inventory inventory, Store store) {
        storeRepository.createPayment(customer, inventory, store);
    }
    @Override
    public Inventory getInventoryById(int id) {
        return storeRepository.getInventoryById(id);
    }
}
