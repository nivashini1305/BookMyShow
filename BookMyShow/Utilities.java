package BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;

public class Utilities {
    public static HashMap<Character,ArrayList<String>> generateSeat(int seats,String grids){
        String[] gridString=grids.split("\\*");//for e.g.(2*3*2) is the seat grid then splits and stores it in a string array list[2,3,2]
        int sumOfGrids=0;
        for(String individualGrids:gridString){
           sumOfGrids+=Integer.parseInt(individualGrids);//adding total number of seats in a row
        }
        if(seats % sumOfGrids == 0){
            HashMap<Character,ArrayList<String>> seatAndGrid=new HashMap<>();// local hashMap
            char alphabet='A';// char A to move seat number from A - Z
            while(seats>0){
                ArrayList<String> arrangingSeats=new ArrayList<>();//ArrayList to store the seats
                for(int col=0;col<gridString.length;col++){// column to loop no of input given eg: if 2*8 then 2 times if 2*6*2 then 3 times
                    int noOfSeatsInEachGrid=Integer.parseInt(gridString[col]);//converts the string list elements to integer
                    for(int i=0;i<noOfSeatsInEachGrid;i++){// loop  each element
                        arrangingSeats.add(" * ");
                    }
                    if(col<gridString.length-1){ // to give space after each column but not for the last column
                        arrangingSeats.add("<SPACE>");
                    }
                }
                seatAndGrid.put(alphabet,arrangingSeats);//adds the character and seats  to the hashMap
                alphabet++;// increase the alphabet everytime to get unique set of seats
                seats=seats-sumOfGrids;// decrease the seats that has been added already everytime

            }
            return seatAndGrid;//returns hashMap
        }
        System.out.println("The seats does not match the grid");
        return null;//returns null if the grid doesn't match
    }
}
