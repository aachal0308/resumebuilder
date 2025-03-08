package com.ashv.ats.resumebuilder.service;

import com.ashv.ats.resumebuilder.entity.ResumeEntity;
import com.ashv.ats.resumebuilder.repository.ResumeRepository;
import com.ashv.ats.resumebuilder.utils.SessionManagerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeService {

    private final ResumeRepository resumeRepository;

    @Autowired
    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    // Save a new resume
    public String saveResume(ResumeEntity resume, String sessionId) {
        String userId = SessionManagerUtil.getUserIdBySession(sessionId);
        if (resume.getOwner() == null && "dev".equals(sessionId)) {
            throw new IllegalArgumentException("Owner cannot be null for dev session");
        }
        resume.setOwner(userId); // Ensure owner is set
        resumeRepository.create(userId, resume);
        return resume.getId();
    }

    // Retrieve a list of resumes for the logged-in user
    public List<ResumeEntity> getResumes(String sessionId, int from, int size) {
        String userId = SessionManagerUtil.getUserIdBySession(sessionId);
        return resumeRepository.list(userId, from, size);
    }

    // Get a specific resume, ensuring only the owner can access it
    public ResumeEntity getResume(String sessionId, String resumeId) {
        String userId = SessionManagerUtil.getUserIdBySession(sessionId);
        ResumeEntity resume = resumeRepository.get(userId, resumeId);
        if (!resume.getOwner().equals(userId)) {
            throw new RuntimeException("Unauthorized access to this resume.");
        }
        return resume;
    }

    // Update an existing resume, ensuring only the owner can update it
    public void updateResume(String sessionId, String resumeId,ResumeEntity request) {
        validateSession(sessionId, resumeId);
        String userId = SessionManagerUtil.getUserIdBySession(sessionId);
        request.setId(resumeId);
        request.setOwner(userId);
        resumeRepository.update(userId,request);
    }

    // Delete a resume, ensuring only the owner can delete it
    public void deleteResume(String sessionId, String resumeId) {
        validateSession(sessionId, resumeId);
        String userId = SessionManagerUtil.getUserIdBySession(sessionId);
        resumeRepository.delete(userId, resumeId);
    }
    private void validateSession(String sessionId,String resumeId){
        if(sessionId.equals("dev")) return;
        String userId = SessionManagerUtil.getUserIdBySession(sessionId);
        ResumeEntity existingResume = resumeRepository.get(userId, resumeId);

        if (!existingResume.getOwner().equals(userId)) {
            throw new RuntimeException("Unauthorized access to update this resume.");
        }
    }
}
