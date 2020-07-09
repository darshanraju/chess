package chess.engine.pieces;

import chess.engine.Alliance;
import chess.engine.board.Board;
import chess.engine.board.Move;
import chess.engine.board.Tile;
import chess.engine.board.Move.*;
import java.util.ArrayList;
import java.util.List;

import static chess.engine.board.BoardUtils.*;


public class Knight extends Piece{

    //Available moves from current position
    private final static int[] CANDIDATE_MOVE_COORDINATES = { -17, -15, -10, -6, 6, 10, 15, 17 };


    Knight(final int piecePosition, final Alliance pieceAllience) {
        super(piecePosition, pieceAllience);
    }

    @Override
    public List<Move> calculateLegalMoves(final Board board) {
        int DestinationCoordinate;
        final List<Move> legalMoves = new ArrayList<>();

        for(final int currentCandidate: CANDIDATE_MOVE_COORDINATES){
            //Get Possible Position
            DestinationCoordinate = this.piecePosition + currentCandidate;

            //If new position is on board
            if(distanceFromDestinationTile(this.piecePosition, DestinationCoordinate) == 3 && tileExists(DestinationCoordinate)){
                final Tile DestinationTile = board.getTile(DestinationCoordinate);

                //If the tile is empty
                if(!DestinationTile.isTileOccupied()){
                    legalMoves.add(new NeutralMove(board, this, DestinationCoordinate));
                } else {
                    final Piece pieceAtDestination = DestinationTile.getPiece();

                    //Attacking another piece
                    if(pieceAtDestination.pieceAllience != this.pieceAllience){
                        legalMoves.add(new AttackingMove(board, this, DestinationCoordinate, pieceAtDestination));
                    }
                }
            }
        }

    return legalMoves;
    }

    public static void main(String[] args) {
        int coord = 25;
        System.out.print("Starting at: "+intToMatrixMap(coord)+"\n");
        for (final int currentCandidate : CANDIDATE_MOVE_COORDINATES) {
            //Get Possible Position
            int DestinationCoordinate = coord + currentCandidate;

            //If new position is on board
            if (distanceFromDestinationTile(coord, DestinationCoordinate) == 3 && tileExists(DestinationCoordinate)) {
                System.out.println(intToMatrixMap(DestinationCoordinate));
            }
        }
    }
}
