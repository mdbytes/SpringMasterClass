package com.mdbytes.mokito.demo.business;

public class SomeBusinessImpl {

    private DataService dataService;

    public SomeBusinessImpl(DataService dataService) {
        this.dataService = dataService;
    }

    public int findTheGreatestFromAllData() {
        int[] data = dataService.retrieveAllData();
        int greatestValue = Integer.MIN_VALUE;
        for(int value: data) {
            if(value > greatestValue){
                greatestValue = value;
            }
        }
        return greatestValue;
    }

}

interface DataService {
    int[] retrieveAllData();
}
