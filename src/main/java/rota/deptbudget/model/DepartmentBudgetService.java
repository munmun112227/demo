package rota.deptbudget.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentBudgetService {
    @Autowired
    private DepartmentBudgetRepository departmentBudgetRepository;

    public DepartmentBudgetVO getDepartmentBudgetById(Integer departmentId) {
        return departmentBudgetRepository.findById(departmentId).orElse(null);
    }

    public DepartmentBudgetVO saveDepartmentBudget(DepartmentBudgetVO departmentBudgetVO) {
        return departmentBudgetRepository.save(departmentBudgetVO);
    }
}
