package rota.competence.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rota.competence.model.CompetenceService;
import rota.competence.model.CompetenceVO;

import java.util.List;

@RestController
@RequestMapping("/competences")
public class CompetenceController {

    private final CompetenceService competenceService;
    private final ObjectMapper objectMapper;

    public CompetenceController(CompetenceService competenceService, ObjectMapper objectMapper) {
        this.competenceService = competenceService;
        this.objectMapper = objectMapper;
    }

    /**
     * 根據ID獲取單個Competence
     * @param id Competence ID
     * @return ResponseEntity<String>
     */
    @GetMapping("/{id}")
    public ResponseEntity<String> getCompetenceById(@PathVariable Integer id) {
        try {
            CompetenceVO competence = competenceService.findById(id);
            return ResponseEntity.ok(objectMapper.writeValueAsString(competence));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{"error": "Error fetching competence: " + e.getMessage()}");
        }
    }

    /**
     * 獲取所有Competences
     * @return ResponseEntity<String>
     */
    @GetMapping("/list")
    public ResponseEntity<String> getAllCompetences() {
        try {
            List<CompetenceVO> competences = competenceService.findAll();
            return ResponseEntity.ok(objectMapper.writeValueAsString(competences));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{"error": "Error fetching competences: " + e.getMessage()}");
        }
    }

    /**
     * 新增Competence
     * @param competenceVO Competence object
     * @return ResponseEntity<String>
     */
    @PostMapping
    public ResponseEntity<String> createCompetence(@RequestBody CompetenceVO competenceVO) {
        try {
            competenceService.save(competenceVO);
            return ResponseEntity.ok("{"message": "Competence created successfully"}");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{"error": "Error creating competence: " + e.getMessage()}");
        }
    }

    /**
     * 修改Competence
     * @param competenceVO Competence object
     * @return ResponseEntity<String>
     */
    @PutMapping
    public ResponseEntity<String> updateCompetence(@RequestBody CompetenceVO competenceVO) {
        try {
            competenceService.update(competenceVO);
            return ResponseEntity.ok("{"message": "Competence updated successfully"}");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{"error": "Error updating competence: " + e.getMessage()}");
        }
    }
}