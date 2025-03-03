package com.ashv.ats.resumebuilder.repository;

import com.ashv.ats.resumebuilder.entity.ResumeEntity;

import java.util.List;


public interface ResumeRepository {
    
    public List<ResumeEntity> list(String userId, int from, int size);
    public ResumeEntity get(String userId, String resumeId);
    public void create(String userId, ResumeEntity resume);
    public void update(String userId, ResumeEntity resume);
    public void delete(String userId, String resumeId);
}
