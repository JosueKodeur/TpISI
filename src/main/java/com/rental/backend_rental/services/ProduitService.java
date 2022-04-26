package com.rental.backend_rental.services;

import com.rental.backend_rental.Repositories.ProduitRepository;
import com.rental.backend_rental.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    //Injection de dépendance de repository dans service
    @Autowired
    private ProduitRepository produitRepository;

    //Enregistrer un produit dans la base
    public void saveProduit(Product produit)
    {
        produitRepository.save(produit);
    }

    //Afficher les produits
    public List<Product> showAllProduit()
    {
        return produitRepository.findAll();
    }

    //selectionner un seul produit
    public Product selectedProduit(int id)
    {
        Optional<Product> optional = produitRepository.findById(id);
        Product produit = null;
        if(optional.isPresent())
        {
            produit = optional.get();
        }else
        {
            throw new RuntimeException("id introuvable");
        }
        return  produit;
    }

    //supprimer un produit
    public void deleteProduit(int id){
        if (selectedProduit(id) != null) {
            produitRepository.deleteById(id);
        }
    }
    public void updateQuantityProduct(int id, int quantite)
    {
        produitRepository.updateQuantityProduct(id, quantite);
    }
}