package BookMyShow;

public class User {
    private String userId;
    private String userPin;
    private String location;
    public User(String userId,String userPin,String location){
        this.userId=userId;
        this.userPin=userPin;
        this.location=location;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserPin(String userPin) {
        this.userPin = userPin;
    }

    public String getUserPin() {
        return userPin;
    }

    public String getLocation() {
        return location;
    }
}
