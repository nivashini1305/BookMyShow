package BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;

public class BookMyShow {
    private static ArrayList<Admin> admins = new ArrayList<>();//creates arraylist for admin
    private static ArrayList<User> users = new ArrayList<>();//creates arraylist for users
    private static HashMap<String,Theatre> theatres = new HashMap<>();
    private static ArrayList<String> location=new ArrayList<>();

//getter methods
    public static ArrayList<Admin> getAdmins() {
        return admins;
    }
    public static ArrayList<User> getUsers() {
        return users;
    }
    public static HashMap<String,Theatre> getTheatres(){
        return theatres;
    }

    public static void setLocation(ArrayList<String> location) {
        BookMyShow.location = location;
    }
    public static ArrayList<String> getLocation() {
        return location;
    }
}
