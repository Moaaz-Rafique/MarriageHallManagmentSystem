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

    private String name, price, Location, date;
    private int capacityPeople;
    private ArrayList<String> dates = new ArrayList<>();
    private File imgP;
    private BufferedImage img = null;

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

    public MarriageHall(String Name, String Price, int CapacityP, int CapacityS, String D, File imgP) {

        this.name = Name;
        this.price = Price;
        this.capacityPeople = CapacityP;
        this.imgP = imgP;
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

    public void SetName(String N) {
        this.name = N;
    }

    public void SetPrice(String P) {
        this.price = P;
    }

    public void SetCapacityPeople(int CP) {
        this.capacityPeople = CP;
    }

    public void SetLocation(String L) {
        this.Location = L;
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

    public int GetCapacityPeople() {
        return this.capacityPeople;
    }

    public String GetLocation() {
        return this.Location;
    }

    public ArrayList<String> GetDate() {
        return dates;
    }

    ConnectionToDB con = new ConnectionToDB();
    Connection con1 = con.EstablishConnection();
    Statement s = null;
    PreparedStatement ps = null;
    ResultSet res = null;

    public boolean addDate(String D) {
        boolean b = false;
        String sql = "insert into Halls(Date Fixed)values('" + D + "')";

        try {
            s = con1.createStatement();
            int res = s.executeUpdate(sql);

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Data Inserted!");
                b = true;
            } else {
                b = false;
                JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return b;
    }

    public boolean searchPrice(String P) {
        String loginString = "select * from Halls where Price = '" + P + "' ";
        boolean b = false;

        try {
            ps = con1.prepareStatement(loginString);
            res = ps.executeQuery();

            while (res.next()) {
                name = res.getString("Name");
                Location = res.getString("Location");
                capacityPeople = res.getInt("People Capacity");
                date = res.getString("Date Fixed");
                b = true;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return b;
    }

    public boolean searchPeopleCapacity(int PC) {
        String loginString = "select * from Halls where People Capacity = '" + PC + "' ";
        boolean b = false;

        try {
            ps = con1.prepareStatement(loginString);
            res = ps.executeQuery();

            while (res.next()) {
                name = res.getString("Name");
                Location = res.getString("Location");
                price = res.getString("Price");
                date = res.getString("Date Fixed");
                b = true;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return b;
    }

    public boolean UpdateUser(int ID, String N, String L, String P, int PC, String D) {
        boolean b = false;
        String sql = "Update Halls set (Name,Location,Price,People Capacity,Date Fixed)=('" + N + "','" + L + "','" + P + "','" + PC + "','" + D + "') where ID='" + ID + "'";
        try {
            s = con1.createStatement();
            int rs = s.executeUpdate(sql);
            if (rs > 0) {
                b = true;
            } else {
                b = false;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return b;
    }
}
