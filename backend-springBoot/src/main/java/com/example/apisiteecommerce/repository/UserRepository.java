package com.example.apisiteecommerce.repository;

import com.example.apisiteecommerce.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Client,Integer> {
    Client findByEmail(String email);

}
