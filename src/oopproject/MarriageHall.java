package oopproject;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.sql.*;
import javax.swing.JOptionPane;

public class MarriageHall {

    private String name, price, location, date;
    private int capacityPeople;
    private ArrayList<String> dates = new ArrayList<>();
    private File imgP;
    private BufferedImage img = null;
    private User seller,consumer;
    private String contact = "COnatct";
    public File getImgP() {
        return imgP;
    }

    public void setImgP(File imgP) {
        this.imgP = imgP;
    }

    MarriageHall() {
        this.name = " ";
        this.price = "";
        this.capacityPeople = 0;
        this.imgP = null;

        this.dates.add(" ");
    }

    public MarriageHall(String Name, String Price, int CapacityP,String Location,String contact, String D, File imgP) {

        this.name = Name;
        this.price = Price;
        this.capacityPeople = CapacityP;
        this.imgP = imgP;
        this.location = Location;
        this.date = D;
        this.contact = contact;
        try {
            img = ImageIO.read(imgP);
        } catch (IOException ex) {
            Logger.getLogger(MarriageHall.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dates.add(D);
    }

    public void setImageFromFile(JLabel label) {
        try {
            img = ImageIO.read(imgP);
        } catch (IOException ex) {
            Logger.getLogger(MarriageHall.class.getName()).log(Level.SEVERE, null, ex);
        }
        label.setIcon(new ImageIcon(getImg().getScaledInstance(label.getWidth(), label.getHeight(),
                Image.SCALE_AREA_AVERAGING)));
    }

    public int getCapacityPeople() {
        return capacityPeople;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public ArrayList<String> getDates() {
        return dates;
    }

    public User getSeller() {
        return seller;
    }

    public User getConsumer() {
        return consumer;
    }    

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setLocation(String Location) {
        this.location = Location;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCapacityPeople(int capacityPeople) {
        this.capacityPeople = capacityPeople;
    }

    public void setDates(ArrayList<String> dates) {
        this.dates = dates;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public void setConsumer(User consumer) {
        this.consumer = consumer;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
