package com.example.apisiteecommerce.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Commande {
    private int commandeId;
    private Integer userId;
    private String address;
    private String city;
    private String postalCode;
    private String message;
    private BigDecimal totalAmount;
    private Timestamp dateCreated;
    private Collection<Produitcommande> produitcommandesByCommandeId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "commandeId", nullable = false)
    public int getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(int commandeId) {
        this.commandeId = commandeId;
    }

    @Basic
    @Column(name = "userId", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 100)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "postalCode", nullable = true, length = 20)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Basic
    @Column(name = "message", nullable = true, length = -1)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "totalAmount", nullable = true, precision = 2)
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Basic
    @Column(name = "dateCreated", nullable = false)
    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commande commande = (Commande) o;

        if (commandeId != commande.commandeId) return false;
        if (userId != null ? !userId.equals(commande.userId) : commande.userId != null) return false;
        if (address != null ? !address.equals(commande.address) : commande.address != null) return false;
        if (city != null ? !city.equals(commande.city) : commande.city != null) return false;
        if (postalCode != null ? !postalCode.equals(commande.postalCode) : commande.postalCode != null) return false;
        if (message != null ? !message.equals(commande.message) : commande.message != null) return false;
        if (totalAmount != null ? !totalAmount.equals(commande.totalAmount) : commande.totalAmount != null)
            return false;
        if (dateCreated != null ? !dateCreated.equals(commande.dateCreated) : commande.dateCreated != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commandeId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (totalAmount != null ? totalAmount.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }

   /* @OneToMany(mappedBy = "commandeByCommandeId")
    public Collection<Produitcommande> getProduitcommandesByCommandeId() {
        return produitcommandesByCommandeId;
    }

    public void setProduitcommandesByCommandeId(Collection<Produitcommande> produitcommandesByCommandeId) {
        this.produitcommandesByCommandeId = produitcommandesByCommandeId;
    }*/
}
