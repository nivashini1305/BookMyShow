package BookMyShow;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Tickets {
    private String theatreName;//variable for theatreName
    private String screenName;//variable for screenName
    private LocalTime showTime;//variable for showTime
    private  String movieName;//variable for movieName
    private LocalDate showDate;//variable for showDate
    private long price;//variable for ticket's price
    private ArrayList<String> bookedTickets;

    public Tickets(String theatreName,String screenName,LocalTime showTime,String movieName,ArrayList<String> bookedTickets,LocalDate showDate,long price){
        this.movieName=movieName;
        this.bookedTickets=bookedTickets;
        this.showTime=showTime;
        this.screenName=screenName;
        this.theatreName=theatreName;
        this.showDate=showDate;
        this.price=price;
    }
    public void setPrice(Long price){
        this.price=price;
    }

    public long getPrice() {
        return price;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setBookedTickets(ArrayList<String> bookedTickets) {
        this.bookedTickets = bookedTickets;
    }

    public ArrayList<String> getBookedTickets() {
        return bookedTickets;
    }

    public void setShowTime(LocalTime showTime) {
        this.showTime = showTime;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public LocalDate getShowDate() {
        return showDate;
    }
}
