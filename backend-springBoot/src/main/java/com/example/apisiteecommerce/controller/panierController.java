package com.example.apisiteecommerce.controller;

import com.example.apisiteecommerce.Entity.Panier;
import com.example.apisiteecommerce.service.panierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/panier")
public class panierController {
    @Autowired
    panierService service;

    @PostMapping("/post")
    public Panier CreateUser(@RequestBody Panier u){
        this.service.save(u);
        return u;
    }

    @GetMapping("/{id}")
    public Panier getUserById(@PathVariable Integer id){
        return this.service.getById(id);
    }

    @GetMapping
    public List<Panier> getAllUsers(){
        return this.service.getAll();
    }

    //@DeleteMapping("/delete/{id}")
    //public void deleteUser(@PathVariable Integer id){
        //this.service.delete(id);
    //}

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void deleteProductById(@PathVariable Long id){
        this.service.delete(id);
    }



/*
    @PutMapping("/update-quantity/{id}")
    public ResponseEntity<?> updateProductQuantity(@PathVariable int id, @RequestBody int quantity) {
        try {
            // Récupérer le panier par son ID
            Panier panier = service.getById(id);

            // Vérifier si le panier existe
            if (panier == null) {
                return ResponseEntity.notFound().build();
            }

            // Mettre à jour la quantité du produit dans le panier
            panier.setQuantity(quantity);

            // Enregistrer les modifications dans la base de données
            service.save(panier);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // Gérer les exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
*/
@PutMapping("/put/{id}")
public Panier UpdateCart(@PathVariable Long id, @RequestBody Panier c ){
    this.service.updateCartByProductId(id,c);
    return c;
}
    @PutMapping("/update-quantity/{productId}")
    public ResponseEntity<?> updateQuantity(@PathVariable int productId,
                                            @RequestParam int quantity,
                                            @RequestParam int userId) {
        try {
            // Vérifier si le panier existe pour cet utilisateur et ce produit
            Panier panier = service.findByUserIdAndProductId(userId, productId);

            if (panier == null) {
                return ResponseEntity.notFound().build();
            }

            // Mettre à jour la quantité du produit dans le panier
            panier.setQuantity(quantity);

            // Enregistrer les modifications dans le service
            service.save(panier);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // Gérer les exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}

