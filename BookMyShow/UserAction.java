package BookMyShow;
import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
public class UserAction {
    public static User userLogin(Scanner s) {
        System.out.print("Enter the User name:");
        String userName = s.nextLine();//Enters the users name
        System.out.print("Enter the User pin:");
        String userPin = s.nextLine();//Enters the users pin
        for (User user : BookMyShow.getUsers()) {
            if (user.getUserId().equals(userName) && user.getUserPin().equals(userPin)) {//checks the users id and users pin
                return user;
            } else if (user.getUserId().equals(userName) && !user.getUserPin().equals(userPin)) {//checks the admin id is equal and admin pin is wrong
                return new User(null, null, null);
            }
        }
        return null;
    }

    public static void register(Scanner s) {//method for the user register to book tickets
        System.out.print("Enter the User name:");
        String userNameToRegister = s.nextLine();
        System.out.print("Enter the User pin:");
        String userPinToRegister = s.nextLine();
        System.out.print("Enter the User Location:");
        String location = s.nextLine();
        BookMyShow.getUsers().add(new User(userNameToRegister, userPinToRegister, location));//adds the user name,pin and location to the arrayList
        System.out.println("Registered successfully");

    }

    public static void displayMovie(Scanner s, User currentUser) {
        LocalDate currentDate = LocalDate.now();//displays the current date
        LocalDate selectedDate = currentDate;//the currentDate will be the selected date firstly for the booking tickets
        label:
        while (true) {
            System.out.println("Current Date:" + currentDate.format(BookMyShow.getFormatter()));//prints the current date with given format of the date
            System.out.println("Selected date:" + selectedDate.format(BookMyShow.getFormatter()));//prints the selected date with given format of the date
            System.out.println("Current location :" + currentUser.getLocation());//prints the current location of the user
            var movie = BookMyShow.getMovies().keySet();//gets all the keys of the movies hashMap
            boolean check = false;
            System.out.println("Available movies...");
            for (String movieName : movie) {//takes each movieObj from the keySet
                boolean check2 = false;
                for (var movies : BookMyShow.getMovies().get(movieName)) {//gets the movie object by passing the key
                    if (movies.getLocation().equals(currentUser.getLocation()) && movies.getDate().isEqual(selectedDate)) {//checks the user location and the location of the movie and also the date
                        check = true;
                        check2 = true;
                    }
                }
                if (check2) {
                    System.out.println("->" + movieName);//prints the movie
                }
            }
            if (!check) {//if no movies was found then the check becomes null
                System.out.println("No Movies found");
                System.out.print("Do you want to change the preferences of location or date(yes/no):");//then asks to change the preference of the location
                String preference = s.nextLine();
                if (preference.equals("yes")) {
                    LocalDate date = UserAction.preferences(currentUser,currentDate);//calls the preferences methods
                    if (date != null) {
                        selectedDate = date;
                    }
                } else if (preference.equals("no")) {
                    return;//if no,returns to the method call
                }

            }
            if (check) {
                System.out.print("Do you want to Book (type 'book') or need to change the Preferences of Location or Date(type 'change') or Exit(type 'exit'):");// if the movies were available asks the user to book the tickets or to change the preferences or to exit
                String preferences = s.nextLine();
                if (preferences.equals("book")) {
                    System.out.print("Enter the movie:");
                    String selectMovie = s.nextLine();
                    ArrayList<Movies> movieObjects = new ArrayList<>();//stores the movie Objects in a arrayList
                    for (Movies movies : BookMyShow.getMovies().get(selectMovie)) {// each objects of the selected movie  are stored in movies
                        if (movies.getLocation().equals(currentUser.getLocation()) && movies.getDate().isEqual(currentDate)) {//checks the movie location and date is equal to the users location amd the currentDate
                            movieObjects.add(movies);//movie objects are added to the arrayList
                        }
                    }
                    int returnedValue=UserAction.AvailableTheatresAndBookTickets(movieObjects,currentUser);//after checking,method calls to book the ticket
                    if(returnedValue==1){
                        return;
                    }
                } else if (preferences.equals("change")) {
                    LocalDate date = UserAction.preferences(currentUser,currentDate);//if the option chooses to change the preferences...it calls the preferences method
                    if (date != null) {
                        selectedDate = date;
                    }
                } else if (preferences.equals("exit")) {
                    return;//returns to the login method
                }
                else{
                    System.out.println("Enter correct input..");
                }
            }
        }
    }

