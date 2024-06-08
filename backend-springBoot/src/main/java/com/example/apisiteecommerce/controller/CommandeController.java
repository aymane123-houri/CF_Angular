package com.example.apisiteecommerce.controller;

import com.example.apisiteecommerce.Entity.Commande;
import com.example.apisiteecommerce.Entity.CommandeDto;
import com.example.apisiteecommerce.Entity.Produitcommande;
import com.example.apisiteecommerce.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {
    @Autowired
    private CommandeService commandeService;

    @GetMapping
    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }

    @GetMapping("/produitcommande")
    public List<Produitcommande> getAllproduitCommandes() {
        return commandeService.getAllproduitCommandes();
    }

    @GetMapping("/{id}")
    public Commande getCommandeById(@PathVariable int id) {
        return commandeService.getCommandeById(id);
    }



    @DeleteMapping("/{id}")
    public void deleteCommande(@PathVariable int id) {
        commandeService.deleteCommande(id);
    }
/*
    @PostMapping("/create")
    public ResponseEntity<Commande> createCommandeWithProduits(@RequestBody CommandeDto commandeDto) {
        Commande savedCommande = commandeService.createCommande(commandeDto.getCommande(), commandeDto.getProduits());
        return new ResponseEntity<>(savedCommande, HttpStatus.CREATED);
    }
*/

    @PostMapping("/create")
    public ResponseEntity<Commande> createCommandeWithProduits(@RequestBody CommandeDto commandeDto) {
        Commande savedCommande = commandeService.createCommande(commandeDto.getCommande(), commandeDto.getProduits());
        return new ResponseEntity<>(savedCommande, HttpStatus.CREATED);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<List<Commande>> getCommandesByUserId(@PathVariable Long userId) {
        List<Commande> commandes = commandeService.getCommandesByUserId(userId);
        return new ResponseEntity<>(commandes, HttpStatus.OK);
    }


}
