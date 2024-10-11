package com.example.UML.parkingLot;

public class ChannelFactory {

    public Channel getChannel(String type){
        switch (type){
            case "SMS":
                return SMS.getInstance();
            case "EMAIL":
                return Email.getInstance();
        }
        return null;
    }
}
