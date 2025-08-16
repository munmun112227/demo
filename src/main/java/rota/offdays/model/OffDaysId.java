package rota.offdays.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class OffDaysId implements java.io.Serializable {
    @Column(name = "periods", nullable = false)
    private Integer period;

    @Column(name = "emp_type", nullable = false)
    private Integer employeeType;

    public OffDaysId(){}

    public OffDaysId(Integer period, Integer employeeType) {
        this.period = period;
        this.employeeType = employeeType;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(Integer employeeType) {
        this.employeeType = employeeType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OffDaysId offDaysId = (OffDaysId) o;
        return Objects.equals(period, offDaysId.period) && Objects.equals(employeeType, offDaysId.employeeType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(period, employeeType);
    }
}
