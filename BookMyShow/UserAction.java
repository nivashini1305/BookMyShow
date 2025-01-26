package BookMyShow;
import java.util.Scanner;
public class UserAction {
    public static User userLogin(Scanner s){
        System.out.println("Enter the User name:");
        String userName=s.nextLine();//Enters the users name
        System.out.println("Enter the User pin:");
        String userPin=s.nextLine();//Enters the users pin
        for (User user:BookMyShow.getUsers()){
            if (user.getUserId().equals(userName)&&user.getUserPin().equals(userPin)){//checks the users id and users pin
                return user;
            } else if (user.getUserPin().equals(userName)&&!user.getUserPin().equals(userPin)) {//checks the admin id is equal and admin pin is wrong
                return new User(null,null,null);//returns the null to object
            }
        }
        return null;
    }
    public void displayMovie(){

    }
    }

