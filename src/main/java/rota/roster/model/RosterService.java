package rota.roster.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RosterService {
    @Autowired
    private RosterRepository rosterRepository;

    public RosterVO getRosterById(Integer rosterId) {
        return rosterRepository.findById(rosterId).orElse(null);
    }

    public RosterVO saveRoster(RosterVO rosterVO) {
        return rosterRepository.save(rosterVO);
    }

    public List<RosterVO> getAllRosters() {
        return rosterRepository.findAll();
    }
}
