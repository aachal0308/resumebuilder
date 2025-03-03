package com.ashv.ats.resumebuilder.service;

import com.ashv.ats.resumebuilder.Dto.ResumeDTO;
import com.ashv.ats.resumebuilder.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResumeService {

    private final ResumeRepository resumeRepository;

    @Autowired
    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    // Save user data (Only Raw Data, No HTML)
    public String saveResume(String userId, Resume resume) {
        resumeRepository.create(userId, resume);
        return resume.getId();
    }
    public String updateResume(String userId, Resume resume, String sessionId) {
        Resume existingResume = resumeRepository.get(userId, resume.getId());
        if (!existingResume.getSessionId().equals(sessionId)) {
            return "Unauthorized: Cannot update another user's resume!";
        }
        resumeRepository.update(userId, resume);
        return "Resume updated successfully.";
    }

    // Delete Resume (Ensure session ID matches)
    public String deleteResume(String userId, String resumeId, String sessionId) {
        Resume existingResume = resumeRepository.get(userId, resumeId);
        if (!existingResume.getSessionId().equals(sessionId)) {
            return "Unauthorized: Cannot delete another user's resume!";
        }
        resumeRepository.delete(userId, resumeId);
        return "Resume deleted successfully.";
    }

    // Get All Resumes (Only ID and Label)
    public List<Resume> getAllResumes(String userId) {
        return resumeRepository.list(userId, 0, Integer.MAX_VALUE)
                .stream()
                .map(resume -> new Resume(resume.getId(), resume.getName(), null, null, resume.getSessionId()))
                .collect(Collectors.toList());
    }

    // Get Resume Details by ID
    public Optional<Resume> getResumeDetails(String userId, String resumeId) {
        return Optional.ofNullable(resumeRepository.get(userId, resumeId));
    }
}
}
