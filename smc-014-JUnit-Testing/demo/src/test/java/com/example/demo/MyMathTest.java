package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {
    MyMath m = new MyMath();


    @Test
    void testCalculateSum_123(){
        // Absence of failure is success
        // Test condition or assert

        int result = m.calculateSum(new int[]{1,2,3});
        int expected = 6;

        assertEquals(expected,result);

    }

    @Test
    void testCalculateSum_Empty(){
        // Absence of failure is success
        // Test condition or assert

        int result = m.calculateSum(new int[]{});
        int expected = 0;

        assertEquals(expected,result);

    }





}