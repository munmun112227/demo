package rota.employee.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rota.employee.model.EmployeeService;
import rota.employee.model.EmployeeVO;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final ObjectMapper objectMapper;

    public EmployeeController(EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    /**
     * 根據ID獲取單個Employee
     * @param id Employee ID
     * @return ResponseEntity<String>
     */
    @GetMapping("/{id}")
    public ResponseEntity<String> getEmployeeById(@PathVariable Integer id) {
        try {
            EmployeeVO employee = employeeService.getEmployeeById(id);
            return ResponseEntity.ok(objectMapper.writeValueAsString(employee));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to process JSON.\"}");
        }
    }

    /**
     * 獲取所有Employees
     * @return ResponseEntity<String>
     */
    @GetMapping("/list")
    public ResponseEntity<String> getAllEmployees() {
        try {
            List<EmployeeVO> employees = employeeService.getAllEmployees();
            return ResponseEntity.ok(objectMapper.writeValueAsString(employees));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to process JSON.\"}");
        }
    }

    /**
     * 新增修改Employee
     * @param employeeVO Employee object
     * @return ResponseEntity<String>
     */
    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeVO employeeVO) {
        try {
            employeeService.saveEmployee(employeeVO);
            return ResponseEntity.ok("{\"success\": \" Employee saved.\"}");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to save employee.\"}");
        }
    }
}