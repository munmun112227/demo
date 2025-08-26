package rota.empcompetence.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rota.empcompetence.model.EmployeeCompetenceId;
import rota.empcompetence.model.EmployeeCompetenceService;
import rota.empcompetence.model.EmployeeCompetenceVO;

import java.util.List;

@RestController
@RequestMapping("/empcompetences")
public class EmployeeCompetenceController {

    private final EmployeeCompetenceService employeeCompetenceService;
    private final ObjectMapper objectMapper;

    public EmployeeCompetenceController(EmployeeCompetenceService employeeCompetenceService, ObjectMapper objectMapper) {
        this.employeeCompetenceService = employeeCompetenceService;
        this.objectMapper = objectMapper;
    }

    /**
     * 根據ID獲取單個EmployeeCompetence
     * @param id EmployeeCompetence ID
     * @return ResponseEntity<String>
     */
    @PostMapping("/getall")
    public ResponseEntity<String> getEmployeeCompetenceById(@RequestBody EmployeeCompetenceId id) {
        try {
            EmployeeCompetenceVO employeeCompetence = employeeCompetenceService.getEmployeeCompetenceById(id);
            return ResponseEntity.ok(objectMapper.writeValueAsString(employeeCompetence));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to process JSON.\"}");
        }
    }

    /**
     * 獲取所有EmployeeCompetences
     * @return ResponseEntity<String>
     */
    @GetMapping("/list")
    public ResponseEntity<String> getAllEmployeeCompetences() {
        try {
            List<EmployeeCompetenceVO> employeeCompetences = employeeCompetenceService.getAllEmployeeCompetences();
            return ResponseEntity.ok(objectMapper.writeValueAsString(employeeCompetences));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to process JSON.\"}");
        }
    }

    /**
     * 新增和修改EmployeeCompetence
     * @param employeeCompetenceVO EmployeeCompetence object
     * @return ResponseEntity<String>
     */
    @PostMapping("/save")
    public ResponseEntity<String> createEmployeeCompetence(@RequestBody EmployeeCompetenceVO employeeCompetenceVO) {
        try {
            employeeCompetenceService.saveEmployeeCompetence(employeeCompetenceVO);
            return ResponseEntity.ok("{\"success\": \" Employee's competence saved.\"}");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to save competence.\"}");
        }
    }
}