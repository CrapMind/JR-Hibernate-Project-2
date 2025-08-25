package dev.subotinov.entity.film;

import dev.subotinov.entity.base.BaseEntity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table (schema = "movie")
public class Actor extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "actor_id")
    private Short id;
    @ManyToMany (mappedBy = "actors")
    private Set<Film> films;
    @Column (name = "first_name", length = 45)
    private String firstName;
    @Column (name = "last_name", length = 45)
    private String lastName;
}
