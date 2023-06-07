package com.mdbytes.mokito.demo.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {

    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl businessImpl;

    @Test
    void testFindTheGreatestFromAllData_BasicScenario() {

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25,15,5});

        int result = businessImpl.findTheGreatestFromAllData();

        assertEquals(result,25);
    }

    @Test
    void testFindTheGreatestFromAllData_OneValue() {

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {45});
        int result = businessImpl.findTheGreatestFromAllData();

        assertEquals(result,45);
    }

    @Test
    void testFindTheGreatestFromAllData_EmptyArray() {

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        int result = businessImpl.findTheGreatestFromAllData();

        assertEquals(result,Integer.MIN_VALUE);
    }

}
