package rota.offdays.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "off_days")
public class OffDaysVO {
    @EmbeddedId
    private OffDaysId id;

    @Column(name = "off_days", nullable = false)
    private Integer offDays;

    public OffDaysVO(){}

    public OffDaysVO(OffDaysId id, Integer offDays) {
        this.id = id;
        this.offDays = offDays;
    }

    public OffDaysId getId() {
        return id;
    }

    public void setId(OffDaysId id) {
        this.id = id;
    }

    public Integer getOffDays() {
        return offDays;
    }

    public void setOffDays(Integer offDays) {
        this.offDays = offDays;
    }
}
