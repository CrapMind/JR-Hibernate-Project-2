package dev.subotinov.entity.store;

import dev.subotinov.entity.base.BaseEntity;
import dev.subotinov.entity.film.Film;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table (schema = "movie")
@Getter @Setter
public class Inventory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "inventory_id")
    private Short id;
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
    @OneToMany (mappedBy = "inventory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rental> rentals;
}
