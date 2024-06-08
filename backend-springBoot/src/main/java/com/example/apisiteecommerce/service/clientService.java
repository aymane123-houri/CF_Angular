package com.example.apisiteecommerce.service;

import com.example.apisiteecommerce.Entity.Client;
import com.example.apisiteecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class clientService {
    @Autowired
    private UserRepository userRep;

    public List<Client> getAll(){
        return this.userRep.findAll();

    }
    public Client getById(int id){
        return this.userRep.findById(id).orElse(null);
    }
    public void save(Client client){
        this.userRep.save(client);
    }
    public void delete (Integer id){
        this.userRep.deleteById(id);
    }

}
