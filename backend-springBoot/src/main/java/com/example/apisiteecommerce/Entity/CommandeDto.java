package com.example.apisiteecommerce.Entity;

import java.util.List;

 /* public class CommandeDto {
  private Commande commande;
    private List<Produitcommande> produits;

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public List<Produitcommande> getProduits() {
        return produits;
    }

    public void setProduits(List<Produitcommande> produits) {
        this.produits = produits;
    }*/

    public class CommandeDto {
        private Commande commande;
        private List<ProduitCommandeDto> produits;

        // Getters et setters
        public Commande getCommande() {
            return commande;
        }

        public void setCommande(Commande commande) {
            this.commande = commande;
        }

        public List<ProduitCommandeDto> getProduits() {
            return produits;
        }

        public void setProduits(List<ProduitCommandeDto> produits) {
            this.produits = produits;
        }
}
