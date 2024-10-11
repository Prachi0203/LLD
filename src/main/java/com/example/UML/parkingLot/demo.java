package com.example.UML.parkingLot;

import java.time.LocalTime;

public class demo {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot("Prachi", "Vipul plaza", LocalTime.of(9, 0, 0),
                LocalTime.of(23, 0, 0));
        Vehicle sapan = new TwoWheelerVehicle("TWO_WHEELER", "HR101", "8178972397", "Sapan",parkingLot,"SMS",1);
        Vehicle aayush = new TwoWheelerVehicle("TWO_WHEELER", "HR101", "8178972397", "aayush",parkingLot,"EMAIL",1);

        Ticket my_ticket = sapan.getTicket();
        Ticket aayush_ticket = aayush.getTicket();
        ChannelFactory channelFactory = new ChannelFactory();
        Channel sms_channel  = channelFactory.getChannel("SMS");
        Channel email_channel = channelFactory.getChannel("EMAIL");
        email_channel.notifyObserver();
        sms_channel.notifyObserver();
    }

}


