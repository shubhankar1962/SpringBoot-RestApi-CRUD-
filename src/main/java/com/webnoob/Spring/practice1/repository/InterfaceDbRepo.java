package com.webnoob.Spring.practice1.repository;

import com.webnoob.Spring.practice1.Entity.EntityDb;
import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InterfaceDbRepo extends MongoRepository<EntityDb, ObjectId> {

}
