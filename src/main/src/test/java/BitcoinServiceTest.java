import com.ipiecoles.java.java240.BitcoinService;
import com.ipiecoles.java.java240.WebPageManager;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class BitcoinServiceTest {

    @InjectMocks
    BitcoinService bitcoinService;
    @Mock
    WebPageManager webPageManager;

    @Test
    public void getBitcoinRate() throws IOException {
        //Given
        Mockito.when(webPageManager.getPageContents(null)).thenReturn("{\"EUR\":7308.2}");

        //When
        Double rate = bitcoinService.getBitcoinRate();

        //Then
        Assertions.assertThat(rate).isNotNull();
        Assertions.assertThat(rate).isEqualTo(7308.2);
    }
}
