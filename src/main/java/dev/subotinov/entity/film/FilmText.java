package dev.subotinov.entity.film;

import dev.subotinov.entity.base.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table (schema = "movie", name = "film_text")
public class FilmText {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (length = 128)
    private String title;
    @Column
    private String description;
    @OneToOne (mappedBy = "filmText")
    private Film film;
}
