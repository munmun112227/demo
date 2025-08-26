package rota.task.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rota.task.model.TaskService;
import rota.task.model.TaskVO;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final ObjectMapper objectMapper;

    public TaskController(TaskService taskService, ObjectMapper objectMapper) {
        this.taskService = taskService;
        this.objectMapper = objectMapper;
    }

    /**
     * 根據ID獲取單個Task
     * @param id Task ID
     * @return ResponseEntity<String>
     */
    @GetMapping("/{id}")
    public ResponseEntity<String> getTaskById(@PathVariable Integer id) {
        try {
            TaskVO task = taskService.getTaskById(id);
            return ResponseEntity.ok(objectMapper.writeValueAsString(task));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to process JSON.\"}");
        }
    }

    /**
     * 獲取所有Tasks
     * @return ResponseEntity<String>
     */
    @GetMapping("/list")
    public ResponseEntity<String> getAllTasks() {
        try {
            List<TaskVO> tasks = taskService.getAllTasks();
            return ResponseEntity.ok(objectMapper.writeValueAsString(tasks));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to process JSON.\"}");
        }
    }

    /**
     * 新增Task
     * @param taskVO Task object
     * @return ResponseEntity<String>
     */
    @PostMapping
    public ResponseEntity<String> createTask(@RequestBody TaskVO taskVO) {
        try {
            taskService.saveTask(taskVO);
            return ResponseEntity.ok("{\"success\": \" Task saved.\"}");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Failed to save Task.\"}");
        }
    }
}