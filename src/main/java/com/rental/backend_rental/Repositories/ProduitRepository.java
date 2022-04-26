package com.rental.backend_rental.Repositories;

import com.rental.backend_rental.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Product, Integer > {

    @Query(value = "UPDATE produits set qte_stok = qte_stok+quantite where id = ?", nativeQuery = true)
    void updateQuantityProduct(int id, int quantite);
}
