package rota.basicrestrict;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import rota.basicrestrict.model.BasicRestrictRepository;
import rota.basicrestrict.model.BasicRestrictService;
import rota.basicrestrict.model.BasicRestrictVO;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;


//啟用 Mockito 框架。
@ExtendWith(MockitoExtension.class)
public class BasicRestrictServiceTest {
    //模擬BasicRestrictRepository的物件
    @Mock
    private BasicRestrictRepository basicRestrictRepository;

    //建立一個 Service實例，並將上面的模擬物件注入進去
    @InjectMocks
    private BasicRestrictService basicRestrictService;

    @Test
    void  TestGetAllBasicRestricts() {
        // 1. 準備 (Arrange)
        // 定義當 repository.findAll() 被呼叫時，應該要回傳什麼
        BasicRestrictVO basicRestrictVO = new BasicRestrictVO();
        basicRestrictVO.setId(1);
        List<BasicRestrictVO> mockList = Collections.singletonList(basicRestrictVO);

        //這是 Mockito 的核心語法。我們在這裡設定了一個「假想情境」：當 repository.findAll()
        //這個方法被呼叫時，「不要」真的去查資料庫，而是直接回傳我們預先準備好的 mockList。
        when(basicRestrictRepository.findAll()).thenReturn(mockList);

        // 2. 執行 (Act)
        // 實際呼叫我們要測試的方法
        List<BasicRestrictVO> result = basicRestrictService.getAllBasicRestricts();

        // 3. 驗證 (Assert)
        // 驗證結果是否如我們預期assertEquals(預期的結果, 實際的結果)
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).getId());
    }

    @Test
    void testGetBasicRestrictByIdExists() {
        BasicRestrictVO basicRestrictVO = new BasicRestrictVO();
        Integer id = 1;
        basicRestrictVO.setId(id);

        when(basicRestrictRepository.findById(id)).thenReturn(Optional.of(basicRestrictVO));

        BasicRestrictVO result = basicRestrictService.getBasicRestrictById(id);

        assertEquals(1, result.getId());
    }

    @Test
    void testGetBasicRestrictByIdNotExists() {
        Integer id = 999;

        when(basicRestrictRepository.findById(id)).thenReturn(Optional.empty());

        BasicRestrictVO result = basicRestrictService.getBasicRestrictById(id);

        assertEquals(null, result);
    }

    @Test
    void testSaveBasicRestrict() {
        BasicRestrictVO toSaveBasicRestrictVO = new BasicRestrictVO(10, 1);
        BasicRestrictVO savedBasicRestrictVO = new BasicRestrictVO();
        savedBasicRestrictVO.setId(1);
        savedBasicRestrictVO.setMaxWorkingHourWeekly(1);
        savedBasicRestrictVO.setMaxWorkingHourDaily(10);

        when(basicRestrictRepository.save(toSaveBasicRestrictVO)).thenReturn(savedBasicRestrictVO);

        BasicRestrictVO result = basicRestrictService.saveBasicRestrict(toSaveBasicRestrictVO);

        assertNotEquals(null, result);
        assertEquals(1, result.getId());
        assertEquals(1, savedBasicRestrictVO.getMaxWorkingHourWeekly());
        assertEquals(10, result.getMaxWorkingHourDaily());

        //`any(BasicRestrictVO.class)`: 這是一個 Mockito 的「參數匹配器 (Argument Matcher)」。它的意思是「任何 BasicRestrictVO 型別的物件」。使用它比直接傳入
        // objectToSave 更常用也更靈活，因為它不要求物件的 equals 方法被正確實作。它讓我們專注於「save 方法被呼叫了」這件事，而不是「傳入的物件是否跟 objectToSave
        // 完全相等」。
        //`verify(repository, times(1)).save(...)`: 這是 Mockito 的「驗證行為」功能。assertEquals 是在驗證「結果的值」，而 verify
        // 是在驗證「某個方法是否被以我們預期的方式呼叫過」。times(1) 明確指出，我們預期 save 方法剛好被呼叫一次。這可以防止一些意外的 bug，例如開發者不小心在
        // service 裡呼叫了兩次 save
        verify(basicRestrictRepository, times(1)).save(any(BasicRestrictVO.class));
    }
}
