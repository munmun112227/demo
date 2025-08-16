package rota.empcompetence.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_competence")
public class EmployeeCompetenceVO {
    @EmbeddedId
    private EmployeeCompetenceId id;

    public EmployeeCompetenceVO(){}

    public EmployeeCompetenceVO(EmployeeCompetenceId id) {
        this.id = id;
    }

    public EmployeeCompetenceId getId() {
        return id;
    }

    public void setId(EmployeeCompetenceId id) {
        this.id = id;
    }
}
