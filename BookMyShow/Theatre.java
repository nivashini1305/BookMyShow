package BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;

public class Theatre {
    private String theatreName;//variable for theatre name
    private String location;//variable for theatre location
    private HashMap<String,Screen> stringScreenHashMap = new HashMap<>();//hashmap to store the screen name and its object
    public Theatre(String theatreName,String location,HashMap<String,Screen> screens){
        this.theatreName=theatreName;
        this.location=location;
        this.stringScreenHashMap=screens;
    }
    public  HashMap<String, Screen> getScreen() {
        return stringScreenHashMap;
    }
    public void setTheatre(String theatreName){
        this.theatreName=theatreName;
    }

    public  void setTheatreName(String theatreName)
    {
        this.theatreName = theatreName;
    }

    public  String getTheatreName() {
        return theatreName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
