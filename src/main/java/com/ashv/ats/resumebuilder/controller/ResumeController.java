package com.ashv.ats.resumebuilder.controller;

import com.ashv.ats.resumebuilder.entity.ResumeEntity;
import com.ashv.ats.resumebuilder.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    private final ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    // Save a new resume
    @PostMapping("/save")
    public ResponseEntity<String> saveResume(@RequestBody ResumeEntity resumeEntity, @RequestHeader("session") String sessionId) {
        String id = resumeService.saveResume(resumeEntity, sessionId);
        return ResponseEntity.ok("Resume saved with ID: " + id);
    }

    // Get all resumes for the logged-in user
    @GetMapping("/list")
    public ResponseEntity<List<ResumeEntity>> getResumes(@RequestHeader("session") String sessionId,
                                                         @RequestParam(defaultValue = "0") int from,
                                                         @RequestParam(defaultValue = "10") int size) {
        List<ResumeEntity> resumes = resumeService.getResumes(sessionId, from, size);
        return ResponseEntity.ok(resumes);
    }

    // Get a specific resume by ID
    @GetMapping("/{resumeId}")
    public ResponseEntity<ResumeEntity> getResume(@RequestHeader("session") String sessionId,
                                                  @PathVariable String resumeId) {
        System.out.println("Received session header: " + sessionId);
        ResumeEntity resume = resumeService.getResume(sessionId, resumeId);
        return ResponseEntity.ok(resume);
    }

    // Update a resume
    @PutMapping("/update/{resumeId}")
    public ResponseEntity<String> updateResume(@RequestHeader("session") String sessionId,
                                               @PathVariable String resumeId ,@RequestBody ResumeEntity request1) {
        resumeService.updateResume(sessionId, resumeId,request1);
        return ResponseEntity.ok("Resume updated successfully.");
    }

    // Delete a resume
    @DeleteMapping("/delete/{resumeId}")
    public ResponseEntity<String> deleteResume(@RequestHeader("session") String sessionId,
                                               @PathVariable String resumeId) {
        resumeService.deleteResume(sessionId, resumeId);
        return ResponseEntity.ok("Resume deleted successfully.");
    }
}

