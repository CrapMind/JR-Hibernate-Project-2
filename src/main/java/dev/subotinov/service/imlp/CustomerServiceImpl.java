package dev.subotinov.service.imlp;
import dev.subotinov.entity.Customer;
import dev.subotinov.entity.location.Address;
import dev.subotinov.entity.store.Inventory;
import dev.subotinov.entity.store.Store;
import dev.subotinov.repository.CustomerRepository;
import dev.subotinov.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository = new CustomerRepository();

    @Override
    public void saveCustomer(Address address, Store store) {
        repository.saveCustomer(address, store);
    }
    @Override
    public void customerReturnRentalFilm(Customer customer, Inventory inventory) {
        repository.customerReturnRentalFilm(customer, inventory);
    }
    @Override
    public void customerRentRandomFilm(Customer customer) {
        repository.customerRentRandomFilm(customer);
    }
    @Override
    public Customer getCustomerById(int id) {
        return repository.getCustomerById(id);
    }

}
