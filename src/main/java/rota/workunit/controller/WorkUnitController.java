package rota.workunit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rota.workunit.model.WorkUnitService;
import rota.workunit.model.WorkUnitVO;

import java.util.List;

@RestController
@RequestMapping("/workunits")
public class WorkUnitController {

    private final WorkUnitService workUnitService;
    private final ObjectMapper objectMapper;

    public WorkUnitController(WorkUnitService workUnitService, ObjectMapper objectMapper) {
        this.workUnitService = workUnitService;
        this.objectMapper = objectMapper;
    }

    /**
     * 根據ID獲取單個WorkUnit
     * @param id WorkUnit ID
     * @return ResponseEntity<String>
     */
    @GetMapping("/{id}")
    public ResponseEntity<String> getWorkUnitById(@PathVariable Integer id) {
        try {
            WorkUnitVO workUnit = workUnitService.getWorkUnitById(id);
            return ResponseEntity.ok(objectMapper.writeValueAsString(workUnit));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to process JSON.\"}");
        }
    }

    /**
     * 獲取所有WorkUnits
     * @return ResponseEntity<String>
     */
    @GetMapping("/list")
    public ResponseEntity<String> getAllWorkUnits() {
        try {
            List<WorkUnitVO> workUnits = workUnitService.getAllWorkUnits();
            return ResponseEntity.ok(objectMapper.writeValueAsString(workUnits));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to process JSON.\"}");
        }
    }

    /**
     * 新增WorkUnit
     * @param workUnitVO WorkUnit object
     * @return ResponseEntity<String>
     */
    @PostMapping("/save")
    public ResponseEntity<String> createWorkUnit(@RequestBody WorkUnitVO workUnitVO) {
        try {
            workUnitService.saveWorkUnit(workUnitVO);
            return ResponseEntity.ok("{\"success\": \" Work unit saved.\"}");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to save work unit.\"}");
        }
    }
}