package com.rental.backend_rental.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Approvisionnement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(nullable = false)
    private int quantite;

    private LocalDate dateApprov;

    @ManyToOne
    @JoinColumn(name = "produit_id", insertable = false, updatable = false)
    private Product produit;

    private int produit_id;

}