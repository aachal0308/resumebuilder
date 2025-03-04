package com.ashv.ats.resumebuilder.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class MongoCollectionSetup {

    @Qualifier("userMongoTemplate")
    @Autowired
    private MongoTemplate userMongoTemplate;

    @PostConstruct
    public void createCollectionsIfNotExists() {
        if (!userMongoTemplate.collectionExists("userEntity")) {
            userMongoTemplate.createCollection("userEntity");
        }

        
    }
}
