package BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Screen {
    private String screenName;//declares variable for screen name
    private int seatNumber;//declares variable for the total number of seats
    private String grid;//declares the variable for seat pattern
    private HashMap<Character, ArrayList<String>> seats;//hashMap for seats
    private HashSet<Show> showHashSet=new HashSet<>();// to store shows running in the screen
    public Screen(String screenName,int seatNumber,HashMap<Character,ArrayList<String>> seats,String grid){
        this.screenName = screenName;
        this.seatNumber=seatNumber;
        this.grid = grid;
        this.seats=seats;
    }

    public String getGrid() {
        return grid;
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
