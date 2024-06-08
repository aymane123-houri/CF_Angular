package com.example.apisiteecommerce.Entity;

public class ProduitCommandeDto {
    private Integer produitId;
    private int quantity;

    // Getters and setters
    public Integer getProduitId() {
        return produitId;
    }

    public void setProduitId(Integer produitId) {
        this.produitId = produitId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
