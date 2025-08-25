package dev.subotinov.entity;

import dev.subotinov.entity.base.BaseEntity;
import dev.subotinov.entity.util.enums.Rating;

import java.time.Year;

public class Film extends BaseEntity {
    private FilmText filmText;
    private Year releaseYear;
    private Language language;
    private FilmRental filmRental;
    private int length;
    private Rating rating;
    private Inventory inventory;
}
