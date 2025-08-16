package rota.empcompetence.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCompetenceService {
    @Autowired
    private EmployeeCompetenceRepository employeeCompetenceRepository;

    public EmployeeCompetenceVO getEmployeeCompetenceById(EmployeeCompetenceId id) {
        return employeeCompetenceRepository.findById(id).orElse(null);
    }

    public EmployeeCompetenceVO saveEmployeeCompetence(EmployeeCompetenceVO employeeCompetenceVO) {
        return employeeCompetenceRepository.save(employeeCompetenceVO);
    }

    public Iterable<EmployeeCompetenceVO> getAllEmployeeCompetences() {
        return employeeCompetenceRepository.findAll();
    }
}
