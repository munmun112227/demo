package rota.staffing.model;

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import io.micrometer.core.annotation.Counted;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "staffing")
public class StaffingVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staf_no")
    private Integer id;

    @Column(name = "wu_no", nullable = false)
    private Integer workUnit;

    @Column(name = "staf_cat", nullable = false)
    private Integer staffingCategory;

    @Column(name = "weekday", nullable = false)
    private Integer weekDay;

    @Type(ListArrayType.class)
    @Column(name = "comp_no", columnDefinition = "integer[]")
    private Set<Integer> comptences;

    @Column(name = "shift", nullable = false)
    private String shift;

    @Column(name = "edit_time", nullable = false)
    private Timestamp editTime;

    public StaffingVO(){}

    public StaffingVO(Integer workUnit, Integer staffingCategory, Integer weekDay, Set<Integer> comptences, String shift, Timestamp editTime) {
        this.workUnit = workUnit;
        this.staffingCategory = staffingCategory;
        this.weekDay = weekDay;
        this.comptences = comptences;
        this.shift = shift;
        this.editTime = editTime;
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

    public Integer getStaffingCategory() {
        return staffingCategory;
    }

    public void setStaffingCategory(Integer staffingCategory) {
        this.staffingCategory = staffingCategory;
    }

    public Integer getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(Integer weekDay) {
        this.weekDay = weekDay;
    }

    public Set<Integer> getComptences() {
        return comptences;
    }

    public void setComptences(Set<Integer> comptences) {
        this.comptences = comptences;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public Timestamp getEditTime() {
        return editTime;
    }

    public void setEditTime(Timestamp editTime) {
        this.editTime = editTime;
    }
}
