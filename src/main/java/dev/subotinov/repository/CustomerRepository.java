package dev.subotinov.repository;

import dev.subotinov.config.JpaUtil;
import dev.subotinov.entity.Customer;
import dev.subotinov.entity.location.Address;
import dev.subotinov.entity.store.Inventory;
import dev.subotinov.entity.store.Rental;
import dev.subotinov.entity.store.Store;
import dev.subotinov.service.StoreService;
import dev.subotinov.service.imlp.StoreServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import lombok.NonNull;

import java.time.LocalDateTime;

public class CustomerRepository {

    StoreService storeService = new StoreServiceImpl();

    public void saveCustomer(String firstName, String lastName, Address address, Store store) {
        try (EntityManager em = JpaUtil.getEntityManager()) {
            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();

                Customer customer = new Customer();

                Address savedAddress = em.find(Address.class, address.getId());
                Store savedStore = em.find(Store.class, store.getId());

                customer.setFirstName(firstName);
                customer.setLastName(lastName);
                customer.setAddress(savedAddress);
                customer.setStore(savedStore);

                em.persist(customer);
                transaction.commit();

            } catch (Exception e) {
                if (transaction.isActive()) transaction.rollback();
                System.out.println(e.getMessage());
                throw e;
            }
        }
    }

    public void customerReturnRentalFilm(Customer customer, Inventory inventory) {
        try (EntityManager em = JpaUtil.getEntityManager()) {
            try {
                em.getTransaction().begin();

                TypedQuery<Rental> query = em.createQuery(
                        "FROM Rental r WHERE r.customer.id = :customerId AND r.inventory.id = :inventoryId " +
                                "AND r.returnDate IS NULL", Rental.class);
                query.setParameter("customerId", customer.getId());
                query.setParameter("inventoryId", inventory.getId());
                Rental rental = query.getResultStream().findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("No rental found"));
                rental.setReturnDate(LocalDateTime.now());

                em.merge(rental);
                em.getTransaction().commit();

            } catch (Exception e) {
                em.getTransaction().rollback();
                System.out.println(e.getMessage());
            }
        }
    }

    public void customerRentRandomFilm(@NonNull Customer customer) {

            Store store = customer.getStore();
            Inventory inventory = storeService.getAvailableInventory(store);

            storeService.createPayment(customer, inventory, store);
    }

    public Customer getCustomerById(int id) {
        return JpaUtil.getEntityManager().find(Customer.class, id);
    }
}
