package com.mdbytes.mokito.demo.list;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {
        @Test
        void testSimpleCase(){
            List listMock = mock(List.class);
            when(listMock.size()).thenReturn(3);

            assertEquals(3,listMock.size());
        }

        @Test
        void testMultipleReturns(){
            List listMock = mock(List.class);
            when(listMock.size()).thenReturn(3).thenReturn(2);

            assertEquals(3,listMock.size());
            assertEquals(2,listMock.size());
            assertEquals(2,listMock.size());
            assertEquals(2,listMock.size());
        }

    @Test
    void testParameters(){
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("Some string");

        assertEquals("Some string",listMock.get(0));
        assertEquals(null,listMock.get(1));

    }

    @Test
    void testGenericParameters(){
        List listMock = mock(List.class);
        when(listMock.get(Mockito.anyInt())).thenReturn("some-other-string");

        assertEquals("some-other-string",listMock.get(0));
        assertEquals("some-other-string",listMock.get(1));
    }
}
