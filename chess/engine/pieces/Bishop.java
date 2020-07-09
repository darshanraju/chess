package chess.engine.pieces;

import chess.engine.Alliance;
import chess.engine.board.Board;
import chess.engine.board.Move;
import chess.engine.board.Tile;

import java.util.ArrayList;
import java.util.List;



import static chess.engine.board.BoardUtils.*;

public class Bishop extends Piece{

    private final static int[] CANDIDATE_MOVE_DIRECTIONS = { -9, -7, 7, 9};

    Bishop(final int piecePosition, final Alliance pieceAllience){
        super(piecePosition, pieceAllience);
    }

    @Override
    public List<Move> calculateLegalMoves(Board board) {
        final List<Move> legalMoves = new ArrayList<>();
        /*
        Check in all 4 diagaonal positions. Stop when you hit end of board, your own alliance or
        enemy alliance (include the enemy aliance pawn as a move)
        */
        for(int direction:CANDIDATE_MOVE_DIRECTIONS){
            legalMoves.addAll(directionalTileChecker(board, this.piecePosition, direction));
        }
        return  legalMoves;
    }

    private List<Move> directionalTileChecker(Board board, int currentPosition, int direction){
        List<Move> legalMoves = new ArrayList<>();
        if(leftBoundaryExclusion(currentPosition, direction) || rightBoundaryExclusion(currentPosition, direction)){
            return legalMoves;
        }
        int nextPosition = currentPosition + direction;
        while(tileExists(nextPosition)){

            if(leftBoundaryExclusion(nextPosition, direction) || rightBoundaryExclusion(nextPosition, direction)){
                return legalMoves;
            }
            Tile destinationTile = board.getTile(nextPosition);

            //Empty Destination Tile
            if(!destinationTile.isTileOccupied()){
                legalMoves.add(new Move.NeutralMove(board, this,
                        nextPosition));
                nextPosition += direction;
            }//Enemy Alliance on destination Tile. Add to moves and break out of loop
            else if(destinationTile.getPiece().pieceAllience != this.pieceAllience){
                legalMoves.add(new Move.AttackingMove(board, this,
                        nextPosition, destinationTile.getPiece()));
                break;
            }//If Own Alliance on destination file. Break out of loop
            else{
                break;
            }
        }
        return legalMoves;
    }

    private static boolean leftBoundaryExclusion(int coordinate, int direction){
        return (coordinate - 1) % 8 == 0 && (direction == -9 || direction == 7);
    }

    private static boolean rightBoundaryExclusion(int coordinate, int direction){
        return (coordinate % 8) == 0 && (direction == -7 || direction == 9);
    }
}
