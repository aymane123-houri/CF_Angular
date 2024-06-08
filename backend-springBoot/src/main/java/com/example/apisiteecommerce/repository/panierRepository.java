package com.example.apisiteecommerce.repository;

import com.example.apisiteecommerce.Entity.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface panierRepository extends JpaRepository<Panier,Integer> {

    @Modifying
    @Query("DELETE FROM Panier c WHERE c.product.productID = :productId")
    void deleteByProductId(Long productId);

    @Query("SELECT c FROM Panier c WHERE c.product.productID = :someValue")
    List<Panier> findByProductId(@Param("someValue") Long someValue);

    @Query("SELECT c FROM Panier c WHERE c.userId = :someValue")
    List<Panier> findByUsertId(@Param("someValue") Long someValue);

    Optional<Panier> findByUserIdAndProduct_ProductID(int userId, int productID);
}
