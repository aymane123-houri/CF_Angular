package com.example.apisiteecommerce.repository;

import com.example.apisiteecommerce.Entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface produitRepository extends JpaRepository<Produit,Integer> {
    List<Produit> findByCategory(String category);
}
