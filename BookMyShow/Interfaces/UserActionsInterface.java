package BookMyShow.Interfaces;

import BookMyShow.Movies;
import BookMyShow.User;

import java.time.LocalDate;
import java.util.ArrayList;

public interface UserActionsInterface extends Actions {
    void register();
    void displayMovie(User currentUser);
    int availableTheatresAndBookTickets(ArrayList<Movies> movies, User currentUser);
    LocalDate preferences(User currentUser, LocalDate currentDate);
    void viewTickets(User currentUser);
}
