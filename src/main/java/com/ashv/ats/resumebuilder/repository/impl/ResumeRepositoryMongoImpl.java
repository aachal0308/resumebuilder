package com.ashv.ats.resumebuilder.repository.impl;

import com.ashv.ats.resumebuilder.entity.ResumeEntity;
import com.ashv.ats.resumebuilder.repository.ResumeRepository;
import com.ashv.ats.resumebuilder.utils.SessionManagerUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Primary
@Component
public class ResumeRepositoryMongoImpl implements ResumeRepository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public ResumeRepositoryMongoImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    
    public List<ResumeEntity> list(String userId, int from, int size) {
        Query query = new Query();
        if(!SessionManagerUtil.DEV_USER.equals(userId)) 
            query.addCriteria(Criteria.where("owner").is(userId));
        query.skip(from).limit(size);
        return mongoTemplate.find(query, ResumeEntity.class);
    }
    public ResumeEntity get(String userId, String resumeId) {
        Query query = new Query();
        
        // Ensure correct field names: "_id" for MongoDB ID and "userId"
        if(!SessionManagerUtil.DEV_USER.equals(userId)) 
            query.addCriteria(Criteria.where("owner").is(userId).and("_id").is(resumeId));
        else 
            query.addCriteria(Criteria.where("_id").is(resumeId));
    
        // Fetch the resume
        ResumeEntity resume = mongoTemplate.findOne(query, ResumeEntity.class);
        
        // Throw a custom exception if not found
        if (resume == null) {
            throw new RuntimeException("Resume not found, It may not exist or deleted");
        }
        
        return resume;
    }
    
    public void create(String userId, ResumeEntity resume) {
        System.out.println("DEBUG: Resume Owner before setting = " + resume.getOwner());

        // Ensure owner is set before saving
        if (resume.getOwner() == null || resume.getOwner().isEmpty()) {
            resume.setOwner(userId);
        }
    
        // Print after setting owner
        System.out.println("DEBUG: Resume Owner after setting = " + resume.getOwner());
    
        mongoTemplate.save(resume);
    }

    public void update(String userId, ResumeEntity resume) {
        ResumeEntity existingResume = get(userId, resume.getId());
        if (existingResume == null) {
            throw new RuntimeException("Resume not found, It may not exist or deleted");
        }
        mongoTemplate.save(resume);
    }

    public void delete(String userId, String resumeId) {
        ResumeEntity resume = get(userId, resumeId);
        mongoTemplate.remove(resume);
    }
}
