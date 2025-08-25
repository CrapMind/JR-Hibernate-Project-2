package dev.subotinov.repository;

import dev.subotinov.config.JpaUtil;
import dev.subotinov.entity.Customer;
import dev.subotinov.entity.location.Address;
import dev.subotinov.entity.store.*;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
public class StoreRepository {

    public void saveStore(Address address, Staff manager) {
        try (EntityManager entityManager = JpaUtil.getEntityManager()) {
            entityManager.getTransaction().begin();

            Store store = new Store();

            store.setAddress(address);
            store.setManager(manager);

            entityManager.persist(store);
            entityManager.getTransaction().commit();
        }
    }

    public Store getStoreById(int id) {
        try (EntityManager entityManager = JpaUtil.getEntityManager()) {
            return entityManager.find(Store.class, id);
        }
    }

    public Inventory getAvailableInventory(Store store) {

        return store.getInventories()
                .stream()
                .filter(inv -> {
                    List<Rental> rentals = inv.getRentals();
                    return rentals.isEmpty() || rentals.stream()
                            .allMatch(r -> r.getReturnDate() != null);
                })
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No free inventory found"));
    }

    public void createPayment(Customer customer, Inventory inventory, Store store) {

        try (EntityManager em = JpaUtil.getEntityManager()) {
            em.getTransaction().begin();

            Staff manager = store.getManager();

            Rental rental = new Rental(inventory, customer, manager);
            BigDecimal filmRental = inventory.getFilm().getFilmRental().getRate();

            Payment payment = new Payment(customer, manager, rental, filmRental);

            em.persist(payment);
            em.getTransaction().commit();
        }
    }
}
