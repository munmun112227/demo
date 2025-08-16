package rota.competence.model;

import jakarta.persistence.*;

@Entity
@Table(name = "competence")
public class CompetenceVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comp_no")
    private Integer id;

    @Column(name = "wu_no", nullable = false)
    private Integer workUnit;

    @Column(name = "comp_name", nullable = false)
    private String name;

    @Column(name = "comp_desc")
    private String description;

    public CompetenceVO(){}

    public CompetenceVO(Integer workUnit, String name, String description) {
        this.workUnit = workUnit;
        this.name = name;
        this.description = description;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
