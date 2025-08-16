package rota.deptbudget.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "department_budget")
public class DepartmentBudgetVO {
    @EmbeddedId
    private DepartmentBudgetId id;

    @Column(name = "budget", nullable = false)
    private Double budget;

    public DepartmentBudgetVO(){}

    public DepartmentBudgetVO(DepartmentBudgetId id, Double budget) {
        this.id = id;
        this.budget = budget;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public DepartmentBudgetId getId() {
        return id;
    }

    public void setId(DepartmentBudgetId id) {
        this.id = id;
    }
}
