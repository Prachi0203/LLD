package com.example.UML.parkingLot;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;


public class TwoWheelerVehicle extends Vehicle {
    private Ticket ticket;

    TwoWheelerVehicle(String vehicleType, String vehicleNo, String mobileNo, String ownerName,ParkingLot parkingLot,String channelType,Integer timeInDays) {
        super(vehicleType, vehicleNo, mobileNo, ownerName,parkingLot,channelType,timeInDays);
        this.ticket = new Ticket();
    }
    public TwoWheelerVehicle getTwoWheelerVehicle(){
        return this;
    }


    public Ticket getTicket(){
        this.ticket = ticket.getTicket(this.type);
        return this.ticket;
    }

}
