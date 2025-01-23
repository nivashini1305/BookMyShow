package BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;

public class Theatre {
    private String theatreName;
    private String location;
    private HashMap<String,Screen> stringScreenHashMap = new HashMap<>();
    public Theatre(String theatreName,String location,HashMap<String,Screen> screens){
        this.theatreName=theatreName;
        this.location=location;
        this.stringScreenHashMap=screens;
    }
    public  HashMap<String, Screen> getScreen() {
        return stringScreenHashMap;
    }
    public HashMap<String, Screen> getScreens() {
        return stringScreenHashMap;
    }

    public Theatre(String theatreName){
        this.theatreName=theatreName;
    }
    public  void setTheatreName(String theatreName) {
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
