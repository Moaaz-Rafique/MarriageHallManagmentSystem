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

public class User {
    private int id;
    private String name;
    private String password;
    private String userType;
    private String contact;
    private File imgP;
    private BufferedImage img = null;
    private ArrayList <MarriageHall> myMarriageHalls= new ArrayList<>();
    class BookedMarriageHalls{
        MarriageHall mH;
        String date;

        public BookedMarriageHalls(MarriageHall mH, String date) {
            this.mH = mH;
            this.date = date;
        }

        public MarriageHall getmH() {
            return mH;
        }

        public void setmH(MarriageHall mH) {
            this.mH = mH;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
        
    }
    
    private ArrayList <BookedMarriageHalls> bookedMarriageHalls= new ArrayList<>();
    public User() {
        
    }

    public User(String name, String password,String contact, File imgP) {
        this.name = name;
        this.password = password;
        this.imgP = imgP;
        this.contact = contact;
        try {
            img = ImageIO.read(imgP);
        } catch (IOException ex) {
            Logger.getLogger(MarriageHall.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public User(int id, String name, String password,String contact, File imgP) {
        this(name, password, contact, imgP);
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    public File getImgP() {
        return imgP;
    }

    public void setImgP(File imgP) {
        this.imgP = imgP;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public ArrayList<BookedMarriageHalls> getBookedMarriageHalls() {
        return bookedMarriageHalls;
    }

    public void setBookedMarriageHalls(ArrayList<BookedMarriageHalls> bookedMarriageHalls) {
        this.bookedMarriageHalls = bookedMarriageHalls;
    }

    public ArrayList<MarriageHall> getMyMarriageHalls() {
        return myMarriageHalls;
    }

    public void setMyMarriageHalls(ArrayList<MarriageHall> myMarriageHalls) {
        this.myMarriageHalls = myMarriageHalls;
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
    
    
}
