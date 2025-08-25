package rota.basicrestrict;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import rota.basicrestrict.controller.BasicRestrictController;
import rota.basicrestrict.model.BasicRestrictService;
import rota.basicrestrict.model.BasicRestrictVO;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = BasicRestrictController.class,
            excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class BasicRestrictControllerTest {
    @Autowired
    private MockMvc mockMvc;

        @MockBean
    private BasicRestrictService basicRestrictService;

    @MockBean
    private rota.configulation.jwt.JwtUtil jwtUtil;

    @MockBean
    private rota.users.model.CustomUserDetailsService customUserDetailsService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllBasicRestrictTest() throws Exception {
        BasicRestrictVO basicRestrictVO = new BasicRestrictVO();
        basicRestrictVO.setId(1);
        basicRestrictVO.setMaxWorkingHourDaily(10);
        basicRestrictVO.setMaxWorkingHourWeekly(1);
        List<BasicRestrictVO> list = Collections.singletonList(basicRestrictVO);

        when(basicRestrictService.getAllBasicRestricts()).thenReturn(list);

        mockMvc.perform(get("/basicRestricts/getBasicRestricts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].maxWorkingHourDaily").value(10))
                .andExpect(jsonPath("$[0].maxWorkingHourWeekly").value(1));
    }

    @Test
    void createBasicRestrictTest() throws Exception {
        BasicRestrictVO toSaveBasicRestrictVO = new BasicRestrictVO();
        toSaveBasicRestrictVO.setId(1);
        toSaveBasicRestrictVO.setMaxWorkingHourDaily(10);
        toSaveBasicRestrictVO.setMaxWorkingHourWeekly(1);
        BasicRestrictVO savedBasicRestrictVO = new BasicRestrictVO();
        savedBasicRestrictVO.setId(1);
        savedBasicRestrictVO.setMaxWorkingHourDaily(10);
        savedBasicRestrictVO.setMaxWorkingHourWeekly(1);

        when(basicRestrictService.saveBasicRestrict(any(BasicRestrictVO.class))).thenReturn(savedBasicRestrictVO);

        mockMvc.perform(post("/basicRestricts/saveBasicRestrict")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(toSaveBasicRestrictVO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.maxWorkingHourDaily").value(10))
                .andExpect(jsonPath("$.maxWorkingHourWeekly").value(1));
    }

    @Test
    void updateBasicRestrictTest() throws Exception {
        BasicRestrictVO updatingBasicRestrictVO = new BasicRestrictVO();
        updatingBasicRestrictVO.setId(1);
        updatingBasicRestrictVO.setMaxWorkingHourDaily(20);
        updatingBasicRestrictVO.setMaxWorkingHourWeekly(2);

        BasicRestrictVO updatedBasicRestrictVO = new BasicRestrictVO();
        updatedBasicRestrictVO.setId(1);
        updatedBasicRestrictVO.setMaxWorkingHourDaily(20);
        updatedBasicRestrictVO.setMaxWorkingHourWeekly(2);

        when(basicRestrictService.saveBasicRestrict(any(BasicRestrictVO.class))).thenReturn(updatedBasicRestrictVO);

        mockMvc.perform(post("/basicRestricts/saveBasicRestrict")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatingBasicRestrictVO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.maxWorkingHourDaily").value(20))
                .andExpect(jsonPath("$.maxWorkingHourWeekly").value(2));
    }

}
