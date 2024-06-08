package com.example.apisiteecommerce.service;

import com.example.apisiteecommerce.Entity.Panier;
import com.example.apisiteecommerce.repository.panierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class panierService {
    @Autowired
    private panierRepository PanierProduitRepository;

    @Autowired
    private panierRepository pan_proRep;

    public List<Panier> getAll(){
        return this.pan_proRep.findAll();

    }
    public Panier getById(int id){
        return this.pan_proRep.findById(id).orElse(null);
    }
    public void save(Panier Panierproduit){
        this.pan_proRep.save(Panierproduit);
    }
    public void delete (Long id){
        this.pan_proRep.deleteByProductId(id);
    }

    public Panier findByUserIdAndProductId(int userId, int productId) {
        return pan_proRep.findByUserIdAndProduct_ProductID(userId, productId).orElse(null);
    }
    @Transactional
    public void updateCartByProductId(Long productId, Panier updatedCart) {
        List<Panier> existingCart = pan_proRep.findByProductId(productId);
        if (existingCart != null) {
            existingCart.get(0).setQuantity(updatedCart.getQuantity());
            pan_proRep.save(existingCart.get(0));
        }
    }
}
