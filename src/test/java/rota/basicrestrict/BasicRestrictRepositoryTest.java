package rota.basicrestrict;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import rota.basicrestrict.model.BasicRestrictRepository;
import rota.basicrestrict.model.BasicRestrictVO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@EntityScan("rota")
public class BasicRestrictRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BasicRestrictRepository basicRestrictRepository;

    @Test
    public void testBasicRestrictRepository(){
        // 1. 準備 (Arrange)                                                                                                 │
        // 建立一個新的 BasicRestrictVO 物件並設定其屬性
        BasicRestrictVO data = new BasicRestrictVO();
        data.setMaxWorkingHourDaily(5);
        data.setMaxWorkingHourWeekly(25);
        // 使用 TestEntityManager 將實體存入記憶體資料庫                                                                     │
        // 這能確保它獲得一個 ID 並準備好被查詢
        entityManager.persistAndFlush(data);

        // 2. 執行 (Act)
        // 呼叫我們要測試的自訂 repository 方法
        BasicRestrictVO result = basicRestrictRepository.getBasicRestrictByMaxWorkingHourWeekly(25);

        // 3. 驗證 (Assert)                                                                                                  │
        // 檢查結果不是 null，並且其屬性與我們儲存的相符
        assertNotNull(result);
        assertEquals(5, result.getMaxWorkingHourDaily());
        assertEquals(25, result.getMaxWorkingHourWeekly());
    }
}
