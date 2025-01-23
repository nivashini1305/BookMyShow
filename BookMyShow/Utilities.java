package BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;

public class Utilities {
    public static HashMap<Character,ArrayList<String>> generateGrid(int seats,String grids){
        var gridString=grids.split("\\*");//for eg.(2*3*2) is the seat grid then splits and stores it in a string array like[2,3,2]
        int sumOfGrids=0;
        for(String individualGrids:gridString){
           sumOfGrids+=Integer.parseInt(individualGrids);
        }
        if(seats % sumOfGrids == 0){
            HashMap<Character,ArrayList<String>> seatAndGrid=new HashMap<>();
            char alphabet='A';
            while(seats>0){
                ArrayList<String> arrangingSeats=new ArrayList<>();
                for(int col=0;col<gridString.length;col++){
                    int noOfSeatsInEachGrid=Integer.parseInt(gridString[col]);
                    for(int i=0;i<noOfSeatsInEachGrid;i++){
                        arrangingSeats.add(" * ");
                    }
                    if(col<gridString.length-1){
                        arrangingSeats.add("<SPACE>");
                    }
                }
                seatAndGrid.put(alphabet,arrangingSeats);
                alphabet++;
                seats=seats-sumOfGrids;

            }
            return seatAndGrid;
        }
        System.out.println("The seats does not match the grid");
        return null;
    }
}
