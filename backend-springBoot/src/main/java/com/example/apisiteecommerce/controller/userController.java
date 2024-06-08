package com.example.apisiteecommerce.controller;

import com.example.apisiteecommerce.Entity.Client;
import com.example.apisiteecommerce.service.clientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class userController {
    @Autowired
    clientService service;

    @PostMapping("/post")
    public Client CreateUser(@RequestBody Client u){
        this.service.save(u);
        return u;
    }

    @GetMapping("/{id}")
    public Client getUserById(@PathVariable Integer id){
        return this.service.getById(id);
    }

    @GetMapping
    public List<Client> getAllUsers(){
        return this.service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id){
        this.service.delete(id);
    }

    }



