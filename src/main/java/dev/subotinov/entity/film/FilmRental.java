package dev.subotinov.entity.film;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Embeddable
@Getter @Setter
public class FilmRental {

    @Column (name = "rental_duration")
    private short duration;
    @Column (name = "rental_rate")
    private BigDecimal rate;
    @Column (name = "replacement_cost")
    private BigDecimal replacementCost;
}
