package com.example.apisiteecommerce.repository;

import com.example.apisiteecommerce.Entity.Produitcommande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitCommandeRepository extends JpaRepository<Produitcommande, Integer> {

}