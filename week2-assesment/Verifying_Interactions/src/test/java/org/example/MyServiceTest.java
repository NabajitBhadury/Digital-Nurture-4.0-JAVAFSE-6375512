package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyServiceTest {
    private ExternalApi mockApi;
    private MyService service;

    @BeforeEach
    void setUp() {
        // Create mock using the traditional way
        mockApi = mock(ExternalApi.class);
        service = new MyService(mockApi);
    }

    @Test
    public void testExternalApi() {
        // Arrange
        when(mockApi.getData()).thenReturn("Mock Data");
        
        // Act
        String result = service.fetchData();
        
        // Assert
        assertEquals("Mock Data", result);
    }

    @Test
    public void testVerifyInteraction() {
        // Act
        service.fetchData();
        
        // Assert - verify the interaction
        verify(mockApi).getData();
    }
} 