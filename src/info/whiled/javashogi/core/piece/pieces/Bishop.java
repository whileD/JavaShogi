package info.whiled.javashogi.core.piece.pieces;

import info.whiled.javashogi.core.UserType;
import info.whiled.javashogi.core.piece.Piece;
import info.whiled.javashogi.core.piece.PieceType;

public class Bishop extends Piece{
    private static final PieceType PIECE_TYPE = PieceType.BISHOP;
    private static final int[] NEXT_X = {-1, 1, 1, -1};
    private static final int[] NEXT_Y = {1, 1, -1, -1};

    public Bishop(int x, int y, UserType userType) {
        super(x, y, userType);
    }

    @Override
    public PieceType getPieceType() {
        return PIECE_TYPE;
    }

    @Override
    public boolean canMove(int x, int y) {
        int nx, ny;
        for (int i=0; i<NEXT_X.length; i++){
            nx = pointer.getX() + NEXT_X[i];
            ny = pointer.getY() + NEXT_Y[i];
            if (nx < 0 || 2 < nx) continue;
            if (ny < 0 || 3 < ny) continue;
            if (nx != x || ny != y) continue;
            if (board.getPiece(nx,ny) == null ||
                    board.getPiece(nx,ny).getUserType() != userType) return true;

        }
        return false;
    }
}
