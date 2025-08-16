package rota.department.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentVO getDepartmentById(Integer departmentId) {
        return departmentRepository.findById(departmentId).orElse(null);
    }

    public DepartmentVO saveDepartment(DepartmentVO departmentVO) {
        return departmentRepository.save(departmentVO);
    }
}
