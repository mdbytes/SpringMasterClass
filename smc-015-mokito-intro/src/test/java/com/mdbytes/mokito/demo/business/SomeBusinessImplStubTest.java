package com.mdbytes.mokito.demo.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessImplStubTest {

    DataServiceStub stub = new DataServiceStub();

    @Test
    void testFindTheGreatestFromAllData_BasicScenario() {
        SomeBusinessImpl impl = new SomeBusinessImpl(stub);

        int result = impl.findTheGreatestFromAllData();

        assertEquals(result,25);
    }

    @Test
    void testFindTheGreatestFromAllData_WithOneValue() {
        DataService stub2 = new DataServiceStub2();
        SomeBusinessImpl impl = new SomeBusinessImpl(stub2);

        int result = impl.findTheGreatestFromAllData();

        assertEquals(result,45);
    }
}

class DataServiceStub implements DataService {
    @Override
    public int[] retrieveAllData() {
        return new int[] {25,15,5};
    }
}

class DataServiceStub2 implements DataService {
    @Override
    public int[] retrieveAllData() {
        return new int[] {45};
    }
}