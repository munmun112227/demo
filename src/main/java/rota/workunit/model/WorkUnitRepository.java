package rota.workunit.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkUnitRepository extends JpaRepository<WorkUnitVO, Integer> {
}
