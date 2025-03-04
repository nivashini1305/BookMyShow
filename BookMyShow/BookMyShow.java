package BookMyShow;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class BookMyShow {
   private static  ArrayList<Account> accounts = new ArrayList<>();
    private static HashMap<String,Theatre> theatres = new HashMap<>();//hashMap for theatreName and theatre objects
    private static ArrayList<String> location=new ArrayList<>();//creates arraylist for storing location
    private static HashMap<String,ArrayList<Movies>> movies=new HashMap<>();//hashMap for movieName and movieName objects
    private static DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-MM-yyyy");//Date Formatter for formating date operations
    private static DateTimeFormatter timeFormatter=DateTimeFormatter.ofPattern("HH:mm");//Time Formatter for formating time operations

//getter methods

    public static void setAccounts(ArrayList<Account> accounts) {
        BookMyShow.accounts = accounts;
    }

    public static ArrayList<Account> getAccounts() {
        return accounts;
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
