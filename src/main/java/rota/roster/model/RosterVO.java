package rota.roster.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "roster")
public class RosterVO {
    @EmbeddedId
    private String id;

    @Column(name = "shift_name", nullable = false)
    private String shiftName;

    public RosterVO(){}

    public RosterVO(String id, String shiftName) {
        this.id = id;
        this.shiftName = shiftName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }
}
