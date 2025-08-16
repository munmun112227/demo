package rota.roster.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.sql.Timestamp;
import java.util.Objects;

@Embeddable
public class RosterId implements java.io.Serializable {
    @Column(name = "emp_no", nullable = false)
    private Integer employeeNo;

    @Column(name = "date", nullable = false)
    private Timestamp date;

    public RosterId(){}

    public RosterId(Integer employeeNo, Timestamp date) {
        this.employeeNo = employeeNo;
        this.date = date;
    }

    public Integer getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(Integer employeeNo) {
        this.employeeNo = employeeNo;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RosterId rosterId = (RosterId) o;
        return Objects.equals(employeeNo, rosterId.employeeNo) && Objects.equals(date, rosterId.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNo, date);
    }
}
