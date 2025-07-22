package dev.subotinov.entity.film;

import dev.subotinov.entity.Actor;
import dev.subotinov.entity.Language;
import dev.subotinov.entity.base.BaseEntity;
import dev.subotinov.util.converter.RatingColumnConverter;
import dev.subotinov.util.converter.SpecialFeaturesColumnConverter;
import dev.subotinov.util.converter.YearColumnConverter;
import dev.subotinov.util.enums.Rating;
import dev.subotinov.util.enums.SpecialFeatures;
import jakarta.persistence.*;

import java.time.Year;
import java.util.Set;

@Entity
@Table (schema = "movie")
public class Film extends BaseEntity {
    @OneToOne (cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private FilmText filmText;
    @Convert(converter = YearColumnConverter.class)
    @Column (name = "release_year")
    private Year releaseYear;
    @OneToOne
    @JoinColumn(name = "language_id")
    private Language language;
    @Embedded
    private FilmRental filmRental;
    @Column
    private int length;
    @Convert(converter = RatingColumnConverter.class)
    @Column
    private Rating rating;
    @Convert(converter = SpecialFeaturesColumnConverter.class)
    @Column (name = "special_features")
    private Set<SpecialFeatures> specialFeatures;
    @ManyToMany
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<Actor> actors;
    @ManyToMany
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;
}
