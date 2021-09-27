package com.example.findr20;

import java.util.Objects;

public class Location {

    protected String name;
    protected boolean jCardReq;
    protected boolean foodAllowed;
    protected boolean foodSold;
    protected int hygiene;
    protected int seating;
    protected int openTime;
    protected int closingTime;
    protected int privacy;
    protected boolean vendingFood;
    protected boolean rsvp;
    protected int volume;


    public Location(String name, boolean jCardReq, boolean foodAllowed, boolean foodSold,
                    int hygiene, int seating, int openTime, int closingTime, int privacy,
                    boolean vendingFood, boolean rsvp, int volume) {
        this.setName(name);
        this.setjCardReq(jCardReq);
        this.setFoodAllowed(foodAllowed);
        this.setFoodSold(foodSold);
        this.setHygiene(hygiene);
        this.setSeating(seating);
        this.setOpenTime(openTime);
        this.setClosingTime(closingTime);
        this.setPrivacy(privacy);
        this.setVendingFood(vendingFood);
        this.setRsvp(rsvp);
        this.setVolume(volume);

    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isjCardReq() {
        return jCardReq;
    }

    public void setjCardReq(boolean jCardReq) {
        this.jCardReq = jCardReq;
    }

    public boolean isFoodAllowed() {
        return foodAllowed;
    }

    public void setFoodAllowed(boolean foodAllowed) {
        this.foodAllowed = foodAllowed;
    }

    public boolean isFoodSold() {
        return foodSold;
    }

    public void setFoodSold(boolean foodSold) {
        this.foodSold = foodSold;
    }

    public int getHygiene() {
        return hygiene;
    }

    public void setHygiene(int hygiene) {
        this.hygiene = hygiene;
    }

    public int getSeating() {
        return seating;
    }

    public void setSeating(int seating) {
        this.seating = seating;
    }

    public int getOpenTime() {
        return openTime;
    }

    public void setOpenTime(int openTime) {
        this.openTime = openTime;
    }

    public int getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(int closingTime) {
        this.closingTime = closingTime;
    }

    public int getPrivacy() {
        return privacy;
    }

    public void setPrivacy(int privacy) {
        this.privacy = privacy;
    }

    public boolean isVendingFood() {
        return vendingFood;
    }

    public void setVendingFood(boolean vendingFood) {
        this.vendingFood = vendingFood;
    }

    public boolean isRsvp() {
        return rsvp;
    }

    public void setRsvp(boolean rsvp) {
        this.rsvp = rsvp;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return jCardReq == location.jCardReq && foodAllowed == location.foodAllowed && foodSold == location.foodSold && hygiene == location.hygiene && seating == location.seating && openTime == location.openTime && closingTime == location.closingTime && privacy == location.privacy && vendingFood == location.vendingFood && rsvp == location.rsvp && volume == location.volume && Objects.equals(name, location.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, jCardReq, foodAllowed, foodSold, hygiene, seating, openTime, closingTime, privacy, vendingFood, rsvp, volume);
    }
}
