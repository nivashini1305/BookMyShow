package BookMyShow;

public class Admin {
    private String adminId;//variable for the admin id
    private String adminPin;//variable for the admin pin
    public Admin(String adminId,String adminPin){
        this.adminId=adminId;
        this.adminPin=adminPin;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminPin(String adminPin) {
        this.adminPin = adminPin;
    }

    public String getAdminPin() {
        return adminPin;
    }
}
