import com.ipiecoles.java.java240.BitcoinService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class BitcoinServiceIntegrationTest {

    @Autowired
    private BitcoinService bitcoinService;
    @Test
  public void getBitcoinRate() throws IOException {
        {
            //Given
            //When
            Double rate = bitcoinService.getBitcoinRate();
            //Then
            Assertions.assertThat(rate).isNotNull();
        }
    }
}
