package chess.engine.pieces;

import chess.engine.Alliance;
import chess.engine.board.Board;
import chess.engine.board.Move;
import chess.engine.board.Tile;

import java.util.ArrayList;
import java.util.List;

import static chess.engine.board.BoardUtils.distanceFromDestinationTile;
import static chess.engine.board.BoardUtils.tileExists;

public class Knight extends Piece{

    //Available moves from current position
    private final static int[] CANDIDATE_MOVE_COORDINATES = { -17, -15, -10, -6, 6, 10, 15, 17 };


    Knight(final int piecePosition, final Alliance pieceAllience) {
        super(piecePosition, pieceAllience);
    }

    @Override
    public List<Move> calculateLegalMoves(Board board) {
        int DestinationCoordinate;
        final List<Move> legalMoves = new ArrayList<>();

        for(final int currentCandidate: CANDIDATE_MOVE_COORDINATES){
            //Get Possible Position
            DestinationCoordinate = this.piecePosition + currentCandidate;

            //If new position is on board
            if(distanceFromDestinationTile(this.piecePosition, DestinationCoordinate) == 3 && tileExists(DestinationCoordinate)){
                final Tile candidateDestinationTile = board.getTile(DestinationCoordinate);
                //If the tile is empty
                if(!candidateDestinationTile.isTileOccupied()){
                    legalMoves.add(new Move());
                } else {
                    final Piece pieceAtDestination = candidateDestinationTile.getPiece();
                    if(pieceAtDestination.pieceAllience != this.pieceAllience){
                        legalMoves.add(new Move());
                    }
                }
            }
        }

    return legalMoves;
    }
}
