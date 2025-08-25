package dev.subotinov.entity.film;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

@Embeddable
public class FilmRental {

    @Column (name = "rental_duration")
    private short duration;
    @Column (name = "rental_rate")
    private BigDecimal rate;
    @Column (name = "replacement_cost")
    private BigDecimal replacementCost;
}
