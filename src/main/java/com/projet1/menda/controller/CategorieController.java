package com.projet1.menda.controller;

import com.projet1.menda.entities.Categorie;
import com.projet1.menda.service.CategorieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategorieController {

    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    // Afficher toutes les catégories
    @GetMapping
    public String listeCategories(Model model) {
        model.addAttribute("categories", categorieService.listeCategories());
        return "categories/liste";
    }

    // Afficher le formulaire d'ajout
    @GetMapping("/ajouter")
    public String formulaireAjout(Model model) {
        model.addAttribute("categorie", new Categorie());
        return "categories/formulaire";
    }

    // Enregistrer une catégorie
    @PostMapping("/enregistrer")
    public String enregistrerCategorie(
            @ModelAttribute("categorie") Categorie categorie) {

        categorieService.ajouterCategorie(categorie);

        return "redirect:/categories";
    }

    // Afficher le formulaire de modification
    @GetMapping("/modifier/{id}")
    public String formulaireModification(
            @PathVariable Long id,
            Model model) {

        Categorie categorie = categorieService.rechercherCategorie(id);

        if (categorie == null) {
            return "redirect:/categories";
        }

        model.addAttribute("categorie", categorie);

        return "categories/formulaire";
    }

    // Supprimer une catégorie
    @GetMapping("/supprimer/{id}")
    public String supprimerCategorie(@PathVariable Long id) {

        categorieService.supprimerCategorie(id);

        return "redirect:/categories";
    }
}
