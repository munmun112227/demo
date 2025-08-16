package rota.workunit.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkUnitService {
    @Autowired
    private WorkUnitRepository workUnitRepository;

    public WorkUnitVO getWorkUnitById(Integer workUnitId) {
        return workUnitRepository.findById(workUnitId).orElse(null);
    }

    public WorkUnitVO saveWorkUnit(WorkUnitVO workUnitVO) {
        return workUnitRepository.save(workUnitVO);
    }

    public Iterable<WorkUnitVO> getAllWorkUnits() {
        return workUnitRepository.findAll();
    }
}
