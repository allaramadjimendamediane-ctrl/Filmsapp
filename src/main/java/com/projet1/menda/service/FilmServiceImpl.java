package com.projet1.menda.service;

import com.projet1.menda.entities.Film;
import com.projet1.menda.repository.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public Film ajouterFilm(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public List<Film> listeFilms() {
        return filmRepository.findAll();
    }

    @Override
    public Film rechercherFilm(Long id) {
        return filmRepository.findById(id).orElse(null);
    }

    @Override
    public Film modifierFilm(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public void supprimerFilm(Long id) {
        filmRepository.deleteById(id);
    }
}