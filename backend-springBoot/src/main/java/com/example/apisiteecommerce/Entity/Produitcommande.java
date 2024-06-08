package com.example.apisiteecommerce.Entity;

import jakarta.persistence.*;

@Entity
public class Produitcommande {
    private int produitCommandeId;
    //private Integer commandeId;
    private Integer produitId;
    private int quantity;
    private Commande commandeByCommandeId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "produitCommandeId", nullable = false)
    public int getProduitCommandeId() {
        return produitCommandeId;
    }

    public void setProduitCommandeId(int produitCommandeId) {
        this.produitCommandeId = produitCommandeId;
    }

    /*@Basic
    @Column(name = "commandeId", nullable = true)
    public Integer getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(Integer commandeId) {
        this.commandeId = commandeId;
    }*/

    @Basic
    @Column(name = "produitId", nullable = true)
    public Integer getProduitId() {
        return produitId;
    }

    public void setProduitId(Integer produitId) {
        this.produitId = produitId;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produitcommande that = (Produitcommande) o;

        if (produitCommandeId != that.produitCommandeId) return false;
        if (quantity != that.quantity) return false;

        if (produitId != null ? !produitId.equals(that.produitId) : that.produitId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = produitCommandeId;
        result = 31 * result + (produitId != null ? produitId.hashCode() : 0);
        result = 31 * result + quantity;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "commande_id", referencedColumnName = "commandeId")
    public Commande getCommandeByCommandeId() {
        return commandeByCommandeId;
    }

    public void setCommandeByCommandeId(Commande commandeByCommandeId) {
        this.commandeByCommandeId = commandeByCommandeId;
    }
}
