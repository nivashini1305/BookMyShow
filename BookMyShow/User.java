package BookMyShow;

public class User {
    private String userId;
    private String userPin;
    public User(String userId,String userPin){
        this.userId=userId;
        this.userPin=userPin;
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
}
