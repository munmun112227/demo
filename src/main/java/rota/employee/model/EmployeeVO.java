package rota.employee.model;

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import java.util.Map;

@Entity
@Table(name = "employee")
public class EmployeeVO {
    @Id
    @Column(name = "emp_no", nullable = false)
    private Integer id;

    @Column(name = "wu_no", nullable = false)
    private Integer workUnit;

    @Column(name = "rank", nullable = false)
    private String rank;

    @Column(name = "min_wh", nullable = false)
    private Integer minWorkHours;

    @Column(name = "max_wh", nullable = false)
    private Integer maxWorkHours;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "avai_days")
    private Map<Integer, Integer> availableDays;

    @Column(name = "emp_sta", nullable = false)
    private Integer status;

    @Column(name = "emp_name", nullable = false)
    private String employeeName;

    public EmployeeVO(){}

    public EmployeeVO(Integer id, Integer workUnit, String rank, Integer minWorkHours, Integer maxWorkHours, Map<Integer, Integer> availableDays, Integer status, String employeeName) {
        this.id = id;
        this.workUnit = workUnit;
        this.rank = rank;
        this.minWorkHours = minWorkHours;
        this.maxWorkHours = maxWorkHours;
        this.availableDays = availableDays;
        this.status = status;
        this.employeeName = employeeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(Integer workUnit) {
        this.workUnit = workUnit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Integer getMinWorkHours() {
        return minWorkHours;
    }

    public void setMinWorkHours(Integer minWorkHours) {
        this.minWorkHours = minWorkHours;
    }

    public Integer getMaxWorkHours() {
        return maxWorkHours;
    }

    public void setMaxWorkHours(Integer maxWorkHours) {
        this.maxWorkHours = maxWorkHours;
    }

    public Map<Integer, Integer> getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(Map<Integer, Integer> availableDays) {
        this.availableDays = availableDays;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
