package com.example.UML.parkingLot;

public class Ticket{
    String ticketNo;
    int ticketPrice;
    Ticket(){
        this.ticketNo = null;
        this.ticketPrice = 0;
    }
    Ticket(String ticketNo,int ticketPrice){
        this.ticketPrice = ticketPrice;
        this.ticketNo = ticketNo;
    }
    public Ticket getTicket(String type){
        int ticketPrice = getTicketPrice(type);
        String ticketNo = String.valueOf((int) Math.random());
        Ticket ticket = new Ticket(ticketNo,ticketPrice);
        return ticket;
    }

    public int getTicketPrice(String type){
        switch (type){
            case "TWO_WHEELER":
                return 50;
            case "FOUR_WHEELER_SMALL":
                return 100;
            case "FOUR_WHEELER_GIANT":
                return 200;
        }
        return 50;
    }
}