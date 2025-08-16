package rota.employee.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeVO getEmployeeById(Integer employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    public EmployeeVO saveEmployee(EmployeeVO employeeVO) {
        return employeeRepository.save(employeeVO);
    }

    public Iterable<EmployeeVO> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
