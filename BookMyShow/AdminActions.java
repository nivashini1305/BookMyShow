package BookMyShow;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
    public class AdminActions {
        //login method for admin
        public static Admin adminLogin(Scanner s) {
            System.out.print("Enter the admin name:");
            String adminName = s.nextLine();//Enters the admin name
            System.out.print("Enter the admin pin:");
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
            System.out.print("Add the location:");
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
            String location = null;
            while (true) {
                System.out.print("Enter the Location to add theatre:");
                location = s.nextLine();

                if (!BookMyShow.getLocation().contains(location)) {
                    System.out.print("Location not found");
                    continue;
                }
                break;
            }
            System.out.print("Enter the theatre to be added:");
            String theatreName = s.nextLine();
            var keysOfTheatre=BookMyShow.getTheatres().keySet();

            if(keysOfTheatre.contains(theatreName)){
                System.out.print("Already theatre exists");
                return;
            }
            System.out.print("Enter the no.Of Screen:");
            int noOfScreens=Integer.parseInt(s.nextLine());
            HashMap<String,Screen> screenHashMap = new HashMap<>();
            for (int i=0;i<noOfScreens;i++){
                AdminActions.addScreens(s,screenHashMap);
            }
            Theatre theatre=new Theatre(theatreName,location,screenHashMap);
            BookMyShow.getTheatres().put(theatreName,theatre);

        }
        public static void addScreens(Scanner s,HashMap<String,Screen> hashScreen) {
            while (true) {
                System.out.print("Enter the Screen name:");
                String screenName = s.nextLine();
                var screenKeys=hashScreen.keySet();
                if(screenKeys.contains(screenName)){
                    System.out.println("Already exists!!!");
                    continue;
                }
                System.out.print("Enter the no.of seats:");
                int noOfSeats = Integer.parseInt(s.nextLine());
                System.out.print("Enter the no.of seat grids:");
                String grids = s.nextLine();
                var noOfGrids=Utilities.generateGrid(noOfSeats,grids);
                Screen screen = new Screen(screenName, noOfSeats, noOfGrids,grids);
                hashScreen.put(screenName,screen);
                if(noOfGrids!=null)
                {
                    for(var seatsAndGrids:noOfGrids.entrySet()){
                        System.out.println(seatsAndGrids.getKey()+" "+seatsAndGrids.getValue());
                    }
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
        public static void addMovies(Scanner s) {
            System.out.println("Available Locations...");
            for (String availableLocation : BookMyShow.getLocation()) {
                System.out.println("->" + availableLocation);
            }
            String location = null;
            while (true) {
                System.out.println("Enter the LOCATION to add MOVIE:");
                location = s.nextLine();
                if (!BookMyShow.getLocation().contains(location)) {
                    System.out.println("Location not found");
                    continue;
                }
                break;
            }
            boolean check=false;
            System.out.println("Available theatres...");
            for (var theatre : BookMyShow.getTheatres().keySet()) {
                if (BookMyShow.getTheatres().get(theatre).getLocation().equals(location)) {
                    System.out.println("->" + theatre);
                    check=true;
                }
            }
            if(!check){
                System.out.println("No theatres found!!");
                return;
            }
            String theatreNameToAddMovie = null;
            while (true) {
                System.out.print("Enter theatre name to add movies:");
                theatreNameToAddMovie = s.nextLine();
                if (!BookMyShow.getTheatres().containsKey(theatreNameToAddMovie)) {
                    System.out.println("No Theatre found");
                    continue;
                }
                break;
            }
            System.out.print("Enter the Movie Name:");
            String movieName = s.nextLine();
            System.out.print("Enter the movie Duration time in minutes:");
            long durationOfMovie = Long.parseLong(s.nextLine());
            System.out.print("Enter the Date of the movie: ");
            LocalDate dateOfTheMovie = LocalDate.parse(s.nextLine(), BookMyShow.getFormatter());
            Theatre theatre = BookMyShow.getTheatres().get(theatreNameToAddMovie);
            System.out.print("Enter the movie price:");
            long price=Long.parseLong(s.nextLine());
            System.out.println("Available Screens...");
            for (String screen : theatre.getScreen().keySet()) {
                System.out.println("->"+theatre.getScreen().get(screen).getScreenName());
            }

            String screenNametoAddMovie = null;
            while (true) {
                System.out.print("Enter the screen name to add movie:");
                screenNametoAddMovie = s.nextLine();
                var keysOfScreen = theatre.getScreen().keySet();
                if (!keysOfScreen.contains(screenNametoAddMovie)) {
                    System.out.println("No screen found...");
                    continue;
                }
                break;
            }
            var screenObj = theatre.getScreen().get(screenNametoAddMovie);
            LocalTime startTime = null;
            LocalTime endTime = null;
            label:
            while (true) {
                System.out.print("Enter the Start time of the movie:");
                startTime = LocalTime.parse(s.nextLine(), BookMyShow.getTimeFormatter());
                endTime = startTime.plusMinutes(durationOfMovie + 30);
                for (Show showObj : screenObj.getShowHashSet()) {
                    if (!(startTime.isBefore(showObj.getStartTime()) && endTime.isBefore(showObj.getStartTime()) ||
                            startTime.isAfter(showObj.getEndTime()) && endTime.isAfter(showObj.getEndTime()))) {
                        System.out.println("Show Already exists");
                        continue label;
                    }
                }
                var seatsInShow = Utilities.generateGrid(screenObj.getSeatNumber(),screenObj.getGrid());
                Show show = new Show(startTime, endTime, dateOfTheMovie,screenObj,seatsInShow,price);
                if (screenObj.getShowHashSet().contains(show)) {
                    System.out.println("Show already exists...");
                    return;
                }
                screenObj.getShowHashSet().add(show);
                ArrayList<Movies> moviesArrayList = BookMyShow.getMovies().get(movieName);
                Movies movies = new Movies(movieName, dateOfTheMovie, durationOfMovie, location, theatre, screenObj, show,price);
                if (moviesArrayList == null) {
                    moviesArrayList = new ArrayList<>();
                }
                moviesArrayList.add(movies);
                BookMyShow.getMovies().put(movieName, moviesArrayList);
                System.out.println("Movies has been added successfully");
                break;
            }

        }
        public static void viewTheatre(){
            var keysToVIewTheatre=BookMyShow.getTheatres().keySet();
            for(var keys:keysToVIewTheatre){
                System.out.println("The available theatres are:"+keys);
                Theatre theatre=BookMyShow.getTheatres().get(keys);
                for(var screens:theatre.getScreen().entrySet())
                {
                    System.out.println("Screen name: "+ screens.getValue().getScreenName());
                    System.out.println("Seat number: "+screens.getValue().getSeatNumber());
                    HashMap<Character, ArrayList<String>>seat =screens.getValue().getSeats();
                    for(var seats:seat.entrySet()){
                        System.out.println(seats.getKey()+" "+seats.getValue());
                    }
                }
            }
        }
        public static void viewMovie(){
            var keysInMovies=BookMyShow.getMovies().keySet();
            System.out.println("Available movies..");
            for(String movieKeys:keysInMovies){
                System.out.println("The Movie:"+movieKeys);
                ArrayList<Movies> movies=BookMyShow.getMovies().get(movieKeys);
                for(var movieObj:movies){
                    System.out.println("The location of the movie:"+movieObj.getLocation());
                    System.out.println("The Duration of the movie:"+movieObj.getDuration()+" mins");
                    System.out.println("The Date of the the movie:"+movieObj.getDate());
                    System.out.println("The Start time of the movie:"+movieObj.getShow().getStartTime());
                    System.out.println("The End time of the movie:"+movieObj.getShow().getEndTime());
                    System.out.println("The Theatre Name:"+movieObj.getTheatre().getTheatreName());
                    System.out.println("The Screen Name:"+movieObj.getScreen().getScreenName());
                    System.out.println();
                    System.out.println("----------------------------------------------");

                }
            }
        }
    }
