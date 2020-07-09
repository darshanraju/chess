package chess.engine.board;

import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math.*;

public class BoardUtils {

   private BoardUtils(){
        throw new RuntimeException("Cannot instantiate boardUtils");
    }

    public static int distanceFromDestinationTile(int startingCoordinate, int destinationCoordinate){
        List<Integer> startingTile = intToMatrixMap(startingCoordinate);
        List<Integer> destinationTile = intToMatrixMap(destinationCoordinate);
        int rowDifference = Math.abs(startingTile.get(0) - destinationTile.get(0));
        int colDifference = Math.abs(startingTile.get(1) - destinationTile.get(1));
        int distance = rowDifference + colDifference;
        return distance;
    }

    public static List<Integer> intToMatrixMap(int coordinate){
       int row;
       int col;
       final List<Integer> coord = new ArrayList<>();
       if(coordinate%8 == 0){
           row = coordinate/8;
           col = 8;
       } else {
           row = (coordinate/8);
           col = coordinate - (8*row);
           row += 1;
       }
       coord.add(row);
       coord.add(col);
       return coord;
    }

    public static boolean tileExists(int destinationCoordinate){
       if(destinationCoordinate >= 1 && destinationCoordinate <= 64){
           return true;
       }
       return false;
    }

    public static void main(String[] args) {
        System.out.print(intToMatrixMap(15));
    }
}
