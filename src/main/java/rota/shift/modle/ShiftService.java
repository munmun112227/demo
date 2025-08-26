package rota.shift.modle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftService {
    @Autowired
    private ShiftRepository shiftRepository;

    public ShiftVO getShiftByName(String shiftName) {
        return shiftRepository.findById(shiftName).orElse(null);
    }

    public ShiftVO saveShift(ShiftVO shiftVO) {
        return shiftRepository.save(shiftVO);
    }

    public List<ShiftVO> getAllShifts() {
        return shiftRepository.findAll();
    }
}
