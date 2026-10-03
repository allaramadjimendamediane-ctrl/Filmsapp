package com.projet1.menda.controller;

import com.projet1.menda.entities.Categorie;
import com.projet1.menda.entities.Film;
import com.projet1.menda.service.CategorieService;
import com.projet1.menda.service.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;
    private final CategorieService categorieService;

    public FilmController(
            FilmService filmService,
            CategorieService categorieService) {

        this.filmService = filmService;
        this.categorieService = categorieService;
    }

    @GetMapping
    public String listeFilms(Model model) {

        model.addAttribute(
                "films",
                filmService.listeFilms()
        );

        return "films/liste";
    }

    @GetMapping("/ajouter")
    public String ajouterFormulaire(Model model) {

        Film film = new Film();

        // Correction importante
        film.setCategorie(new Categorie());

        model.addAttribute("film", film);

        model.addAttribute(
                "categories",
                categorieService.listeCategories()
        );

        return "films/formulaire";
    }

    @PostMapping("/enregistrer")
    public String enregistrer(
            @ModelAttribute("film") Film film) {

        if (film.getCategorie() != null
                && film.getCategorie().getId() != null) {

            Categorie categorie =
                    categorieService.rechercherCategorie(
                            film.getCategorie().getId()
                    );

            film.setCategorie(categorie);
        }

        filmService.ajouterFilm(film);

        return "redirect:/films";
    }

    @GetMapping("/modifier/{id}")
    public String modifierFormulaire(
            @PathVariable Long id,
            Model model) {

        Film film = filmService.rechercherFilm(id);

        if (film == null) {
            return "redirect:/films";
        }

        model.addAttribute("film", film);

        model.addAttribute(
                "categories",
                categorieService.listeCategories()
        );

        return "films/formulaire";
    }

    @GetMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id) {

        filmService.supprimerFilm(id);

        return "redirect:/films";
    }
}