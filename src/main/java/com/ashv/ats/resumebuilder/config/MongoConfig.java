package com.ashv.ats.resumebuilder.config;

import com.mongodb.client.MongoClients;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {

    private static final String DATABASE_NAME = "resume_builder";
    private static final String MONGO_URI = "mongodb://localhost:27017/" + DATABASE_NAME;

    @Resource(name="userMongoTemplate")
    @Bean
    public MongoTemplate userMongoTemplate() {
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(MongoClients.create(MONGO_URI), DATABASE_NAME));
    }

    
}
