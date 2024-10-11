package com.example.UML.parkingLot;


import java.util.ArrayList;
import java.util.List;

public class SMS implements Channel{
    public static SMS sms = null;

    private List<Vehicle> vehicleList = new ArrayList<>();
    @Override
    public void addObserver(Vehicle v){
        vehicleList.add(v);
    }
    @Override
    public void removeObserver(Vehicle v){
        vehicleList.add(v);
    }
    @Override
    public List<Vehicle> getVehicleList(){
        return vehicleList;
    }

    @Override
    public void notifyObserver(){
        for(Vehicle v1:vehicleList){
            v1.updateSMS();
        }
    }

    public void Upload(){

    }
    public static Channel getInstance(){
        if(sms==null){
            sms = new SMS();
        }
        return sms;
    }
}
