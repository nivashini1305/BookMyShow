package BookMyShow.Interfaces;

import BookMyShow.AdminActions;
import BookMyShow.Screen;

import java.util.HashMap;

public interface AdminActionInterface extends Actions {
    void addLocation();
    void addTheatre(AdminActions adminActions);
    void addScreens(HashMap<String, Screen> hashScreen);
    void addMovies();
    void viewTheatre();
    void viewMovie();
}
