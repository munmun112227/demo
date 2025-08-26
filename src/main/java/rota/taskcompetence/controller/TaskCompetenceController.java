package rota.taskcompetence.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rota.taskcompetence.model.TaskCompetenceId;
import rota.taskcompetence.model.TaskCompetenceService;
import rota.taskcompetence.model.TaskCompetenceVO;

import java.util.List;

@RestController
@RequestMapping("/taskcompetences")
public class TaskCompetenceController {

    private final TaskCompetenceService taskCompetenceService;
    private final ObjectMapper objectMapper;

    public TaskCompetenceController(TaskCompetenceService taskCompetenceService, ObjectMapper objectMapper) {
        this.taskCompetenceService = taskCompetenceService;
        this.objectMapper = objectMapper;
    }

    /**
     * 根據ID獲取單個TaskCompetence
     * @param id TaskCompetence ID
     * @return ResponseEntity<String>
     */
    @GetMapping("/getOne")
    public ResponseEntity<String> getTaskCompetenceById(@RequestBody TaskCompetenceId id) {
        try {
            TaskCompetenceVO taskCompetence = taskCompetenceService.getTaskCompetenceById(id);
            return ResponseEntity.ok(objectMapper.writeValueAsString(taskCompetence));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to process JSON.\"}");
        }
    }

    /**
     * 獲取所有TaskCompetences
     * @return ResponseEntity<String>
     */
    @GetMapping("/list")
    public ResponseEntity<String> getAllTaskCompetences() {
        try {
            List<TaskCompetenceVO> taskCompetences = taskCompetenceService.getAllTaskCompetences();
            return ResponseEntity.ok(objectMapper.writeValueAsString(taskCompetences));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to process JSON.\"}");
        }
    }

    /**
     * 新增修改TaskCompetence
     * @param taskCompetenceVO TaskCompetence object
     * @return ResponseEntity<String>
     */
    @PostMapping("/save")
    public ResponseEntity<String> createTaskCompetence(@RequestBody TaskCompetenceVO taskCompetenceVO) {
        try {
            taskCompetenceService.saveTaskCompetence(taskCompetenceVO);
            return ResponseEntity.ok("{\"success\": \" Task competence saved.\"}");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to save task competence.\"}");
        }
    }
}