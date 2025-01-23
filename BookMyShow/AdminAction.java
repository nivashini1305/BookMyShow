package BookMyShow;

import java.util.HashMap;
import java.util.Scanner;
public class AdminAction {
    public static Admin adminLogin(Scanner s) {
        System.out.println("Enter the admin name:");
        String adminName = s.nextLine();//Enters the admin name
        System.out.println("Enter the admin pin:");
        String adminPin = s.nextLine();//Enters the admin pin
        for (Admin admin : BookMyShow.getAdmins()) {
            if (admin.getAdminId().equals(adminName) && admin.getAdminPin().equals(adminPin)) {//checks the admin id and admin pin
                return admin;
            } else if (admin.getAdminPin().equals(adminName) && !admin.getAdminPin().equals(adminPin)) {//checks the admin id is equal and admin pin is wrong
                return new Admin(null, null);//returns the null to object
            }
        }
        return null;
    }

    public static void addLocation(Scanner s) {
        System.out.println("Add the location:");
        String locationName = s.nextLine();

            if (BookMyShow.getLocation().contains(locationName)) {
                System.out.println("Location already exists...");
                return;
            }
            BookMyShow.getLocation().add(locationName);
        }
    public static void addTheatre(Scanner s) {

        System.out.println("The available locations are:");
        for(String location:BookMyShow.getLocation()){
            System.out.println("->"+location);
        }
        System.out.println("Enter the Location to add theatre");
        String location = s.nextLine();
        while (true) {
            if (!BookMyShow.getLocation().contains(location)) {
                System.out.println("Location not found");
                continue;
            }
            break;
        }
                System.out.println("Enter the theatre to be added:");
                String theatreName = s.nextLine();
                var keysOfTheatre=BookMyShow.getTheatres().keySet();

                if(keysOfTheatre.contains(theatreName)){
                    System.out.println("Already theatre exists");
                    return;
                }
                System.out.println("Enter the no.Of Screen:");
                int noOfScreens=Integer.parseInt(s.nextLine());

                HashMap<String,Screen>screenHashMap = new HashMap<>();
                int i;
                for (i=0;i<noOfScreens;i++){
                    AdminAction.addScreens(s,screenHashMap);

                }
                Theatre theatre=new Theatre(theatreName,location,screenHashMap);
                BookMyShow.getTheatres().put(theatreName,theatre);

    }
    public static void addScreens(Scanner s,HashMap<String,Screen> hashScreen) {
        while (true) {
            System.out.println("Enter the Screen name:");
            String screenName = s.nextLine();
            var screenKeys=hashScreen.keySet();
            if(screenKeys.contains(screenName)){
                System.out.println("Already exists!!!");
                continue;
            }
            System.out.println("Enter the no.of seats:");
            int noOfSeats = Integer.parseInt(s.nextLine());
            System.out.println("Enter the no.of seat grids:");
            String grids = s.nextLine();
            var noOfGrids=Utilities.generateGrid(noOfSeats,grids);
            Screen screen = new Screen(screenName, noOfSeats, grids);
            hashScreen.put(screenName,screen);
            for(var seatsAndGrids:noOfGrids.entrySet()){
                System.out.println(seatsAndGrids.getKey()+" "+seatsAndGrids.getValue());
            }
            return;
//            var keysOfScreen = hashScreen.keySet();
//            for (var keys : keysOfScreen) {
//                if (keysOfScreen.contains(screenName)) {
//                    hashScreen.get(keys);
//                }
//            }
//            if (keysOfScreen.contains(screenName)) {
//                System.out.println("Already screen exists");
//            }
//            for (String scree : keysOfScreen) {
//                if (scree.equals(screenName)) {
//

//                }
//            }

        }
    }
}


