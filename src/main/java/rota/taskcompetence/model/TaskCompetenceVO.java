package rota.taskcompetence.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "task_competence")
public class TaskCompetenceVO {
    @EmbeddedId
    private TaskCompetenceId id;

    public TaskCompetenceVO(){}

    public TaskCompetenceVO(TaskCompetenceId id) {
        this.id = id;
    }

    public TaskCompetenceId getId() {
        return id;
    }
    public void setId(TaskCompetenceId id) {}
}
