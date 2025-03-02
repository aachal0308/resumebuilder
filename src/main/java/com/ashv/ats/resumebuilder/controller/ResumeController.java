package com.ashv.ats.resumebuilder.controller;
import com.ashv.ats.resumebuilder.Dto.ResumeDTO;
import com.ashv.ats.resumebuilder.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    private final ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    // Save User Data (No HTML)
    @PostMapping("/save")
    public ResponseEntity<String> saveResume(@RequestBody ResumeDTO resumeDTO) {
        String id = resumeService.saveResume(resumeDTO);
        return ResponseEntity.ok("Resume saved with ID: " + id);
    }

    // Generate Resume HTML Dynamically
    @GetMapping("/preview/{id}")
    public ResponseEntity<String> previewResume(@PathVariable String id) {
        String resumeHtml = resumeService.generateResumeHtml(id);
        return ResponseEntity.ok(resumeHtml);
    }
}

