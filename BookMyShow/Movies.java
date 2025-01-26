package BookMyShow;

import java.time.LocalDate;

public class Movies {
    private String movieName;
    private LocalDate date;
    private long duration;
    private String location;
    private Theatre theatreName;
    private Screen screen;
    private Show show;
    public Movies(String movieName, LocalDate date, long duration, String location, Theatre theatreName, Screen screen, Show show){
        this.movieName=movieName;
        this.date=date;
        this.duration=duration;
        this.show=show;
        this.location=location;
        this.screen=screen;
        this.theatreName=theatreName;
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
