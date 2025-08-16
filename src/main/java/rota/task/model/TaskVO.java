package rota.task.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "task")
public class TaskVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_no")
    private Integer taskNo;

    @Column(name = "task_name", nullable = false)
    private String taskName;

    @Column(name = "wu_no", nullable = false)
    private Integer workUnit;

    @Column(name = "task_freq", nullable = false)
    private Integer taskFrequency;

    @Column(name = "head_count", nullable = false)
    private Integer headCount;

    @Column(name = "work_hours", nullable = false)
    private Integer workHours;

    @Column(name = "edit_time", nullable = false)
    private Timestamp editTime;

    public TaskVO(){}

    public TaskVO(String taskName, Integer workUnit, Integer taskFrequency, Integer headCount, Integer workHours, Timestamp editTime) {
        this.taskName = taskName;
        this.workUnit = workUnit;
        this.taskFrequency = taskFrequency;
        this.headCount = headCount;
        this.workHours = workHours;
        this.editTime = editTime;
    }

    public Integer getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(Integer taskNo) {
        this.taskNo = taskNo;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(Integer workUnit) {
        this.workUnit = workUnit;
    }

    public Integer getTaskFrequency() {
        return taskFrequency;
    }

    public void setTaskFrequency(Integer taskFrequency) {
        this.taskFrequency = taskFrequency;
    }

    public Integer getHeadCount() {
        return headCount;
    }

    public void setHeadCount(Integer headCount) {
        this.headCount = headCount;
    }

    public Integer getWorkHours() {
        return workHours;
    }

    public void setWorkHours(Integer workHours) {
        this.workHours = workHours;
    }

    public Timestamp getEditTime() {
        return editTime;
    }

    public void setEditTime(Timestamp editTime) {
        this.editTime = editTime;
    }
}
