package com.projet1.menda.service;

import com.projet1.menda.entities.Categorie;

import java.util.List;

public interface CategorieService {

    Categorie ajouterCategorie(Categorie categorie);

    List<Categorie> listeCategories();

    Categorie rechercherCategorie(Long id);

    Categorie modifierCategorie(Categorie categorie);

    void supprimerCategorie(Long id);

}