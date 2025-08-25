package dev.subotinov.entity.film;
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
    @Column(columnDefinition = "text")
    private String description;
}
