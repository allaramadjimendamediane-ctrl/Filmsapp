package com.projet1.menda.service;

import com.projet1.menda.entities.Film;

import java.util.List;

public interface FilmService {

    Film ajouterFilm(Film film);

    List<Film> listeFilms();

    Film rechercherFilm(Long id);

    Film modifierFilm(Film film);

    void supprimerFilm(Long id);

}
