package chess.engine.board;

import chess.engine.pieces.Piece;

import java.util.HashMap;
import java.util.Map;

public abstract class Tile {

    //Abstract class properties
    protected final int tileCoordinate;
    private static final Map<Integer, EmptyTile> EMPTY_TILES = createBoard();


    //Constructor
    Tile(int tileCoordinate){
        this.tileCoordinate = tileCoordinate;
    }

    //Create empty board
    private static Map<Integer, EmptyTile> createBoard() {
        final Map<Integer, EmptyTile> emptyBoard = new HashMap<>();
        for(int i = 1;i <= 64;i++){
            emptyBoard.put(i, new EmptyTile(i));
        }
        return emptyBoard;
    }

    //is tile occupied
    public abstract boolean isTileOccupied();

    //Piece on tile
    public abstract Piece getPiece();




    //Empty tile child class
    private static final class EmptyTile extends Tile{
        EmptyTile(int cooridnate) {
            super(cooridnate);
        }

        @Override
        public boolean isTileOccupied(){
            return false;
        }

        @Override
        public Piece getPiece(){
            return null;
        }
    }



    //Occupied tile child class
    private static final class OccupiedTile extends Tile{

        private final Piece pieceOnTile;

        OccupiedTile(int cooridnate, Piece pieceOnTile) {
            super(cooridnate);
            this.pieceOnTile = pieceOnTile;
        }

        @Override
        public boolean isTileOccupied(){
            return true;
        }

        @Override
        public Piece getPiece(){
            return this.pieceOnTile;
        }
    }
}
