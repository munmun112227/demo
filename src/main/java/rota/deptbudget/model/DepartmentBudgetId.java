package rota.deptbudget.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class DepartmentBudgetId implements java.io.Serializable{
    @Column(name = "dept_no", nullable = false)
    private Integer departmentNo;

    @Column(name = "periods", nullable = false)
    private Integer period;

    public DepartmentBudgetId(){}

    public DepartmentBudgetId(Integer departmentNo, Integer period) {
        this.departmentNo = departmentNo;
        this.period = period;
    }

    public Integer getDepartmentNo() {
        return departmentNo;
    }

    public void setDepartmentNo(Integer departmentNo) {
        this.departmentNo = departmentNo;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentBudgetId that = (DepartmentBudgetId) o;
        return Objects.equals(departmentNo, that.departmentNo) && Objects.equals(period, that.period);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentNo, period);
    }
}
