package rota.basicrestrict.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BasicRestrictRepository extends JpaRepository<BasicRestrictVO, Integer> {
    @Query(value = "FROM BasicRestrictVO AS b WHERE b.maxWorkingHourWeekly = :maxWorkingHourWeekly")
    public BasicRestrictVO getBasicRestrictByMaxWorkingHourWeekly(Integer maxWorkingHourWeekly);
}
