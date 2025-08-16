package rota.task.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Iterable<TaskVO> getAllTasks() {
        return taskRepository.findAll();
    }

    public void deleteTaskById(Integer taskId) {
        taskRepository.deleteById(taskId);
    }
}
