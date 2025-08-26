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
            CompetenceVO competence = competenceService.getCompetenceById(id);
            return ResponseEntity.ok(objectMapper.writeValueAsString(competence));
        } catch (Exception e) {
            return ResponseEntity.ok("{\"error\": \"Failed to process JSON.\"}");
        }
    }

    /**
     * 新增修改Competence
     * @param competenceVO Competence object
     * @return ResponseEntity<String>
     */
    @PostMapping
    public ResponseEntity<String> createCompetence(@RequestBody CompetenceVO competenceVO) {
        try {
            competenceService.saveCompetence(competenceVO);
            return ResponseEntity.ok("{\"success\": \"Competence saved.\"}");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to save competence.\"}");
        }
    }
}