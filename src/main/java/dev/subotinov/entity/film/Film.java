package dev.subotinov.entity.film;

import dev.subotinov.entity.base.BaseEntity;
import dev.subotinov.util.converter.RatingColumnConverter;
import dev.subotinov.util.converter.SpecialFeaturesColumnConverter;
import dev.subotinov.util.enums.Rating;
import dev.subotinov.util.enums.SpecialFeatures;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
import java.util.Set;

@Entity
@Table (schema = "movie", name = "film")
@Getter @Setter
public class Film extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "film_id")
    private Short id;
    @OneToOne (cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private FilmText filmText;
    @Column (name = "release_year", columnDefinition = "year")
    private Date releaseYear;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "language_id")
    private Language language;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "original_language_id")
    private Language originalLanguage;
    @Embedded
    private FilmRental filmRental;
    @Column
    private Short length;
    @Column(name = "rating")
    @Convert(converter = RatingColumnConverter.class)
    private Rating rating;
    @Column (name = "special_features")
    @Convert(converter = SpecialFeaturesColumnConverter.class)
    private Set<SpecialFeatures> specialFeatures;
    @ManyToMany
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id")
    )
    private Set<Actor> actors;
    @ManyToMany
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    )
    private Set<Category> categories;
}
