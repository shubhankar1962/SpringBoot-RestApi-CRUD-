package com.webnoob.Spring.practice1.controller;


import com.webnoob.Spring.practice1.Entity.DataEntity;
import com.webnoob.Spring.practice1.Entity.EntityDb;
import com.webnoob.Spring.practice1.services.JournerlEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("journel")
public class RestControllerDb {

    @Autowired
    private JournerlEntryService journelEntryService;

    @GetMapping
    public List<EntityDb> getAllData(){
        return journelEntryService.getAll();

    }

    @PostMapping
    public EntityDb createEntity(@RequestBody EntityDb postData){
        postData.setDate(LocalDateTime.now());
        journelEntryService.saveEntry(postData);
        return postData;
    }

    @GetMapping("id/{myId}")
    public EntityDb getDataById(@PathVariable ObjectId myId){
        return journelEntryService.findDataById(myId).orElse(null);
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteDataById(@PathVariable ObjectId myId){
        journelEntryService.deleteDataById(myId);
        return true;
    }

    @PutMapping("id/{id}")
    public EntityDb updateDataById(@PathVariable ObjectId id, @RequestBody DataEntity myData){
        return null;
    }
}
