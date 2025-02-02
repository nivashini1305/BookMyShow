package BookMyShow;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Show {
    private LocalTime startTime;//declares the variable for show's start time
    private LocalTime endTime;//declares the variable for show's end time
    private LocalDate showDate;//declares the variable for show's date
    private Screen screen;//declares the variable for show's screen
    private long price;//declares the variable for price
    private HashMap<Character, ArrayList<String>> showSeat=new HashMap<>();//hashmap to store the currentShow's seats
    public Show(LocalTime startTime,LocalTime endTime,LocalDate showDate,Screen screen,HashMap<Character,ArrayList<String>> showSeat,Long price){
        this.startTime=startTime;
        this.endTime=endTime;
        this.showDate=showDate;
        this.screen = screen;
        this.showSeat=showSeat;
        this.price=price;

    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public HashMap<Character, ArrayList<String>> getShowSeat    () {
        return showSeat;
    }

    public void setShowSeat(HashMap<Character, ArrayList<String>> showSeat) {
        this.showSeat = showSeat;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }
    @Override
    public boolean equals(Object o){
        if(o==null||getClass()!=o.getClass()){
            return false;
        }
        Show show=(Show) o;
        boolean a;
        a=show.getStartTime().equals(startTime)&&show.getEndTime().equals(endTime)&&show.getShowDate().equals(showDate);
        return a;

    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime,endTime,showDate);
    }
}
