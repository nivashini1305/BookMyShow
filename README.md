
https://github.com/user-attachments/assets/fdbc059d-d4c8-47bc-aec4-ff2fb1f2f671
# Book My Show 

A comprehensive Java-based console application that simulates a movie ticket booking system. This project allows admins to manage theatres, screens, and movie schedules, while users can register, book tickets, and manage their preferences.

---

## Class Diagram

![Book My Show](https://github.com/user-attachments/assets/efdb0edd-8e20-4c8c-9f3f-818e711c2647)

## Output Preview

https://github.com/user-attachments/assets/8f767db9-da5b-4e47-8dad-07c0cb7ac99f


## Features

### Admin Operations
Admins can perform the following actions:
- **Admin Login**: Secure access for admins using `adminLogin()`.
- **Add Location**: Add or update locations using `addLocation()`.
- **Add Theatre**: Configure theatres within locations using `addTheatre()`.
- **Add Screens**: Set up screens in theatres using `addScreens()`.
- **Add Movies**: Schedule movies for theatres using `addMovie()`.
- **View Theatres**: Retrieve details of existing theatres with `viewTheatre()`.
- **View Movies**: List scheduled movies using `viewMovie()`.

### User Operations
Users have access to these features:
- **User Login and Registration**: Register a new user or log in to an existing account using `register()` and `userLogin()`.
- **Display Movies**: Browse available movies using `displayMovie()`.
- **Book Tickets**: Check theatre availability and book tickets using `AvailableTheatresAndBookTickets()`.
- **Set Preferences**: Set preferred location and movie preferences using `preferences()`.
- **View Tickets**: Check ticket details and booking history using `viewTickets()`.

---

## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/book-my-show.git
   cd BookMyShow
   ```
    ```bash
   javac MainClass.java
    ```
    ```bash
   java MainClass
    ```


## Project Structure
Core Classes
Main Class:

Entry point of the application: BookMyStart.start().
AdminActions Class:

Contains static methods for admin operations such as adminLogin(), addMovie(), and viewTheatre().
UserActions Class:

Contains static methods for user operations such as register(), bookTickets(), and viewTickets().
Utilities:

Helper methods such as generateSeats().



## POJO Classes
Theatre: Stores theatre details, including name, location, and associated screens.
Screen: Represents a screen in a theatre with fields for name, seat numbers, and show mapping.
Show: Represents a movie show with fields for start time, end time, price, and schedule.
Tickets: Stores ticket booking details like theatre name, screen name, show timing, and price.
Movies: Represents movie details such as name, duration, and associated theatre.


## How It Works
Admin Workflow:

Admin logs in using predefined credentials.
Admin performs actions like adding locations, configuring theatres, scheduling movies, and viewing details.
User Workflow:

New users register an account, while existing users log in.
Users can browse available movies, book tickets, and set preferences.


## Author

Nivashini R G
Mail:nivashinigovindaraj05@gmail.com
LinkedIn:https://www.linkedin.com/in/nivashini-govindaraj-7431a0316/
