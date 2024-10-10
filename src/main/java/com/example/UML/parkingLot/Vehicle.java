package com.example.UML.parkingLot;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
@Data
public abstract class Vehicle {
    ParkingLot parkingLot;

     String vehicleNo;
     String type;
     String mobileNo;
     String ownerName;
     LocalDateTime entryDateTime;
     LocalDateTime exitDateTime;
     Vehicle(String vehicleType,String vehicleNo,String mobileNo,String ownerName,ParkingLot parkingLot){
        this.vehicleNo = vehicleNo;
        this.type = vehicleType;
        this.ownerName = ownerName;
        this.mobileNo = mobileNo;
        this.parkingLot = parkingLot;
        this.entryDateTime = setEntryTime();


     }
     public LocalDateTime setEntryTime(){
         LocalDateTime dateTime = LocalDateTime.now();
         LocalTime opensAt = parkingLot.getOpensAt();
         LocalTime endsAt = parkingLot.getClosesAt();

         if (opensAt.getHour()<=dateTime.getHour() && endsAt.getHour()>=dateTime.getHour()){
             return LocalDateTime.now();
         }
         else{
            throw new RuntimeException("Parking Lot is Closed!");
         }
     }
    public void exit(){
        LocalDateTime dateTime = LocalDateTime.now();
        LocalTime endsAt = parkingLot.getClosesAt();
        if(dateTime.getHour()<=endsAt.getHour()){
            this.exitDateTime = LocalDateTime.now();

        }else{
            throw new RuntimeException("Parking Lot is closed");
        }
    }

    public abstract Ticket getTicket();

}
