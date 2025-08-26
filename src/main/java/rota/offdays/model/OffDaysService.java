package rota.offdays.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffDaysService {
    @Autowired
    private OffDaysRepository offDaysRepository;

    public OffDaysVO getOffDaysById(Integer offDaysId) {
        return offDaysRepository.findById(offDaysId).orElse(null);
    }

    public OffDaysVO saveOffDays(OffDaysVO offDaysVO) {
        return offDaysRepository.save(offDaysVO);
    }

    public List<OffDaysVO> getAllOffDays() {
        return offDaysRepository.findAll();
    }
}
