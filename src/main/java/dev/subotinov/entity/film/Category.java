package dev.subotinov.entity.film;

import dev.subotinov.entity.base.BaseEntity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table (schema = "movie")
public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "category_id")
    private Byte id;
    @Column (length = 25)
    private String name;
    @ManyToMany (mappedBy = "categories")
    private Set<Film> films;
}
