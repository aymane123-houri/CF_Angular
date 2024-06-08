package com.example.apisiteecommerce.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Produit {
    private int productID;
    private String product_title;
    private String product_image;
    private BigDecimal product_price;
    private int quantity;
    private String category;
    private String details;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ProduitID", nullable = false)
    public int getProductID() {
        return productID;
    }

    public void setProductID(int produitId) {
        this.productID = produitId;
    }

    @Basic
    @Column(name = "Product_title", nullable = false, length = 255)
    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String productTitle) {
        this.product_title = productTitle;
    }

    @Basic
    @Column(name = "Product_image", nullable = false, length = 255)
    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String productImage) {
        this.product_image = productImage;
    }

    @Basic
    @Column(name = "Product_price", nullable = false, precision = 2)
    public BigDecimal getProduct_price() {
        return product_price;
    }

    public void setProduct_price(BigDecimal productPrice) {
        this.product_price = productPrice;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "category", nullable = false, length = 255)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "details", nullable = false, length = -1)
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produit produit = (Produit) o;

        if (productID != produit.productID) return false;
        if (quantity != produit.quantity) return false;
        if (product_title != null ? !product_title.equals(produit.product_title) : produit.product_title != null)
            return false;
        if (product_image != null ? !product_image.equals(produit.product_image) : produit.product_image != null)
            return false;
        if (product_price != null ? !product_price.equals(produit.product_price) : produit.product_price != null)
            return false;
        if (category != null ? !category.equals(produit.category) : produit.category != null) return false;
        if (details != null ? !details.equals(produit.details) : produit.details != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productID;
        result = 31 * result + (product_title != null ? product_title.hashCode() : 0);
        result = 31 * result + (product_image != null ? product_image.hashCode() : 0);
        result = 31 * result + (product_price != null ? product_price.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (details != null ? details.hashCode() : 0);
        return result;
    }
}
