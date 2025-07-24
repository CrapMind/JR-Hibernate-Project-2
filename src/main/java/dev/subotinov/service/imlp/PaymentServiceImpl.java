package dev.subotinov.service.imlp;

import dev.subotinov.config.JpaUtil;
import dev.subotinov.entity.Customer;
import dev.subotinov.entity.store.Inventory;
import dev.subotinov.entity.store.Payment;
import dev.subotinov.entity.store.Rental;
import dev.subotinov.entity.store.Staff;
import dev.subotinov.service.PaymentService;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;

public class PaymentServiceImpl implements PaymentService {

    @Override
    public void createPayment(Inventory inventory, Customer customer) {
        EntityManager em = JpaUtil.getEntityManager();
        Staff manager = customer.getStore().getManager();
        Rental rental = new Rental(inventory, customer, manager);
        BigDecimal filmRental = inventory.getFilm().getFilmRental().getRate();
        Payment payment = new Payment(customer, manager, rental, filmRental);
        em.persist(payment);
    }
}
