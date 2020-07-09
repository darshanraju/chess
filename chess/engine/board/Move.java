package chess.engine.board;

import chess.engine.pieces.Piece;

public abstract class Move {

    final Board board;
    final Piece movedPiece;
    final int destinationCoordinate;

    private Move(final Board board, final Piece movedPiece, int destinationCoordinate){
        this.board = board;
        this.movedPiece = movedPiece;
        this.destinationCoordinate = destinationCoordinate;
    }


    public static final class NeutralMove extends Move {

        public NeutralMove(final Board board, final Piece movedPiece, int destinationCoordinate){
            super(board, movedPiece, destinationCoordinate);
        }
    }

    public static final class AttackingMove extends Move {

        final Piece attackedPiece;

        public AttackingMove(final Board board, final Piece movedPiece, int destinationCoordinate, Piece attackedPiece){
            super(board, movedPiece, destinationCoordinate);
            this.attackedPiece = attackedPiece;
        }
    }
}
