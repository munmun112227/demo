package rota.department.model;

import jakarta.persistence.*;

@Entity
@Table(name = "department")
public class DepartmentVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_no")
    private Integer id;

    @Column(name = "dept_name", nullable = false)
    private String name;

    @Column(name = "dept_head", nullable = false)
    private Integer departmentHead;

    public DepartmentVO(){}

    public DepartmentVO(String name, Integer departmentHead) {
        this.name = name;
        this.departmentHead = departmentHead;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(Integer departmentHead) {
        this.departmentHead = departmentHead;
    }
}
