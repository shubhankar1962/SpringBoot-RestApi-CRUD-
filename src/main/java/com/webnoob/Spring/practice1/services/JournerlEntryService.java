package com.webnoob.Spring.practice1.services;

import com.webnoob.Spring.practice1.Entity.EntityDb;
import com.webnoob.Spring.practice1.repository.InterfaceDbRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournerlEntryService {

    @Autowired
    private InterfaceDbRepo repo;

    public List<EntityDb> getAll(){
        return repo.findAll();
    }

     public void saveEntry(EntityDb entityDb){
        repo.save(entityDb);
    }

    public Optional<EntityDb> findDataById(ObjectId id){
        return repo.findById(id);
    }

    public void deleteDataById(ObjectId id){
        repo.deleteById(id);
    }
}



//controller --> services-->repository