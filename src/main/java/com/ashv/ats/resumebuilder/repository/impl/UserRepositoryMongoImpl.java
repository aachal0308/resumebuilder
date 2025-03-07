
package com.ashv.ats.resumebuilder.repository.impl;

import com.ashv.ats.resumebuilder.entity.UserEntity;
import com.ashv.ats.resumebuilder.repository.UserRepository;
import com.ashv.ats.resumebuilder.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;


@Component
public class UserRepositoryMongoImpl implements UserRepository {

    @Qualifier("userMongoTemplate")
    @Autowired
    private MongoTemplate userMongoTemplate;

    public UserEntity get(String userId) {
        UserEntity user = userMongoTemplate.findById(userId, UserEntity.class);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }

    public UserEntity getUserByUsername(String username) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        UserEntity user = userMongoTemplate.findOne(query, UserEntity.class);
        if (user == null) {
            query = new Query();
            query.addCriteria(Criteria.where("email").is(username));
            user = userMongoTemplate.findOne(query, UserEntity.class);
        }
        return user;
    }

    public void create(UserEntity user) {
        Query queryEmail = new Query(Criteria.where("email").is(user.getEmail()));
        Query queryUsername = new Query(Criteria.where("username").is(user.getUsername()));

        if (userMongoTemplate.exists(queryEmail, UserEntity.class)) {
            throw new UserAlreadyExistException(user.getEmail());
        }
        if (userMongoTemplate.exists(queryUsername, UserEntity.class)) {
            throw new UsernameAlreadyExistException(user.getUsername());
        }

        userMongoTemplate.save(user);
    }

    public void update(UserEntity user) {
        if (userMongoTemplate.exists(new Query(Criteria.where("id").is(user.getId())), UserEntity.class)) {
            userMongoTemplate.save(user);
        } else {
            throw new UserNotFoundException();
        }
    }

    public void delete(String userId) {
        UserEntity user = get(userId);
        userMongoTemplate.remove(user);
    }
}
