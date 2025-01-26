package BookMyShow;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class BookMyShow {
    private static ArrayList<Admin> admins = new ArrayList<>();//creates arraylist for admin
    private static ArrayList<User> users = new ArrayList<>();//creates arraylist for users
    private static HashMap<String,Theatre> theatres = new HashMap<>();
    private static ArrayList<String> location=new ArrayList<>();
    private static HashMap<String,ArrayList<Movies>> movies=new HashMap<>();
    private static DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static DateTimeFormatter timeFormatter=DateTimeFormatter.ofPattern("HH:mm");

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

    public static HashMap<String,ArrayList<Movies>> getMovies() {
        return movies;
    }

    public static DateTimeFormatter getFormatter() {
        return formatter;
    }

    public static DateTimeFormatter getTimeFormatter() {
        return timeFormatter;
    }
}
