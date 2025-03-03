package com.ashv.ats.resumebuilder.repository.impl;

import com.ashv.ats.resumebuilder.entity.ResumeEntity;
import com.ashv.ats.resumebuilder.repository.ResumeRepository;
import org.springframework.stereotype.Component;
import com.ashv.ats.resumebuilder.exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ResumeRepositoryTempImpl implements ResumeRepository {
    
    private Map<String, Map<String, ResumeEntity>> resumeMap = new HashMap<>(); // userId vs (resumeId vs resume)

    public List<ResumeEntity> list(String userId, int from, int size) {
        Map<String, ResumeEntity> resumes = resumeMap.get(userId);
        if(resumes==null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(resumes.values());
    }
    public ResumeEntity get(String userId, String resumeId) {
        Map<String, ResumeEntity> resumes = resumeMap.get(userId);
        if(resumes==null) {
            throw new RuntimeException("Resume not found, It may not exist or deleted")
        }
        ResumeEntity resume = resumeId resumes.get(resumeId);
        if(resume==null) {
            throw new RuntimeException("Resume not found, It may not exist or deleted")
        }
        return resume;
    }
    public void create(String userId, ResumeEntity resume) {
        Map<String, ResumeEntity> resumes = resumeMap.get(userId);
        if(resumes==null) {
            resumes = new HashMap<>();
            resumeMap.put(userId, resumes);
        }
        resumes.put(resume.getId(), resume);
    }
    public void update(String userId, ResumeEntity resume) {

    }
    public void delete(String userId, String resumeId) {
        Map<String, ResumeEntity> resumes = resumeMap.get(userId);
        if(resumes==null) {
            throw new RuntimeException("Resume not found, It may not exist or deleted")
        }
        ResumeEntity resume = resumeId resumes.get(resumeId);
        if(resume==null) {
            throw new RuntimeException("Resume not found, It may not exist or deleted")
        }
        resume.remove(resumeId);
    }
}
