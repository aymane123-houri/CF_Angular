package com.example.apisiteecommerce.service;

import com.example.apisiteecommerce.Entity.Commande;
import com.example.apisiteecommerce.Entity.ProduitCommandeDto;
import com.example.apisiteecommerce.Entity.Produitcommande;
import com.example.apisiteecommerce.repository.CommandeRepository;
import com.example.apisiteecommerce.repository.ProduitCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommandeService {
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private ProduitCommandeRepository produitCommandeRepository;
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }
    public List<Produitcommande> getAllproduitCommandes() {
        return produitCommandeRepository.findAll();
    }
    public Commande getCommandeById(int id) {
        return commandeRepository.findById(id).orElse(null);
    }

    public Commande saveCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    public void deleteCommande(int id) {
        commandeRepository.deleteById(id);
    }

    public List<Commande> getCommandesByUserId(Long userId) {
        return commandeRepository.findByUserId(userId);
    }

   /* public Commande createCommande(Commande commande, List<Produitcommande> produits) {
        commande.setProduitcommandesByCommandeId(produits);
        return commandeRepository.save(commande);

    }*/

    @Transactional
    public Commande createCommande(Commande commande, List<ProduitCommandeDto> produitsDto) {
        // Enregistrer la commande
        Commande savedCommande = commandeRepository.save(commande);

        // Mapper et enregistrer les produits commandés
        for (ProduitCommandeDto produitDto : produitsDto) {
            Produitcommande produitCommande = new Produitcommande();
            produitCommande.setProduitId(produitDto.getProduitId());
            produitCommande.setQuantity(produitDto.getQuantity());
            produitCommande.setCommandeByCommandeId(savedCommande);
            produitCommandeRepository.save(produitCommande);
        }

        return savedCommande;
    }






}