    public static int AvailableTheatresAndBookTickets(ArrayList<Movies> movies,User currentUser) {
        Scanner s = new Scanner(System.in);

        HashMap<String, HashSet<Show>> theatreAndShows = new HashMap<>();//local hashMap which sets theatre name as key and hashset of shows as value
        String movieName=null;
        for (Movies movieObj : movies) {
            if (theatreAndShows.containsKey(movieObj.getTheatre().getTheatreName())) {//here the containsKey method checks the movie's theatre object is in the hashMap
                theatreAndShows.get(movieObj.getTheatre().getTheatreName()).add(movieObj.getShow());//adds the show of the movie
                movieName=movieObj.getMovieName();//assigns movie name
            } else {
                HashSet<Show> shows = new HashSet<>();
                shows.add(movieObj.getShow());//adds the show object
                theatreAndShows.put(movieObj.getTheatre().getTheatreName(), shows);//adds theatre name and show object
                movieName=movieObj.getMovieName();//assigns the movie name to the movieName variable
            }
        }
        System.out.println("Available theatres: ");
        for (String theatreName : theatreAndShows.keySet()) {//keySet of theatreAndShow are looped
            System.out.println("Theatre Name:" + theatreName);
            System.out.println("Available shows:");
            for (Show show : theatreAndShows.get(theatreName)) {//gets the value of the theatreName from the theatreAndShows HashMap which means shows
                System.out.println("->" + show.getStartTime());
            }
        }
        Show currentShow = null;
        String theatreNameToBook = null;
        while (true) {
            System.out.print("Enter the theatre name : ");
            theatreNameToBook = s.nextLine();
            if (!theatreAndShows.containsKey(theatreNameToBook)) {//checks if the hashMap doesn't contain any theatre name
                System.out.println("Theatre not available");
                continue;
            }
            break;
        }
        while (true) {
            System.out.print("Enter the show time:");
            LocalTime showTimeToBook = LocalTime.parse(s.nextLine(), BookMyShow.getTimeFormatter());//gets date as input in the dd-mm-yyyy
            for (Show show : theatreAndShows.get(theatreNameToBook)) {
                if (show.getStartTime().equals(showTimeToBook)) {//checks the showtime equals to show Object
                    currentShow = show;//assigns the show object to the currentShow
                    break;
                }
            }
            if (currentShow == null) {
                System.out.println("Show Time is unavailable to book...Please enter another show time");
                continue;
            }
            break;
        }
        for (var seats : currentShow.getShowSeat().entrySet()) {//gives the key and value of currentShow's seat
            System.out.println(seats.getKey() + " " + seats.getValue());
        }
        System.out.println("Enter how many seats to book:");
        int bookingSeats = Integer.parseInt(s.nextLine());
        long totalPrice=bookingSeats* currentShow.getPrice();//calculates the price for the total number of tickets
        HashMap<Character, ArrayList<String>> duplicateSeats = new HashMap<>();//sets the duplicate hashMap
        for (var keyAndValue : currentShow.getShowSeat().entrySet()) {//loop over a hashMap which takes both key and value
            duplicateSeats.put(keyAndValue.getKey(), new ArrayList<>());//adds the key and value to the hashmap
            duplicateSeats.get(keyAndValue.getKey()).addAll(keyAndValue.getValue());//adds the value to the arrayList of the hashmap
        }
        ArrayList<String> allSeatNumbers = new ArrayList<>();//local hashMap foe booking seats
        for (int i = 0; i < bookingSeats; i++) {//loop to book the no.of seats
            while (true) {
                System.out.println("Enter the seat number to book(e.g. A1,A2,...)");
                String seatsToBook = s.nextLine();
                char rowName = seatsToBook.charAt(0);//seat numbers are given like A1,A2,...,B1,B2,...  This line takes the character at the first index
                int seatNo = Integer.parseInt(seatsToBook.substring(1));//takes the remaining substring of the seatNumber e.g. if the seat number A10,it takes the integer 10
                ArrayList<String> bookingSeat = duplicateSeats.get(rowName);//it gives the value of the key which means the arrayList of string
                String grid = currentShow.getScreen().getGrid();//currentShow's grid
                String[] gridString = grid.split("\\*");//splitting the grid using regex
                int sumOfGrids = 0;
                for (String eachGrid : gridString) {
                    sumOfGrids += Integer.parseInt(eachGrid);//adding total number of seats in a row
                }
                int totalElement = (sumOfGrids + 2 - Integer.parseInt(gridString[2])) - 1;//calculates the seat number as per index
                if (seatNo <= Integer.parseInt(gridString[0])) {//Books the seat as per the first grid
                    if (bookingSeat.get(seatNo - 1).equals("X")) {
                        System.out.println("Seat Already booked...Enter another seat number to book");
                        continue;
                    }
                    bookingSeat.set(seatNo - 1, "X");
                    System.out.println(rowName + " " + bookingSeat);
                    allSeatNumbers.add(seatsToBook);

                } else if (seatNo >= totalElement) {//Books the seat as per the second grid
                    if (bookingSeat.get(seatNo + 1).equals("X")) {
                        System.out.println("Seat Already booked...Enter another seat number to book");
                        continue;
                    }
                    bookingSeat.set(seatNo + 1, "X");
                    System.out.println(rowName + " " + bookingSeat);
                    allSeatNumbers.add(seatsToBook);
                } else {//Books the seat as per the third grid
                    if (bookingSeat.get(seatNo).equals("X")) {
                        System.out.println("Seat Already booked...Enter another seat number to book");
                        continue;
                    }
                    bookingSeat.set(seatNo, "X");
                    System.out.println(rowName + " " + bookingSeat);
                    allSeatNumbers.add(seatsToBook);
                }
                break;
            }

        }
        while (true) {//loop to confirm the tickets
            System.out.println("Confirming the total price of the booked tickets:"+totalPrice);
            System.out.print("Confirm your Tickets(yes/no):");
            String confirmation = s.nextLine();
            if (confirmation.equals("yes")) {
                currentShow.setShowSeat(duplicateSeats);//sets the duplicate seat booking to the currentShow
                System.out.println("Tickets booked successfully...");
                break;
            } else if (confirmation.equals("no")) {
                return 0;
            } else {
                System.out.println("Enter correctly");
            }
        }
        currentUser.getTickets().add(new Tickets(theatreNameToBook,currentShow.getScreen().getScreenName(),currentShow.getStartTime(), movieName,allSeatNumbers,currentShow.getShowDate(), totalPrice));//all the objects added to the ticket
        while(true){
        System.out.println("Do you want to\n1.Continue booking\n2.View tickets\n3.Exit ");
        int option=Integer.parseInt(s.nextLine());
        switch (option) {
            case 1:
                return 0;
            case 2:
                UserAction.viewTickets(currentUser);//calls the view Ticket method
                continue;
            case 3:
                return 1;
        }
        }
    }
    private static LocalDate preferences(User currentUser,LocalDate currentDate){
        Scanner s=new Scanner(System.in);
        System.out.println("Do you want to \n1.Change the location \n2.Change the date\n3.Exit");
        int chooseOption = Integer.parseInt(s.nextLine());
        switch (chooseOption) {
            case 1:
                System.out.println("Enter the Location to book movie:");
                String changeLocation = s.nextLine();
                currentUser.setLocation(changeLocation);//sets the new location
                return null;
            case 2:
                LocalDate changeDate = null;
                while (true)
                {
                    System.out.println("Enter the Date to book the ticket:");
                    changeDate = LocalDate.parse(s.nextLine(), BookMyShow.getFormatter());//gets date as input
                    if(changeDate.isBefore(currentDate))//checks the change date is before the currentDate
                    {
                        System.out.println("Enter upcoming dates..");//prints as enter the upcoming dates
                        continue;
                    }
                    break;
                }

                System.out.println("The changed date to book:" + changeDate.format(BookMyShow.getFormatter()));
                return changeDate;//returns the changed date
            case 3:
                System.out.println("Exiting");
                return null;
        }
        return null;
    }
    public static void viewTickets(User currentUser){
        ArrayList<Tickets> tickets=currentUser.getTickets();//ticket objects are stored in the variable ticket
        System.out.println("Booked details of the user "+currentUser.getUserId());
        for(Tickets ticketObj:tickets){//loops all the ticket object
            System.out.println("Theatre Name:"+ticketObj.getTheatreName());
            System.out.println("Tickets Name:"+ticketObj.getBookedTickets());
            System.out.println("Screen Name:"+ticketObj.getScreenName());
            System.out.println("Show Time of the movie:"+ticketObj.getShowTime());
            System.out.println("Show Date of the Movie:"+ticketObj.getShowDate().format(BookMyShow.getFormatter()));
            System.out.println("Movie Name:"+ticketObj.getMovieName());
            System.out.println("Price of the ticket:"+ticketObj.getPrice());
            return;
        }
    }
}

