package com.example.UML.parkingLot;

import javax.swing.plaf.PanelUI;
import java.util.List;

public interface Channel {

    public void addObserver(Vehicle v);
    public void removeObserver(Vehicle v);
    public void notifyObserver();
    public List<Vehicle> getVehicleList();
}
