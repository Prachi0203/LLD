package com.example.UML.parkingLot;

import lombok.Data;

import java.time.LocalTime;
@Data
public class ParkingLot {
    private String owner_name;
    private String location;
    private LocalTime opensAt;
    private LocalTime closesAt;
    ParkingLot(String owner_name,String location,LocalTime opensAt,LocalTime closesAt){
        this.owner_name = owner_name;
        this.location = location;
        this.opensAt = opensAt;
        this.closesAt = closesAt;

    }
}

