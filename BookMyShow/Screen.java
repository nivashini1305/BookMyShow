package BookMyShow;

public class Screen {
    private String screenName;
    private int seatNumber;
    private String seatGrids;
    public Screen(String screenName,int seatNumber,String seatGrids){
        this.screenName = screenName;
        this.seatNumber=seatNumber;
        this.seatGrids=seatGrids;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
}
