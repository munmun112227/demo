package rota.staffing.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffingService {
    @Autowired
    private StaffingRepository staffingRepository;

    public StaffingVO getStaffingById(Integer staffingId) {
        return staffingRepository.findById(staffingId).orElse(null);
    }

    public StaffingVO saveStaffing(StaffingVO staffingVO) {
        return staffingRepository.save(staffingVO);
    }

    public Iterable<StaffingVO> getAllStaffings() {
        return staffingRepository.findAll();
    }
}
