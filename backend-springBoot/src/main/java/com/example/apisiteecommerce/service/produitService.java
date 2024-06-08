package com.example.apisiteecommerce.service;

import com.example.apisiteecommerce.Entity.Produit;
import com.example.apisiteecommerce.repository.produitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class produitService {
    @Autowired
    private produitRepository produitRep;

   public List<Produit> getAllProduct(){
        return this.produitRep.findAll();

    }


    public Produit getProductById(int id){
        return this.produitRep.findById(id).orElse(null);
    }
    public void saveProduct(Produit produit){
        this.produitRep.save(produit);
    }
    public void deleteProduct (Integer id){
        this.produitRep.deleteById(id);
    }


    public List<Produit> getProductsByCategory(String category) {
        return produitRep.findByCategory(category);
    }

    //coreeect codeeeeeeee
 /*    private int iterationCount = 0;
    private final int MAX_ITERATIONS = 2;

   @Scheduled(fixedDelay = 30000) // Run every minute
    public void decrementPricesEveryMinute() {
        if (iterationCount >= MAX_ITERATIONS) {
            return; // Stop further decrements after two minutes
        }
        List<Produit> products = this.getAllProduct();
        for (Produit product : products) {
            BigDecimal currentPrice = product.getProduct_price();
            double decrementAmount = calculateDecrementAmount(currentPrice);
            double newPrice = currentPrice.doubleValue() - decrementAmount;
            product.setProduct_price(BigDecimal.valueOf(newPrice));
        }
        produitRep.saveAll(products);
        iterationCount++;
    }

    private double calculateDecrementAmount( BigDecimal currentPrice) {
        // Define your logic for calculating the decrement amount here
        // For simplicity, let's say we decrement by 10%
        return currentPrice.doubleValue() * 0.1;
    }*/

/*
    private Map<Integer, BigDecimal> originalPrices = new HashMap<>(); // Map to store original prices by product ID
    private int iterationCount = 0;
    private final int MAX_ITERATIONS = 1;

    @Scheduled(fixedDelay = 30000) // Run every 30 seconds
    public void decrementPricesEveryThirtySeconds() {
        if (iterationCount >= MAX_ITERATIONS) {
            // If two iterations are completed, restore original prices and stop further decrements
            restoreOriginalPrices();
            return;
        }
        List<Produit> products = this.getAllProduct();

        if (originalPrices.isEmpty()) {
            // Store original prices before first decrement
            products = this.getAllProduct();
            for (Produit product : products) {
                originalPrices.put(product.getProductID(), product.getProduct_price());
            }
        }

        for (Produit product : products) {
            BigDecimal currentPrice = product.getProduct_price();
            double decrementAmount = calculateDecrementAmount(currentPrice);
            double newPrice = currentPrice.doubleValue() - decrementAmount;
            product.setProduct_price(BigDecimal.valueOf(newPrice));
        }

        produitRep.saveAll(products);
        iterationCount++;
    }

    private void restoreOriginalPrices() {
        List<Produit> products = this.getAllProduct();
        for (Produit product : products) {
            BigDecimal originalPrice = originalPrices.get(product.getProductID());
            if (originalPrice != null) {
                product.setProduct_price(originalPrice);
            }
        }
        produitRep.saveAll(products);
        // Clear the map after restoring original prices
        originalPrices.clear();
        iterationCount = 0; // Reset iteration count
    }



    private double calculateDecrementAmount(BigDecimal currentPrice) {
        // Define your logic for calculating the decrement amount here
        // For simplicity, let's say we decrement by 10%
        double decrementPercentage = 0.1;
        return currentPrice.multiply(BigDecimal.valueOf(decrementPercentage)).doubleValue();
    }
*/




    /*n'est pas fonctionner
    public void applyPromotion(double promotionPercentage, long delayInMillis) {
        // Mémoriser les prix initiaux
        Map<Integer, BigDecimal> originalPrices = new HashMap<>();
        List<Produit> products = getAllProduct();
        for (Produit product : products) {
            originalPrices.put(product.getProductID(), product.getProduct_price());
        }

        // Appliquer la promotion
        for (Produit product : products) {
            BigDecimal currentPrice = product.getProduct_price();
            BigDecimal promotionAmount = currentPrice.multiply(BigDecimal.valueOf(promotionPercentage / 100));
            BigDecimal newPrice = currentPrice.subtract(promotionAmount);
            product.setProduct_price(newPrice);
        }
        produitRep.saveAll(products);

        // Attendre le délai spécifié
        try {
            Thread.sleep(delayInMillis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Le délai d'attente a été interrompu : " + e.getMessage());
        }

        // Restaurer les prix initiaux
        for (Produit product : products) {
            BigDecimal originalPrice = originalPrices.get(product.getProductID());
            if (originalPrice != null) {
                product.setProduct_price(originalPrice);
            }
        }
        produitRep.saveAll(products);
    }

*/

/*
    private Map<Integer, BigDecimal> originalPrices = new HashMap<>();
    private int iterationCount = 0;
    private double promotionPercentage = 0.0;
    private long promotionDuration = 0;
    private long promotionStartTime = 0;

    public void setPromotion(double percentage, long duration) {
        this.promotionPercentage = percentage;
        this.promotionDuration = duration;
        this.promotionStartTime = System.currentTimeMillis();
        this.iterationCount = 0;
        originalPrices.clear();
    }

    @Scheduled(fixedDelay = 30000) // Run every 30 seconds
    public void decrementPricesEveryThirtySeconds() {
        if (System.currentTimeMillis() - promotionStartTime >= promotionDuration) {
            restoreOriginalPrices();
            return;
        }

        List<Produit> products = this.getAllProduct();

        if (originalPrices.isEmpty()) {
            for (Produit product : products) {
                originalPrices.put(product.getProductID(), product.getProduct_price());
            }
        }

        for (Produit product : products) {
            BigDecimal currentPrice = product.getProduct_price();
            double decrementAmount = calculateDecrementAmount(currentPrice);
            double newPrice = currentPrice.doubleValue() - decrementAmount;
            product.setProduct_price(BigDecimal.valueOf(newPrice));
        }

        produitRep.saveAll(products);
        iterationCount++;
    }

    private void restoreOriginalPrices() {
        List<Produit> products = this.getAllProduct();
        for (Produit product : products) {
            BigDecimal originalPrice = originalPrices.get(product.getProductID());
            if (originalPrice != null) {
                product.setProduct_price(originalPrice);
            }
        }
        produitRep.saveAll(products);
        originalPrices.clear();
        iterationCount = 0;
    }

    private double calculateDecrementAmount(BigDecimal currentPrice) {
        return currentPrice.multiply(BigDecimal.valueOf(promotionPercentage / 100)).doubleValue();
    }*/

    private Map<Integer, BigDecimal> originalPrices = new HashMap<>();
    private double promotionPercentage = 0.0;
    private long promotionDuration = 0;
    private long promotionStartTime = 0;


    public void setPromotion(double percentage, long duration) {
        this.promotionPercentage = percentage;
        this.promotionDuration = duration;
        this.promotionStartTime = System.currentTimeMillis();
        originalPrices.clear();

        // Apply the promotion immediately
        applyPromotion();

        // Schedule a task to restore the original prices after the duration
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                restoreOriginalPrices();
            }
        }, promotionDuration);
    }

    private void applyPromotion() {
        List<Produit> products = produitRep.findAll();

        if (originalPrices.isEmpty()) {
            for (Produit product : products) {
                originalPrices.put(product.getProductID(), product.getProduct_price());
            }
        }

        for (Produit product : products) {
            BigDecimal currentPrice = product.getProduct_price();
            double decrementAmount = calculateDecrementAmount(currentPrice);
            double newPrice = currentPrice.doubleValue() - decrementAmount;
            product.setProduct_price(BigDecimal.valueOf(newPrice));
        }

        produitRep.saveAll(products);
    }

    private void restoreOriginalPrices() {
        List<Produit> products = produitRep.findAll();
        for (Produit product : products) {
            BigDecimal originalPrice = originalPrices.get(product.getProductID());
            if (originalPrice != null) {
                product.setProduct_price(originalPrice);
            }
        }
        produitRep.saveAll(products);
        originalPrices.clear();
    }

    private double calculateDecrementAmount(BigDecimal currentPrice) {
        return currentPrice.multiply(BigDecimal.valueOf(promotionPercentage / 100)).doubleValue();
    }
}
