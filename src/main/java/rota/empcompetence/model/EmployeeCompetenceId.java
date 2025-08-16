package rota.empcompetence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class EmployeeCompetenceId implements java.io.Serializable {
    @Column(name = "emp_no", nullable = false)
    private Integer employeeNo;

    @Column(name = "comp_no", nullable = false)
    private Integer competenceNo;

    public EmployeeCompetenceId(){}

    public EmployeeCompetenceId(Integer employeeNo, Integer competenceNo) {
        this.employeeNo = employeeNo;
        this.competenceNo = competenceNo;
    }

    public Integer getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(Integer employeeNo) {
        this.employeeNo = employeeNo;
    }

    public Integer getCompetenceNo() {
        return competenceNo;
    }

    public void setCompetenceNo(Integer competenceNo) {
        this.competenceNo = competenceNo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeCompetenceId that = (EmployeeCompetenceId) o;
        return Objects.equals(employeeNo, that.employeeNo) && Objects.equals(competenceNo, that.competenceNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNo, competenceNo);
    }
}
