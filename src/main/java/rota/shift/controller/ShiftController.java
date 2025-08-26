package rota.shift.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rota.shift.modle.ShiftService;
import rota.shift.modle.ShiftVO;

import java.util.List;

@RestController
@RequestMapping("/shifts")
public class ShiftController {

    private final ShiftService shiftService;
    private final ObjectMapper objectMapper;

    public ShiftController(ShiftService shiftService, ObjectMapper objectMapper) {
        this.shiftService = shiftService;
        this.objectMapper = objectMapper;
    }

    /**
     * 根據ID獲取單個Shift
     * @param shiftName Shift ID
     * @return ResponseEntity<String>
     */
    @GetMapping("/{id}")
    public ResponseEntity<String> getShiftById(@PathVariable String shiftName) {
        try {
            ShiftVO shift = shiftService.getShiftByName(shiftName);
            return ResponseEntity.ok(objectMapper.writeValueAsString(shift));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to process JSON.\"}");
        }
    }

    /**
     * 獲取所有Shifts
     * @return ResponseEntity<String>
     */
    @GetMapping("/list")
    public ResponseEntity<String> getAllShifts() {
        try {
            List<ShiftVO> shifts = shiftService.getAllShifts();
            return ResponseEntity.ok(objectMapper.writeValueAsString(shifts));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to process JSON.\"}");
        }
    }

    /**
     * 新增修改Shift
     * @param shiftVO Shift object
     * @return ResponseEntity<String>
     */
    @PostMapping
    public ResponseEntity<String> saveShift(@RequestBody ShiftVO shiftVO) {
        try {
            shiftService.saveShift(shiftVO);
            return ResponseEntity.ok("{\"success\": \" Shift saved.\"}");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to save shift.\"}");
        }
    }
}