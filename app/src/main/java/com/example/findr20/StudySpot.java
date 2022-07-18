package com.example.findr20;

public class StudySpot extends Location {

    boolean claustrophobic;
    boolean vendingSupplies;
    boolean[] equipment = new boolean[4]; //computer, projector, whiteboard, printer

    public StudySpot(String name, boolean jCardReq, boolean foodAllowed, boolean foodSold,
                     int hygiene, int seating, int openTime, int closingTime, int privacy,
                     boolean vendingFood, boolean rsvp, int volume, boolean claustrophobic,
                     boolean vendingSupplies, boolean[] equipment, int imageId){

        super(name, jCardReq, foodAllowed, foodSold, hygiene, seating, openTime, closingTime,
                privacy, vendingFood,rsvp,volume, imageId);
        this.setClaustrophobic(claustrophobic);
        this.setVendingSupplies(vendingSupplies);
        this.setEquipment(equipment);

    }


    public boolean isClaustrophobic() {
        return claustrophobic;
    }

    public void setClaustrophobic(boolean claustrophobic) {
        this.claustrophobic = claustrophobic;
    }

    public boolean isVendingSupplies() {
        return vendingSupplies;
    }

    public void setVendingSupplies(boolean vendingSupplies) {
        this.vendingSupplies = vendingSupplies;
    }

    public boolean[] getEquipment() {
        return equipment;
    }

    public void setEquipment(boolean[] equipment) {
        this.equipment = equipment;
    }

}

