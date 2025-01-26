package BookMyShow;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;
public class BookMyShowActions {
    public static void start() {
        Scanner s = new Scanner(System.in);
        Admin admin = new Admin("admin", "123");//creates an object for admin add the value  "admin" for admin id,"123" admin password
        BookMyShow.getAdmins().add(admin);//adds the value to the arraylist
        while (true) {//loops until the user exits
            System.out.println("Login as\n1.Admin\n2.User\n3.Register\n4.Exit");
            int loginOption = Integer.parseInt(s.nextLine());
            switch (loginOption) {
                case 1://if the user chooses admin login
                    Admin currentAdmin = AdminActions.adminLogin(s);//calls the  admin login method and the return value stores in the currentAdmin
                    if (currentAdmin == null) {
                        System.out.println("Invalid credentials...Enter correctly");
                        break;
                    } else if (currentAdmin.getAdminPin() == null) {
                        System.out.println("Invalid pin...Enter the pin correctly");
                        break;
                    } else {
                        System.out.println("Successfully logging in");
                        BookMyShowActions.adminOperations(s);
                        return;
                    }
                case 2://if the user chooses User login
                    User currentUser = UserAction.userLogin(s);//calls the  user login method and the return value stores in the currentUser
                    if (currentUser == null) {
                        System.out.println("Invalid credentials...Enter correctly");
                        return;
                    } else if (currentUser.getUserPin() == null) {
                        System.out.println("Invalid pin...Enter the pin correctly");
                        return;
                    } else {
                        System.out.println("Successfully logging in");
                        return;
                    }
                case 3://if the user chooses for register
                    System.out.println("Enter the User name:");
                    String userName = s.nextLine();
                    System.out.println("Enter the User pin:");
                    String userPin = s.nextLine();
                    System.out.println("Enter the User Location:");
                    String location=s.nextLine();
                    BookMyShow.getUsers().add(new User(userName, userPin,location));
                    System.out.println("Registered successfully");

                case 4:
                    System.out.println("Exitting...");
                    System.exit(0);
            }
        }
    }

    public static void adminOperations(Scanner s) {
        while (true) {
            System.out.println("Choose your Operation to do...\n1.Add Location\n2.Add Theatre\n3.Add Movies\n4.View Theatre\n5.View Movie\n6.Log out");
            int operations = Integer.parseInt(s.nextLine());
            switch (operations) {
                case 1:
                    AdminActions.addLocation(s);
                    break;
                case 2:
                    AdminActions.addTheatre(s);
                    break;
                case 3:
                    AdminActions.addMovies(s);
                    break;
                case 4:
                    AdminActions.viewTheatre();
                    break;
                case 5:
                    AdminActions.viewMovie();
                    break;
                case 6:
                   return;
            }
        }
    }
}

