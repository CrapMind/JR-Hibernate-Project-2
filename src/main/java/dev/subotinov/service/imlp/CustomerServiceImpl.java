package dev.subotinov.service.imlp;

import dev.subotinov.config.JpaUtil;
import dev.subotinov.entity.Customer;
import dev.subotinov.entity.store.Rental;
import dev.subotinov.service.CustomerService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import lombok.NonNull;

import java.time.LocalDate;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public void save(@NonNull Customer customer) {
        if (customer.getAddress() == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        try (EntityManager em = JpaUtil.getEntityManager()) {
            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();
                em.persist(customer);
                transaction.commit();
            } catch (Exception e) {
                if (transaction.isActive()) transaction.rollback();
                System.out.println(e.getMessage());
                throw e;
            }
        }
    }
    @Override
    public void returnRentalFilm(@NonNull Customer customer) {
        try (EntityManager em = JpaUtil.getEntityManager()) {
            try {
                em.getTransaction().begin();

                TypedQuery<Rental> query = em.createQuery(
                        "SELECT r FROM Rental r WHERE r.customer = :customer AND r.returnDate IS NULL",
                        Rental.class
                );
                query.setParameter("customer", customer);
                Rental rental = query.getResultStream().findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("Нет незакрытой аренды у покупателя"));

                rental.setReturnDate(LocalDate.now());
                em.merge(rental);

                em.getTransaction().commit();
            }catch (Exception e) {
                em.getTransaction().rollback();
                System.out.println(e.getMessage());
            }
        }
    }
}
