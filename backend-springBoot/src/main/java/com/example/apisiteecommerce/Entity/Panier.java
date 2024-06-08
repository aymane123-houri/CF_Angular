package com.example.apisiteecommerce.Entity;

import jakarta.persistence.*;

@Entity
public class Panier {
    private int panierId;
    private int userId;
    private Produit product;
    private int quantity;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "panierID", nullable = false)
    public int getPanierId() {
        return panierId;
    }

    public void setPanierId(int panierId) {
        this.panierId = panierId;
    }

    @Basic
    @Column(name = "userID", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Panier panier = (Panier) o;

        if (panierId != panier.panierId) return false;
        if (userId != panier.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = panierId;
        result = 31 * result + userId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "productID", referencedColumnName = "ProduitID", nullable = false)
    public Produit getProduct() {
        return product;
    }

    public void setProduct(Produit produitByProductId) {
        this.product = produitByProductId;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}
