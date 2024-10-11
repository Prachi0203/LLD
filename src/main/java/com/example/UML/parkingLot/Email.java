package com.example.UML.parkingLot;

import java.util.ArrayList;
import java.util.List;

public class Email implements Channel {
    private List<Vehicle> vehicleList = new ArrayList<>();
    public static Email email = null;
    @Override
    public void addObserver(Vehicle v){
        vehicleList.add(v);
    }
    @Override
    public void removeObserver(Vehicle v){
        vehicleList.remove(v);
    }
    @Override
    public void notifyObserver(){
        for(Vehicle v1:vehicleList){
            v1.updateEmail();
        }
    }

    public static Channel getInstance(){
        if(email==null){
            email = new Email();
        }
        return email;
    }
    public List<Vehicle> getVehicleList(){
        return vehicleList;
    }


}
