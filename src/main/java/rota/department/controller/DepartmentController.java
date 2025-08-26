package rota.department.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rota.department.model.DepartmentService;
import rota.department.model.DepartmentVO;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    private final ObjectMapper objectMapper;

    public DepartmentController(DepartmentService departmentService, ObjectMapper objectMapper){
        this.departmentService = departmentService;
        this.objectMapper = objectMapper;
    }

    /**
     * 取得所有的部門資訊
     * @return List<DepartmentVO>
     */
    @GetMapping("/getDepartments")
    public ResponseEntity<String> getDepartments() {
        List<DepartmentVO> departmentVOList = departmentService.getAllDepartments();

        try {
            String jsonString = objectMapper.writeValueAsString(departmentVOList);
            return ResponseEntity.ok(jsonString);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to process JSON.\"}");
        }

    }

    /**
     * 取得指定ID的部門資訊
     * @param departmentId
     * @return DepartmentVO
     */
    @GetMapping("/getDepartmentById/{departmentId}")
    public ResponseEntity getDepartmentById(@PathVariable("departmentId") Integer departmentId) {
        DepartmentVO departmentVO = departmentService.getDepartmentById(departmentId);

        try{
            String jsonString = objectMapper.writeValueAsString(departmentVO);
            return ResponseEntity.ok(jsonString);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to process JSON.\"}");
        }
    }

    /**
     * 新增或是修改部門資訊
     * @param departmentVO 需傳入部門編號、部門名稱以及部門主管員編（如果新增部門不用部門編號，由系統自動編號）
     * @return 回傳狀態代碼
     */
    @PostMapping("/saveDepartment")
    public ResponseEntity<String> saveDepartment(@RequestBody DepartmentVO departmentVO) {
        try{
            departmentService.saveDepartment(departmentVO);
            return ResponseEntity.ok("{\"success\": \"Department saved.\"}");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to save department.\"}");
        }
    }
}
