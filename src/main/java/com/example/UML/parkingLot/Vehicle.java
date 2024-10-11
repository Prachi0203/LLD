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
     Integer timeInDays;
     Channel channel;
     ChannelFactory channelFactory = new ChannelFactory();
     Vehicle(String vehicleType,String vehicleNo,String mobileNo,String ownerName,ParkingLot parkingLot,String channelType,Integer timeInDays){
        this.vehicleNo = vehicleNo;
        this.type = vehicleType;
        this.ownerName = ownerName;
        this.mobileNo = mobileNo;
        this.parkingLot = parkingLot;
        this.entryDateTime = setEntryTime();
         this.timeInDays = timeInDays;
        this.channel = setChannel(channelType);


     }
     public Channel setChannel(String channelType){
         try {
             if (channelType == null) {
                 return null;
             }
             Channel channel = channelFactory.getChannel(channelType);
             channel.addObserver(this);
             return channel;
         }catch (Exception e){
             System.out.println("Couldn't add as a notifier");
         }
         return null;
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
    public void updateSMS(){
         LocalDateTime currentDay = LocalDateTime.now();
         LocalDateTime entryTime = this.entryDateTime;
         int parkedDate = entryTime.getDayOfMonth();
         int todayDate = currentDay.getDayOfMonth();
         int leftDays = todayDate-parkedDate;
         if(leftDays>=timeInDays){
             System.out.println(this.ownerName+"'s parking is expired by "+String.valueOf(leftDays-timeInDays));
             System.out.println("Msg sent by SMS!");
         }else{
             System.out.println(this.ownerName+"'s parking will be expiring in "+String.valueOf(timeInDays-leftDays));
             System.out.println("Msg sent by SMS!");
         }
    }
    public void updateEmail(){
        LocalDateTime currentDay = LocalDateTime.now();
        LocalDateTime entryTime = this.entryDateTime;
        int parkedDate = entryTime.getDayOfMonth();
        int todayDate = currentDay.getDayOfMonth();
        int leftDays = todayDate-parkedDate;
        if(leftDays>=timeInDays){
            System.out.println(this.ownerName+"'s parking is expired by "+String.valueOf(leftDays-timeInDays));
            System.out.println("Msg sent by Email!");
        }else{
            System.out.println(this.ownerName+"'s parking will be expiring in "+String.valueOf(timeInDays-leftDays));
            System.out.println("Msg sent by Email!");
        }

    }
    public abstract Ticket getTicket();

}
