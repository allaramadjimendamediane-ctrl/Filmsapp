package com.projet1.menda.service;

import com.projet1.menda.entities.Categorie;
import com.projet1.menda.repository.CategorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService {

    private final CategorieRepository categorieRepository;

    public CategorieServiceImpl(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Override
    public Categorie ajouterCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public List<Categorie> listeCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie rechercherCategorie(Long id) {
        return categorieRepository.findById(id).orElse(null);
    }

    @Override
    public Categorie modifierCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public void supprimerCategorie(Long id) {
        categorieRepository.deleteById(id);
    }
}