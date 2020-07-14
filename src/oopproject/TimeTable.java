package oopproject;

import static oopproject.MainForm.getMarriageHall;
import static oopproject.MainForm.getUser;
import oopproject.User.BookedMarriageHalls;

public class TimeTable {
    private int id;
    private User buyer;
    private MarriageHall mH;

    public TimeTable(int id, int buyerId, int mHId, String date) {
        this.id = id;
        this.buyer = getUser(buyerId);        
        this.mH = getMarriageHall(mHId);
        buyer.getBookedMarriageHalls().add(buyer.new BookedMarriageHalls(mH, date));
        mH.getDates().add(date);        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public MarriageHall getmH() {
        return mH;
    }

    public void setmH(MarriageHall mH) {
        this.mH = mH;
    }
    
}
