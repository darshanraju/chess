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
       final List<Integer> coord = new ArrayList<>();
       int row = coordinate/8;
       int col = coordinate - (8*row);
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
        int dist = distanceFromDestinationTile(17 , 7);
        System.out.println(dist);
    }
}
