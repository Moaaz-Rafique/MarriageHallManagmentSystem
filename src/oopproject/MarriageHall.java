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

public class MarriageHall {

    private String name, price;
    private int capacityPeople, capacitySize;
    
    private ArrayList<String> dates = new ArrayList<>();
    private File imgP;

    public File getImgP() {
        return imgP;
    }

    public void setImgP(File imgP) {
        this.imgP = imgP;
    }
    private BufferedImage img = null;

    MarriageHall() {
        this.name = " ";
        this.price = "";
        this.capacityPeople = 0;
        this.capacitySize = 0;
        this.imgP = null;
        
        this.dates.add(" ");
    }

    public MarriageHall(String Name, String Price, int CapacityP, int CapacityS, String D, File imgP) {
        this.name = Name;
        this.price = Price;
        this.capacityPeople = CapacityP;
        this.capacitySize = CapacityS;
        this.imgP = imgP;
        try {
            img = ImageIO.read(imgP);
        } catch (IOException ex) {
            Logger.getLogger(MarriageHall.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dates.add(D);
    }
    public void setImageFromFile(JLabel label){
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
