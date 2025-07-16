package dev.subotinov.entity;

import dev.subotinov.entity.base.BaseEntity;
import dev.subotinov.entity.film.Film;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table (schema = "movie")
public class Category extends BaseEntity {
    @Column (length = 25)
    private String name;
    @ManyToMany (mappedBy = "categories")
    private Set<Film> films;
}
