package info.whiled.javashogi.core.piece.pieces;

import info.whiled.javashogi.core.UserType;
import info.whiled.javashogi.core.piece.Piece;
import info.whiled.javashogi.core.piece.PieceType;

public class King extends  Piece{
    private static final PieceType PIECE_TYPE = PieceType.KING;
    private final static int[] nextX = {0, 1, 1, 1, 0, -1, -1, -1};
    private final static int[] nextY = {1, 1, 0, -1, -1, -1, 0, 1};

    public King(int x, int y, UserType userType) {
        super(x, y, userType);

    }

    @Override
    public PieceType getPieceType() {
        return PIECE_TYPE;
    }

    @Override
    public boolean canMove(int x, int y) {
        int nx, ny;
        for (int i=0; i<nextX.length; i++){
            nx = pointer.getX() + nextX[i];
            ny = pointer.getY() + nextY[i];
            if (nx < 0 || 2 < nx) continue;
            if (ny < 0 || 3 < ny) continue;
            if (nx != x || ny != y) continue;
            if (board.getPiece(nx,ny) == null ||
                    board.getPiece(nx,ny).getUserType() != userType) return true;

        }
        return false;
    }
}
