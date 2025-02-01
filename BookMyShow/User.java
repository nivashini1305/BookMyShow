package BookMyShow;

import java.util.ArrayList;

public class User {
    private String userId;
    private String userPin;
    private String location;
    ArrayList<Tickets> tickets=new ArrayList<>();//Array list to store all the user tickets
    public User(String userId,String userPin,String location){
        this.userId=userId;
        this.userPin=userPin;
        this.location=location;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserPin(String userPin) {
        this.userPin = userPin;
    }

    public String getUserPin() {
        return userPin;
    }

    public void setLocation(String location){
        this.location=location;
    }

    public String getLocation() {
        return location;
    }

    public ArrayList<Tickets> getTickets() {
        return tickets;
    }
}
