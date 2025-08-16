package rota.workunit.model;

import jakarta.persistence.*;

@Entity
@Table(name = "work_unit")
public class WorkUnitVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wu_no")
    private Integer workUnitId;

    @Column(name = "wu_name", nullable = false)
    private String workUnitName;

    @Column(name = "dept_no", nullable = false)
    private Integer department;

    @Column(name = "wu_head", nullable = false)
    private Integer workUnitHead;

    @Column(name = "wu_sta", insertable = false)
    private Integer status;

    public WorkUnitVO(){}

    public WorkUnitVO(String workUnitName, Integer department, Integer workUnitHead) {
        this.workUnitName = workUnitName;
        this.department = department;
        this.workUnitHead = workUnitHead;
    }

    public Integer getWorkUnitId() {
        return workUnitId;
    }

    public void setWorkUnitId(Integer workUnitId) {
        this.workUnitId = workUnitId;
    }

    public String getWorkUnitName() {
        return workUnitName;
    }

    public void setWorkUnitName(String workUnitName) {
        this.workUnitName = workUnitName;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Integer getWorkUnitHead() {
        return workUnitHead;
    }

    public void setWorkUnitHead(Integer workUnitHead) {
        this.workUnitHead = workUnitHead;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
