package dev.subotinov.repository;

import dev.subotinov.config.JpaUtil;
import dev.subotinov.entity.film.Film;
import dev.subotinov.entity.store.Inventory;
import dev.subotinov.entity.store.Store;
import jakarta.persistence.EntityManager;

public class FilmRepository {

    public void saveFilm(Film film, Store store) {
        try (EntityManager manager = JpaUtil.getEntityManager()) {
            manager.getTransaction().begin();
            manager.persist(film);

            Inventory inventory = new Inventory();
            inventory.setFilm(film);
            inventory.setStore(store);
            manager.persist(inventory);

            manager.getTransaction().commit();
        }
    }
}
