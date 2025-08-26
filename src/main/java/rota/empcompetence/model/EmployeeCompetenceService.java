package rota.empcompetence.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<EmployeeCompetenceVO> getAllEmployeeCompetences() {
        return employeeCompetenceRepository.findAll();
    }
}
