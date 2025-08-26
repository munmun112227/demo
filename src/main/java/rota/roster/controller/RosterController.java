package rota.roster.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rota.roster.model.RosterService;
import rota.roster.model.RosterVO;

import java.util.List;

@RestController
@RequestMapping("/rosters")
public class RosterController {

    private final RosterService rosterService;
    private final ObjectMapper objectMapper;

    public RosterController(RosterService rosterService, ObjectMapper objectMapper) {
        this.rosterService = rosterService;
        this.objectMapper = objectMapper;
    }

    /**
     * 根據ID獲取單個Roster
     * @param id Roster ID
     * @return ResponseEntity<String>
     */
    @GetMapping("/{id}")
    public ResponseEntity<String> getRosterById(@PathVariable Integer id) {
        try {
            RosterVO roster = rosterService.getRosterById(id);
            return ResponseEntity.ok(objectMapper.writeValueAsString(roster));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to process JSON.\"}");
        }
    }

    /**
     * 獲取所有Rosters
     * @return ResponseEntity<String>
     */
    @GetMapping("/list")
    public ResponseEntity<String> getAllRosters() {
        try {
            List<RosterVO> rosters = rosterService.getAllRosters();
            return ResponseEntity.ok(objectMapper.writeValueAsString(rosters));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to process JSON.\"}");
        }
    }

    /**
     * 新增Roster
     * @param rosterVO Roster object
     * @return ResponseEntity<String>
     */
    @PostMapping
    public ResponseEntity<String> createRoster(@RequestBody RosterVO rosterVO) {
        try {
            rosterService.saveRoster(rosterVO);
            return ResponseEntity.ok("{\"success\": \" Roster saved.\"}");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to save roster.\"}");
        }
    }
}