package rota.competence.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetenceService {
    @Autowired
    private CompetenceRepository competenceRepository;

    public CompetenceVO getCompetenceById(Integer competenceId) {
        return competenceRepository.findById(competenceId).orElse(null);
    }

    public CompetenceVO saveCompetence(CompetenceVO competenceVO) {
        return competenceRepository.save(competenceVO);
    }
}
