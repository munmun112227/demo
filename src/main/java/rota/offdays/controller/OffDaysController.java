package rota.offdays.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rota.offdays.model.OffDaysService;
import rota.offdays.model.OffDaysVO;

import java.util.List;

@RestController
@RequestMapping("/offdays")
public class OffDaysController {

    private final OffDaysService offDaysService;
    private final ObjectMapper objectMapper;

    public OffDaysController(OffDaysService offDaysService, ObjectMapper objectMapper) {
        this.offDaysService = offDaysService;
        this.objectMapper = objectMapper;
    }

    /**
     * 根據ID獲取單個OffDays
     * @param id OffDays ID
     * @return ResponseEntity<String>
     */
    @GetMapping("/{id}")
    public ResponseEntity<String> getOffDaysById(@PathVariable Integer id) {
        try {
            OffDaysVO offDays = offDaysService.getOffDaysById(id);
            return ResponseEntity.ok(objectMapper.writeValueAsString(offDays));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to process JSON.\"}");
        }
    }

    /**
     * 獲取所有OffDays
     * @return ResponseEntity<String>
     */
    @GetMapping("/list")
    public ResponseEntity<String> getAllOffDays() {
        try {
            List<OffDaysVO> offDays = offDaysService.getAllOffDays();
            return ResponseEntity.ok(objectMapper.writeValueAsString(offDays));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to process JSON.\"}");
        }
    }

    /**
     * 新增OffDays
     * @param offDaysVO OffDays object
     * @return ResponseEntity<String>
     */
    @PostMapping
    public ResponseEntity<String> createOffDays(@RequestBody OffDaysVO offDaysVO) {
        try {
            offDaysService.saveOffDays(offDaysVO);
            return ResponseEntity.ok("{\"success\": \" OffDays saved.\"}");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to save OffDays.\"}");
        }
    }
}