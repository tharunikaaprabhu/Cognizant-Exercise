
import com.example.external.ExternalApi;
import com.example.vikram.MyService;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testFetchDataCallsGetDataWithCorrectArguments() {
        ExternalApi mockApi = mock(ExternalApi.class);

        MyService service = new MyService(mockApi);

        service.fetchData();

        verify(mockApi, times(1)).getData("User1", 3);
    }
}
