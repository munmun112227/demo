package rota.taskcompetence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class TaskCompetenceId implements java.io.Serializable {
    @Column(name = "task_no", nullable = false)
    private int taskId;
    @Column(name = "comp_no", nullable = false)
    private int competenceId;

    public TaskCompetenceId(){}

    public TaskCompetenceId(int taskId, int competenceId) {
        this.taskId = taskId;
        this.competenceId = competenceId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getCompetenceId() {
        return competenceId;
    }

    public void setCompetenceId(int competenceId) {
        this.competenceId = competenceId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TaskCompetenceId that = (TaskCompetenceId) o;
        return taskId == that.taskId && competenceId == that.competenceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, competenceId);
    }
}
