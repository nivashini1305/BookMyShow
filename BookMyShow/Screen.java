package BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Screen {
    private String screenName;
    private int seatNumber;
    private HashMap<Character, ArrayList<String>> seats;
    private HashSet<Show> showHashSet=new HashSet<>();
    public Screen(String screenName,int seatNumber,HashMap<Character,ArrayList<String>> seats){
        this.screenName = screenName;
        this.seatNumber=seatNumber;
        this.seats=seats;
    }

    public HashSet<Show> getShowHashSet() {
        return showHashSet;
    }

    public HashMap<Character, ArrayList<String>> getSeats() {
        return seats;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
}
