package dev.subotinov.service.imlp;
import dev.subotinov.entity.film.Film;
import dev.subotinov.entity.store.Store;
import dev.subotinov.repository.FilmRepository;
import dev.subotinov.service.FilmService;

public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository = new FilmRepository();

    @Override
    public void saveFilm(Film film, Store store) {
        filmRepository.saveFilm(film, store);
    }
}
