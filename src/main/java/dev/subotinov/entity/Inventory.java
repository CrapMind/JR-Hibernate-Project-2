package dev.subotinov.entity;

import dev.subotinov.entity.base.BaseEntity;
import dev.subotinov.entity.film.Film;
import jakarta.persistence.*;

@Entity
@Table (schema = "movie")
public class Inventory extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "film_id")
    private Film film;
    @OneToOne
    @JoinColumn(name = "store_id")
    private Store store;
}
