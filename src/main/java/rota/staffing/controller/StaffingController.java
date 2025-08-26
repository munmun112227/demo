package rota.staffing.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rota.staffing.model.StaffingService;
import rota.staffing.model.StaffingVO;

import java.util.List;

@RestController
@RequestMapping("/staffings")
public class StaffingController {

    private final StaffingService staffingService;
    private final ObjectMapper objectMapper;

    public StaffingController(StaffingService staffingService, ObjectMapper objectMapper) {
        this.staffingService = staffingService;
        this.objectMapper = objectMapper;
    }

    /**
     * 根據ID獲取單個Staffing
     * @param id Staffing ID
     * @return ResponseEntity<String>
     */
    @GetMapping("/{id}")
    public ResponseEntity<String> getStaffingById(@PathVariable Integer id) {
        try {
            StaffingVO staffing = staffingService.getStaffingById(id);
            return ResponseEntity.ok(objectMapper.writeValueAsString(staffing));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to process JSON.\"}");
        }
    }

    /**
     * 獲取所有Staffings
     * @return ResponseEntity<String>
     */
    @GetMapping("/list")
    public ResponseEntity<String> getAllStaffings() {
        try {
            List<StaffingVO> staffings = staffingService.getAllStaffings();
            return ResponseEntity.ok(objectMapper.writeValueAsString(staffings));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to process JSON.\"}");
        }
    }

    /**
     * 新增修改Staffing
     * @param staffingVO Staffing object
     * @return ResponseEntity<String>
     */
    @PostMapping("/save")
    public ResponseEntity<String> createStaffing(@RequestBody StaffingVO staffingVO) {
        try {
            staffingService.saveStaffing(staffingVO);
            return ResponseEntity.ok("{\"success\": \"Staffing saved.\"}");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to save staffing.\"}");
        }
    }
}