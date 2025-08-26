package rota.deptbudget.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rota.deptbudget.model.DepartmentBudgetService;
import rota.deptbudget.model.DepartmentBudgetVO;

import java.util.List;

@RestController
@RequestMapping("/deptbudgets")
public class DepartmentBudgetController {
    private final DepartmentBudgetService departmentBudgetService;
    private final ObjectMapper objectMapper;
    public DepartmentBudgetController(DepartmentBudgetService departmentBudgetService, ObjectMapper objectMapper) {
        this.departmentBudgetService = departmentBudgetService;
        this.objectMapper = objectMapper;
    }

    /**
     * 取得部門預算資訊
     * @return 部門預算資訊
     */
    @GetMapping("/getDepartmentBudgets")
    public ResponseEntity<String> getDepartmentBudgets() {
        List<DepartmentBudgetVO> departmentBudgetVOList = departmentBudgetService.getAllDepartmentBudgets();
        try {
            String jsonString = objectMapper.writeValueAsString(departmentBudgetVOList);
            return ResponseEntity.ok(jsonString);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to process JSON.\"}");
        }
    }

    /**
     * 指定部門預算資訊
     * @param departmentId 部門編號
     * @return 指定部門預算資訊
     */
    @GetMapping("/getDepartmentBudgetById/{departmentId}")
    public ResponseEntity<String> getDepartmentBudgetById(@PathVariable("departmentId") Integer departmentId) {
        DepartmentBudgetVO departmentBudgetVO = departmentBudgetService.getDepartmentBudgetById(departmentId);
        try {
            String jsonString = objectMapper.writeValueAsString(departmentBudgetVO);
            return ResponseEntity.ok(jsonString);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to process JSON.\"}");
        }
    }

    /**
     * 新增或是修改預算資訊
     * @param departmentBudgetVO
     * @return
     */
    @PostMapping("/saveDepartmentBudget")
    public ResponseEntity<String> saveDepartmentBudget(@RequestBody DepartmentBudgetVO departmentBudgetVO) {
        try{
            departmentBudgetService.saveDepartmentBudget(departmentBudgetVO);
            return ResponseEntity.ok("{\"success\": \"Department budget saved.\"}");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to save department budget.\"}");
        }
    }
}
