package com.example.apisiteecommerce.controller;

import com.example.apisiteecommerce.Entity.Produit;
import com.example.apisiteecommerce.service.produitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class productController {
    @Autowired
    produitService service;

   /* @PostMapping("/post")
    public Produit CreateProduct(@RequestBody Produit u){
        this.service.saveProduct(u);
        return u;
    }*/

    @GetMapping("/{id}")
    public Produit getProductById(@PathVariable Integer id){
        return this.service.getProductById(id);
    }

    @GetMapping
    public List<Produit> getAllProducts(){
        return this.service.getAllProduct();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Integer id){
        this.service.deleteProduct(id);
    }

    @PostMapping
    public Produit CreateProduct(@RequestBody Produit u){
        this.service.saveProduct(u);
        return u;
    }


    @PutMapping("/{id}")
    public Produit updateProduct(@PathVariable Integer id, @RequestBody Produit updatedProduct) {
        Produit existingProduct = service.getProductById(id);
        if (existingProduct != null) {
            // Mettre à jour uniquement les champs spécifiés
            if (updatedProduct.getProduct_title() != null) {
                existingProduct.setProduct_title(updatedProduct.getProduct_title());
            }
            if (updatedProduct.getProduct_price() != null) {
                existingProduct.setProduct_price(updatedProduct.getProduct_price());
            }
            if (updatedProduct.getDetails() != null) {
                existingProduct.setDetails(updatedProduct.getDetails());
            }
            if (updatedProduct.getCategory() != null) {
                existingProduct.setCategory(updatedProduct.getCategory());
            }
            if (updatedProduct.getProduct_image() != null) {
                existingProduct.setProduct_image(updatedProduct.getProduct_image());
            }
            if (updatedProduct.getQuantity() != 0) {
                existingProduct.setQuantity(updatedProduct.getQuantity());
            }
            // Ajoutez d'autres champs à mettre à jour si nécessaire

            service.saveProduct(existingProduct); // Notez que saveProduct retourne void

            // Retourner le produit mis à jour
            return existingProduct;
        } else {
            throw new RuntimeException("Produit non trouvé avec l'ID : " + id);
        }
    }

    @GetMapping(params = "category")
    public List<Produit> getProductsByCategory(@RequestParam String category) {
        return service.getProductsByCategory(category);
    }


    @PostMapping("/promotions")
    public ResponseEntity<String> setPromotion(@RequestParam double percentage, @RequestParam long duration) {
        System.out.println("Received promotion request: percentage=" + percentage + ", duration=" + duration);
        try {
            service.setPromotion(percentage, duration);
            return ResponseEntity.ok("{\"message\":\"Promotion set successfully\"}"); // JSON response
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }
}
