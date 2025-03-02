package BookMyShow;

import java.util.ArrayList;

public class User extends Account{

    private String location;//variable for the user location
    ArrayList<Tickets> tickets=new ArrayList<>();//Array list to store all the user tickets
    public User(String name,String pin,String location){
       super(name,pin);
        this.location=location;
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
