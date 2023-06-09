package com.mdbytes.aop.demo.example.business;

import com.mdbytes.aop.demo.example.data.DataService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {

    private DataService1 dataService1;

    @Autowired
    public BusinessService1(DataService1 dataService1) {
        this.dataService1 = dataService1;

    }

    public int calculateMax() throws InterruptedException {
        int[] data = dataService1.retrieveData();
        Thread.sleep(300);
        return Arrays.stream(data).max().orElse(0);
    }
}
