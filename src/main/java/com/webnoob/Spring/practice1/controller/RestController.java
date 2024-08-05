package com.webnoob.Spring.practice1.controller;

import com.webnoob.Spring.practice1.Entity.DataEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController

@RequestMapping("/journel")
public class RestController {

    private Map<Integer,DataEntity> data = new HashMap<>();

    @GetMapping
    public List<DataEntity> getAllData(){
        return new ArrayList<>(data.values());
    }

    @PostMapping
    public boolean createEntity(@RequestBody DataEntity postData){
        data.put(postData.getId(),postData);
        return true;
    }

    @GetMapping("id/{myId}")
    public DataEntity getDataById(@PathVariable Integer myId){
        return data.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public DataEntity deleteDataById(@PathVariable Integer myId){
        return data.remove(myId);
    }

    @PutMapping("id/{id}")
    public DataEntity updateDataById(@PathVariable Integer id, @RequestBody DataEntity myData){
        return data.put(id,myData);
    }
}
