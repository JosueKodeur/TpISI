package com.rental.backend_rental.controller;

import com.rental.backend_rental.models.Product;
import com.rental.backend_rental.services.CategoryService;
import com.rental.backend_rental.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/products")
public class ProduitController {

    //Injection de dépendance de service dans controller
    @Autowired
    private ProduitService produitService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public String afficherProduit(Model model)
    {
        model.addAttribute("produits", produitService.showAllProduit());
        return "products/listProduct";
    }

    @GetMapping("/create")
    public String AfficherFormulaire(Model model)
    {
        model.addAttribute("categories", categoryService.showAllCategory());
        return "products/addProduct";
    }

    @PostMapping("/save")
    public String save(Product produit)
    {
        produit.setQteStok(0);
        produit.setDateCreation(LocalDate.now());
        produitService.saveProduit(produit);
        return "redirect:/products/all";
    }

    @GetMapping("/edit/{id}")
    public String formEditProduit(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("unProduit", produitService.selectedProduit(id));
        model.addAttribute("categories", categoryService.showAllCategory());
        return "products/editProduct";
    }

    @PostMapping("/edit")
    public String editProduit(@ModelAttribute("produit") Product produit ){
        produitService.saveProduit(produit);
        return "redirect:/products/all";
    }

    @GetMapping("delete/{id}")
    public String deleteProduit(@PathVariable("id") int id)
    {
        produitService.deleteProduit(id);
        return "redirect:/products/all";
    }

    @GetMapping("/approvisionnement/form/{id}")
    public String approvisionnerProduit(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("oneProduit", produitService.selectedProduit(id));
        return "approvisionnement/createForm";
    }
}