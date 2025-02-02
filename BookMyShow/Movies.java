package BookMyShow;

import java.time.LocalDate;

public class Movies {
    private String movieName;//declares variable for movie name
    private LocalDate date;//declares variable for date of the movie
    private long duration;//declares variable for movie duration
    private String location;//declares variable for location of the movie where it runs
    private Theatre theatreName;//declares variable for theatre name of the movie
    private Screen screen;//declares variable for screen name of the movie
    private Show show;//declares variable for showtime of the movie
    private long price;//declares variable for price of the movie
    public Movies(String movieName, LocalDate date, long duration, String location, Theatre theatreName, Screen screen, Show show,Long price){
        this.movieName=movieName;
        this.date=date;
        this.duration=duration;
        this.show=show;
        this.location=location;
        this.screen=screen;
        this.theatreName=theatreName;
        this.price=price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getPrice() {
        return price;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTheatreName(Theatre theatreName) {
        this.theatreName = theatreName;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getDate() {
        return date;
    }

    public Screen getScreen() {
        return screen;
    }

    public long getDuration() {
        return duration;
    }

    public String getMovieName() {
        return movieName;
    }

    public Theatre getTheatre() {
        return theatreName;
    }
    public Show getShow() {
        return show;
    }

}
