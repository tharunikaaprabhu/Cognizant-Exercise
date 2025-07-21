package com.vikram;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

	interface ExternalApi {
		String getData();
	}

	static class MyService {
		private final ExternalApi api;

		public MyService(ExternalApi api) {
			this.api = api;
		}

		public String fetchData() {
			String data = api.getData();
			return (data != null) ? data : "No data available";
		}
	}

	@Test
	public void testFetchDataSuccess() {
		ExternalApi mockApi = Mockito.mock(ExternalApi.class);
		when(mockApi.getData()).thenReturn("Mock Data");

		MyService service = new MyService(mockApi);
		String result = service.fetchData();

		assertEquals("Mock Data", result, "Should return mocked data");
		verify(mockApi, times(1)).getData();
	}

	@Test
	public void testFetchDataReturnsNull() {
		ExternalApi mockApi = Mockito.mock(ExternalApi.class);
		when(mockApi.getData()).thenReturn(null);

		MyService service = new MyService(mockApi);
		String result = service.fetchData();

		assertEquals("No data available", result, "Should return default message on null");
		verify(mockApi, times(1)).getData();
	}

	@Test
	public void testFetchDataThrowsException() {
		ExternalApi mockApi = Mockito.mock(ExternalApi.class);
		when(mockApi.getData()).thenThrow(new RuntimeException("API failure"));

		MyService service = new MyService(mockApi);

		RuntimeException exception = assertThrows(RuntimeException.class, service::fetchData);
		assertEquals("API failure", exception.getMessage());
		verify(mockApi, times(1)).getData();
	}
}
