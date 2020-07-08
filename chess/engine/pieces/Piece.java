package chess.engine.pieces;

import chess.engine.Alliance;
import chess.engine.board.Board;
import chess.engine.board.Move;

import java.util.List;

public abstract class Piece {
    protected final int piecePosition;
    protected final Alliance pieceAllience;

    Piece(final int piecePosition, final Alliance pieceAllience) {
        this.piecePosition = piecePosition;
        this.pieceAllience = pieceAllience;
    }

    //Get legal moves for this piece
    public abstract List<Move> calculateLegalMoves(final Board board);
}
