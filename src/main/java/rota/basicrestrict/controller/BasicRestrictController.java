package rota.basicrestrict.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rota.basicrestrict.model.BasicRestrictService;
import rota.basicrestrict.model.BasicRestrictVO;

import java.util.List;

@RestController
@RequestMapping("/basicRestricts")
public class BasicRestrictController {
    @Autowired
    private BasicRestrictService basicRestrictService;

    @GetMapping("/getBasicRestricts")
    public List<BasicRestrictVO> getBasicRestricts() {
        List<BasicRestrictVO> list = basicRestrictService.getAllBasicRestricts();
        return list;
    }

    @PostMapping("/saveBasicRestrict")
    public BasicRestrictVO saveBasicRestrict(@RequestBody BasicRestrictVO basicRestrictVO) {
        BasicRestrictVO savedBasicRestrictVO = basicRestrictService.saveBasicRestrict(basicRestrictVO);
        return savedBasicRestrictVO;
    }
}
