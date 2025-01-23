package BookMyShow;

public class Admin {
    private String adminId;
    private String adminPin;
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
