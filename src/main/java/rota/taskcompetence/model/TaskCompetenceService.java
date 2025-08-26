package rota.taskcompetence.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskCompetenceService {
    @Autowired
    private TaskCompetenceRepository taskCompetenceRepository;

    public TaskCompetenceVO getTaskCompetenceById(TaskCompetenceId id) {
        return taskCompetenceRepository.findById(id).orElse(null);
    }

    public TaskCompetenceVO saveTaskCompetence(TaskCompetenceVO taskCompetenceVO) {
        return taskCompetenceRepository.save(taskCompetenceVO);
    }

    public void deleteTaskCompetenceById(TaskCompetenceId id) {
        taskCompetenceRepository.deleteById(id);
    }

    public List<TaskCompetenceVO> getAllTaskCompetences() {
        return taskCompetenceRepository.findAll();
    }
}
