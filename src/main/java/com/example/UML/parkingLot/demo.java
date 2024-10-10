package com.example.UML.parkingLot;

import java.time.LocalTime;

public class demo {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot("Prachi", "Vipul plaza", LocalTime.of(9, 0, 0),
                LocalTime.of(23, 0, 0));
        Ticket ticket = new Ticket();

        Vehicle twoWheelerVehicle = new TwoWheelerVehicle("TWO_WHEELER", "HR101", "8178972397", "Sapan", ticket,parkingLot);
        Ticket my_ticket = twoWheelerVehicle.getTicket();
//        TwoWheelerVehicle my_vehicle = twoWheelerVehicle.getTwoWheelerVehicle();
        twoWheelerVehicle.exit();
    }

}


