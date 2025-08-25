package dev.subotinov.repository;

import dev.subotinov.config.JpaUtil;
import dev.subotinov.entity.store.Staff;
import dev.subotinov.entity.store.Store;
import jakarta.persistence.EntityManager;

public class StaffRepository {

    public Staff getManagerById(int id) {
        try (EntityManager entityManager = JpaUtil.getEntityManager()) {
            return entityManager.find(Staff.class, id);
        }
    }

    public void saveManager(Store store) {
        try (EntityManager entityManager = JpaUtil.getEntityManager()) {
            entityManager.getTransaction().begin();
            Staff manager = new Staff();
            manager.setStore(store);
            entityManager.persist(manager);
            entityManager.getTransaction().commit();
        }
    }
}
