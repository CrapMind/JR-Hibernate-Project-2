package dev.subotinov.service.imlp;

import dev.subotinov.config.JpaUtil;
import dev.subotinov.entity.Customer;
import dev.subotinov.service.CustomerService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.NonNull;

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
}
