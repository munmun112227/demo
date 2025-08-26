package rota.task.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public TaskVO getTaskById(Integer taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }

    public TaskVO saveTask(TaskVO taskVO) {
        return taskRepository.save(taskVO);
    }

    public List<TaskVO> getAllTasks() {
        return taskRepository.findAll();
    }

    public void deleteTaskById(Integer taskId) {
        taskRepository.deleteById(taskId);
    }
}
