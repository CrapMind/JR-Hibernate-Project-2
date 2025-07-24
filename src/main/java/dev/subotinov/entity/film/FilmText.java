package dev.subotinov.entity.film;

import dev.subotinov.entity.base.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table (schema = "movie", name = "film_text")
public class FilmText {
    @Id
    @OneToOne
    @JoinColumn(name = "film_id")
    @MapsId
    private Film film;
    @Column (length = 128)
    private String title;
    @Column
    private String description;
}
