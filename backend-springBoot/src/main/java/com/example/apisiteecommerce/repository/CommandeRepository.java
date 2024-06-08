package com.example.apisiteecommerce.repository;

import com.example.apisiteecommerce.Entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {
    List<Commande> findByUserId(Long userId);
}