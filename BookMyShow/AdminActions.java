package BookMyShow;

import BookMyShow.Interfaces.AdminActionInterface;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
    public  class AdminActions implements AdminActionInterface {
        //login method for admin
        public  Account login() {
            Scanner s=new Scanner(System.in);
            System.out.print("Enter the admin name:");
            String adminName = s.nextLine();//Enters the admin name
            System.out.print("Enter the admin pin:");
            String adminPin = s.nextLine();//Enters the admin pin
            for (Account admin : BookMyShow.getAccounts()) {
                if(admin instanceof Admin){
                    if (admin.getName().equals(adminName) && admin.getPin().equals(adminPin)) {//checks the admin id and admin pin
                        return admin;
                    } else if (admin.getName().equals(adminName) && !admin.getPin().equals(adminPin)) {//checks the admin id is equal and admin pin is wrong
                        return new Admin(null, null);//returns the null to object
                    }
                }
            }
            return null;
        }

        public  void addLocation() {
            Scanner s=new Scanner(System.in);
            System.out.println("Add the location:");
            String locationName = s.nextLine();
            System.out.println("Location added Successfully");

            if (BookMyShow.getLocation().contains(locationName)) {//checks already the location is available
                System.out.println("Location already exists...");
                return;
            }
            BookMyShow.getLocation().add(locationName);//if not adds the location
        }
        public  void addTheatre(AdminActions adminActions) {
            Scanner s=new Scanner(System.in);
            System.out.println("The available locations are:");
            for(String location:BookMyShow.getLocation()){//loops all the location to print
                System.out.println("->"+location);
            }
            String location = null;
            while (true) {
                System.out.println("Enter the Location to add theatre:");
                location = s.nextLine();//gets input to add the location

                if (!BookMyShow.getLocation().contains(location)) {//check for the location is not available
                    System.out.println("Location not found");
                    continue;
                }
                break;
            }
            System.out.print("Enter the theatre to be added:");
            String theatreName = s.nextLine();//gets the theatre name to be added
            var keysOfTheatre=BookMyShow.getTheatres().keySet();//all the keys are stored in a keysOfTheatre

            if(keysOfTheatre.contains(theatreName)){//checks for the theatre name already exists
                System.out.print("Already theatre exists");
                return;
            }
            System.out.print("Enter the no.Of Screen:");
            int noOfScreens=Integer.parseInt(s.nextLine());//gets the screen name
            HashMap<String,Screen> screenHashMap = new HashMap<>();//local hashmap for screen
            for (int i=0;i<noOfScreens;i++){//loops for no of screen which is to be added
                adminActions.addScreens(screenHashMap);//each time calls the method to add screen
            }
            Theatre theatre=new Theatre(theatreName,location,screenHashMap);//adds these all to theatre object
            BookMyShow.getTheatres().put(theatreName,theatre);//adds to the hashmap

        }
        public  void addScreens(HashMap<String,Screen> hashScreen) {
            Scanner s=new Scanner(System.in);
            while (true) {
                System.out.print("Enter the Screen name:");
                String screenName = s.nextLine();// gets input for screen name
                var screenKeys=hashScreen.keySet();//takes all the keys from the screen hashmap
                if(screenKeys.contains(screenName)){//checks the screen name in the hashmap
                    System.out.println("Already exists!!!");//if true...print Already exists
                    continue;
                }
                System.out.print("Enter the no.of seats:");
                int noOfSeats = Integer.parseInt(s.nextLine());//gets input for seat number
                System.out.print("Enter the no.of seat grids:");
                String grids = s.nextLine();//gets input for seat grid
                var noOfGrids=Utilities.generateSeat(noOfSeats,grids);//after getting input calls the generateSeat method to generate Seats and store it in av variable
                Screen screen = new Screen(screenName, noOfSeats, noOfGrids,grids);//adding all these to the screen object
                hashScreen.put(screenName,screen);//adding the key and value to the hashmap
                if(noOfGrids!=null)
                {
                    for(var seatsAndGrids:noOfGrids.entrySet()){//loops to print the key and value
                        System.out.println(seatsAndGrids.getKey()+" "+seatsAndGrids.getValue());
                    }
                }
                return;
            }
        }
        public  void addMovies() {
            Scanner s= new Scanner(System.in);
            System.out.println("Available Locations...");
            for (String availableLocation : BookMyShow.getLocation()) {//loops over location to display
                System.out.println("->" + availableLocation);//prints all the location
            }
            String location = null;
            while (true) {
                System.out.println("Enter the LOCATION to add MOVIE:");
                location = s.nextLine();//gets location to add movie as input
                if (!BookMyShow.getLocation().contains(location)) {//checks if the location doesn't contain in the arrayList
                    System.out.println("Location not found");// prints as location is not available
                    continue;
                }
                break;
            }
            boolean check=false;
            System.out.println("Available theatres...");
            for (var theatre : BookMyShow.getTheatres().keySet()) {//gets the key from the theatre hashMap
                if (BookMyShow.getTheatres().get(theatre).getLocation().equals(location)) {//checks the given location and the theatre's location object
                    System.out.println("->" + theatre);
                    check=true;
                }
            }
            if(!check){
                System.out.println("No theatres found!!");//if the boolean value remain false
                return;
            }
            String theatreNameToAddMovie = null;
            while (true) {
                System.out.print("Enter theatre name to add movies:");
                theatreNameToAddMovie = s.nextLine();//gets the theatre name as input
                if (!BookMyShow.getTheatres().containsKey(theatreNameToAddMovie)) {//checks if the theatre doesn't contain in the hashmap
                    System.out.println("No Theatre found");//prints theatre not found
                    continue;
                }
                break;
            }
            System.out.print("Enter the Movie Name:");
            String movieName = s.nextLine();//gets the movie name to be added
            System.out.print("Enter the movie Duration time in minutes:");
            long durationOfMovie = Long.parseLong(s.nextLine());//gets the total duration of the movie
            System.out.print("Enter the Date of the movie: ");
            LocalDate dateOfTheMovie = LocalDate.parse(s.nextLine(), BookMyShow.getFormatter());//gets the date of the movie to be added
            Theatre theatre = BookMyShow.getTheatres().get(theatreNameToAddMovie);//gets the objects of the theatre name
            System.out.print("Enter the movie price:");
            long price=Long.parseLong(s.nextLine());//gets the movie price of the ticket
            System.out.println("Available Screens...");
            for (String screen : theatre.getScreen().keySet()) {
                System.out.println("->"+theatre.getScreen().get(screen).getScreenName());//prints all the available screens
            }

            String screenNametoAddMovie = null;
            while (true) {
                System.out.print("Enter the screen name to add movie:");
                screenNametoAddMovie = s.nextLine();//gets the screen name to add movie
                var keysOfScreen = theatre.getScreen().keySet();
                if (!keysOfScreen.contains(screenNametoAddMovie)) {//checks that the screen name is not contains in the theatre hashmap
                    System.out.println("No screen found...");
                    continue;
                }
                break;
            }
            var screenObj = theatre.getScreen().get(screenNametoAddMovie);//gets the objects of the screenName
            LocalTime startTime = null;
            LocalTime endTime = null;
            label:
            while (true) {
                System.out.print("Enter the Start time of the movie:");
                startTime = LocalTime.parse(s.nextLine(), BookMyShow.getTimeFormatter());//gets the start time of the movie
                endTime = startTime.plusMinutes(durationOfMovie + 30);// calculate end time

                for (Show showObj : screenObj.getShowHashSet()) { // loop over show objects to check it same show available already
                    //condition that checks if the show is before old show timings or after the old show timings
                    if (!(startTime.isBefore(showObj.getStartTime()) && endTime.isBefore(showObj.getStartTime()) ||
                            startTime.isAfter(showObj.getEndTime()) && endTime.isAfter(showObj.getEndTime()))) {
                        System.out.println("Show Already exists"); // if yes prints show already exists
                        continue label;
                    }
                }
                var seatsInShow = Utilities.generateSeat(screenObj.getSeatNumber(),screenObj.getGrid());//the return value of generate seats are stored in seatsInShow
                Show show = new Show(startTime, endTime, dateOfTheMovie,screenObj,seatsInShow,price);//all the objects are passed to the show object
                if (screenObj.getShowHashSet().contains(show)) {//checks if the show object is already contained in the show hashset
                    System.out.println("Show already exists...");//if yes then prints this
                    return;
                }
                screenObj.getShowHashSet().add(show);//if not contains, adds the show object to the showHashSet
                ArrayList<Movies> moviesArrayList = BookMyShow.getMovies().get(movieName);//the movie objects are taken and stored
                Movies movies = new Movies(movieName, dateOfTheMovie, durationOfMovie, location, theatre, screenObj, show,price);//adds all these objects are passed to the movie object
                if (moviesArrayList == null) {//if the movie arraylist is null
                    moviesArrayList = new ArrayList<>();//creates a new arraylist
                }
                moviesArrayList.add(movies);//else the movie objects are added to the arrayList
                BookMyShow.getMovies().put(movieName, moviesArrayList);//movie name and the arrayList added to the hashmap
                System.out.println("Movies has been added successfully");
                break;//breaks the loop
            }

        }
        public  void viewTheatre(){
            var keysToVIewTheatre=BookMyShow.getTheatres().keySet();//all the keys of theatre hashMap is are taken
            for(var keys:keysToVIewTheatre){//loops each key
                System.out.println("The available theatres are:"+keys);//prints all the available theatres
                Theatre theatre=BookMyShow.getTheatres().get(keys);//gets the object of the theatreName
                for(var screens:theatre.getScreen().entrySet())//loops to print the value of the screen
                {
                    System.out.println("Screen name: "+ screens.getValue().getScreenName());//prints the screen name
                    System.out.println("Seat number: "+screens.getValue().getSeatNumber());// prints the seat number
                    HashMap<Character, ArrayList<String>>seat =screens.getValue().getSeats();//take the value of the seats where the seats are the arraylist
                    for(var seats:seat.entrySet()){// loops to print all the seat's key and value
                        System.out.println(seats.getKey()+" "+seats.getValue());
                    }
                }
            }
        }
        public  void viewMovie(){
            var keysInMovies=BookMyShow.getMovies().keySet();//gets all the keys of the movies hashmap
            System.out.println("Available movies..");
            boolean check =false;
            if(!check){
                for(String movieKeys:keysInMovies){//loops to print all the moviesName
                    System.out.println("The Movie:"+movieKeys);
                    ArrayList<Movies> movies=BookMyShow.getMovies().get(movieKeys);//stores the value of the movie hashmap
                    for(var movieObj:movies){//takes each from the arraylist
                        System.out.println("The location of the movie:"+movieObj.getLocation());//prints the location of the movie
                        System.out.println("The Duration of the movie:"+movieObj.getDuration()+" mins");//prints the duration of the movie
                        System.out.println("The Date of the the movie:"+movieObj.getDate());//prints the date of the movie
                        System.out.println("The Start time of the movie:"+movieObj.getShow().getStartTime());//prints the start time of the movie
                        System.out.println("The End time of the movie:"+movieObj.getShow().getEndTime());//prints the end time of the movie
                        System.out.println("The Theatre Name:"+movieObj.getTheatre().getTheatreName());//prints the theatre name of the movie
                        System.out.println("The Screen Name:"+movieObj.getScreen().getScreenName());//prints the screen name of the movie
                        System.out.println();
                        System.out.println("----------------------------------------------");
                        check=true;
                    }
                }
            }
            if(!check){
                System.out.println("No movies found");
            }


        }
    }
