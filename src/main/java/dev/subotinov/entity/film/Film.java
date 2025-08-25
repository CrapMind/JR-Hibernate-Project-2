package dev.subotinov.entity.film;

import dev.subotinov.entity.Actor;
import dev.subotinov.entity.Language;
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
@Table (schema = "movie")
@Getter @Setter
public class Film extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "film_id")
    private Short id;
    @OneToOne (cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private FilmText filmText;
    @Column (name = "release_year")
    private Date releaseYear;
    @OneToOne
    @JoinColumn(name = "language_id")
    private Language language;
    @Embedded
    private FilmRental filmRental;
    @Column
    private Short length;
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
