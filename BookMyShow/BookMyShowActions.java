package BookMyShow;
import java.util.HashMap;
import java.util.Scanner;
public class BookMyShowActions {
    public static void start() {
        Scanner s = new Scanner(System.in);
        Admin admin = new Admin("admin", "123");//creates an object for admin add the value  "admin" for admin id,"123" admin password
        AdminActions adminActions = new AdminActions();
        UserAction userAction = new UserAction();
        BookMyShow.getAccounts().add(admin);//adds the value to the arraylist
        while (true) {//loops until the user exits
            System.out.println("Login as\n1.Admin\n2.User\n3.Register\n4.Exit");
            int loginOption = Integer.parseInt(s.nextLine());
            switch (loginOption) {
                case 1://if the user chooses admin login
                    Account currentAdmin = adminActions.login();//calls the  admin login method and the return value stores in the currentAdmin

                    if (currentAdmin == null) {//if the return value is null prints as invalid credentials
                        System.out.println("Invalid credentials...Enter correctly");
                        break;
                    }
                    else {//calls the method if it returns admin object
                        System.out.println("Successfully logging in");
                        BookMyShowActions.adminOperations();
                        break;
                    }
                case 2://if the user chooses User login
                    Account currentUser = userAction.login();//calls the  user login method and the return value stores in the currentUser
                    if(currentUser==null){//if user returns null then it asks yes/no to register
                        System.out.println("User not available");
                        System.out.println("Do you want to register\n1.Yes \n2.No");
                        int option=Integer.parseInt(s.nextLine());
                        switch (option){
                            case 1:
                                userAction.register();
                                break;
                            case 2:
                                System.out.println("Signing out");
                                return;
                        }
                    } else if (currentUser.getPin()==null) {//if it returns null for the user pin
                        System.out.println("Invalid credentials");
                        return;
                    } else {
                        userAction.displayMovie((User) currentUser);//if it returns user object then it calls display movie method
                        break;
                    }
                    break;
                case 3://for the first time registration
                    userAction.register();//calls the register method in userActions
                    break;
                case 4://exits bookMyShow
                    System.out.println("Exitting...");
                    System.exit(0);
            }
        }
    }

    public static void adminOperations() {
        Scanner s = new Scanner(System.in);
        AdminActions adminActions=new AdminActions();
        while (true) {
            System.out.println("Choose your Operation to do...\n1.Add Location\n2.Add Theatre\n3.Add Movies\n4.View Theatre\n5.View Movie\n6.Log out");
            int operations = Integer.parseInt(s.nextLine());
            switch (operations) {
                case 1:
                    adminActions.addLocation();//calls method to add location
                    break;
                case 2:
                    adminActions.addTheatre(adminActions);//calls method to add theatre
                    break;
                case 3:
                    adminActions.addMovies();//calls method to add movies
                    break;
                case 4:
                    adminActions.viewTheatre();//calls method to view theatre
                    break;
                case 5:
                    adminActions.viewMovie();//calls method to view movie
                    break;
                case 6:
                   return;
            }
        }
    }
}

