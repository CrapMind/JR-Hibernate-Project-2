package dev.subotinov.service;
import dev.subotinov.entity.film.Film;
import dev.subotinov.entity.store.Store;

public interface FilmService {
    void saveFilm(Film film, Store store);
}
