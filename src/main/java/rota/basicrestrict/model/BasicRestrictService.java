package rota.basicrestrict.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicRestrictService {
    @Autowired
    private BasicRestrictRepository bascRestrictRepository;

    public BasicRestrictVO getBasicRestrictById(Integer basicRestrictId) {
        return bascRestrictRepository.findById(basicRestrictId).orElse(null);
    }

    public BasicRestrictVO saveBasicRestrict(BasicRestrictVO basicRestrictVO) {
        return bascRestrictRepository.save(basicRestrictVO);
    }

    public List<BasicRestrictVO> getAllBasicRestricts() {
        return bascRestrictRepository.findAll();
    }
}
