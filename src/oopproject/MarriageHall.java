package oopproject;

import java.util.ArrayList;

public class MarriageHall {

    private String name, price;
    private int capacityPeople, capacitySize;
    private ArrayList<String> dates = new ArrayList<>();

    public MarriageHall(String Name, String Price, int CapacityP, int CapacityS, String D) {
        this.name = Name;
        this.price = Price;
        this.capacityPeople = CapacityP;
        this.capacitySize = CapacityS;
        this.dates.add(D);
    }

    public void SetName(String N) {
        this.name = N;
    }

    public void SetPrice(String P) {
        this.price = P;
    }

    public void SetCapacityPeople(int CP) {
        this.capacityPeople = CP;
    }

    public void SetCapacitySize(int CS) {
        this.capacitySize = CS;
    }

    public void SetDate(String D) {
        this.dates.add(D);
    }

    public String GetName() {
        return this.name;
    }

    public String GetPrice() {
        return this.price;
    }

    public int SetCapacityPeople() {
        return this.capacityPeople;
    }

    public int SetCapacitySize() {
        return this.capacitySize;
    }

    public ArrayList<String> SetDate() {
        return dates;
    }

}
