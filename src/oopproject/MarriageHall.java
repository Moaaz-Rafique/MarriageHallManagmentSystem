package oopproject;
import java.util.ArrayList;
public class MarriageHall {
    
private String Name,Price;
private int CapacityPeople,CapacitySize;
private ArrayList<String> Dates = new ArrayList<>();


public MarriageHall(String Name,String Price,int CapacityP,int CapacityS,String D){
this.Name = Name;
this.Price = Price;
this.CapacityPeople = CapacityP;
this.CapacitySize = CapacityS;
this.Dates.add(D);
}

public void SetName(String N){
this.Name = N;
}

public void SetPrice(String P){
this.Price = P;
}

public void SetCapacityPeople(int CP){
this.CapacityPeople = CP;
}

public void SetCapacitySize(int CS){
this.CapacitySize = CS;
}

public void SetDate(String D){
this.Dates.add(D);
}

public String GetName(){
return this.Name;
}

public String GetPrice(){
return this.Price;
}

public int SetCapacityPeople(){
return this.CapacityPeople;
}

public int SetCapacitySize(){
return this.CapacitySize;
}

public ArrayList<String> SetDate(){
return Dates;
}


}

