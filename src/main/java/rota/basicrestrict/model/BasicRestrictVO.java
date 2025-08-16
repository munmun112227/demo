package rota.basicrestrict.model;

import jakarta.persistence.*;

@Entity
@Table(name = "basc_restrict")
public class BasicRestrictVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "max_wh_daily", nullable = false)
    private Integer maxWorkingHourDaily;

    @Column(name = "max_wh_weekly", nullable = false)
    private Integer maxWorkingHourWeekly;

    public BasicRestrictVO(){}

    public BasicRestrictVO(Integer maxWorkingHourDaily, Integer maxWorkingHourWeekly) {
        this.maxWorkingHourDaily = maxWorkingHourDaily;
        this.maxWorkingHourWeekly = maxWorkingHourWeekly;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaxWorkingHourDaily() {
        return maxWorkingHourDaily;
    }

    public void setMaxWorkingHourDaily(Integer maxWorkingHourDaily) {
        this.maxWorkingHourDaily = maxWorkingHourDaily;
    }

    public Integer getMaxWorkingHourWeekly() {
        return maxWorkingHourWeekly;
    }

    public void setMaxWorkingHourWeekly(Integer maxWorkingHourWeekly) {
        this.maxWorkingHourWeekly = maxWorkingHourWeekly;
    }
}
