public abstract class Tile {

    int tileCoordinate;

    Tile(int tileCoordinate){
        this.tileCoordinate = tileCoordinate;
    }

    //is tile occupied
    public abstract boolean isTileOccupied();

    //Piece on tile
    public abstract Piece getPiece();

    //Empty tile child class
    public static final class EmptyTile extends Tile{
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
    public static final class OccupiedTile extends Tile{

        Piece pieceOnTile;

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
