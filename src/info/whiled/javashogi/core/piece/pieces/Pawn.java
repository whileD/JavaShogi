package info.whiled.javashogi.core.piece.pieces;

import info.whiled.javashogi.core.UserType;
import info.whiled.javashogi.core.piece.Piece;
import info.whiled.javashogi.core.piece.PieceType;

public class Pawn extends Piece {
    private PieceType pieceType = PieceType.PAWN;
    private static final int[] NEXT_X = {0, 0};
    private static final int[] NEXT_Y = {1, -1};
    private static final int[] PROMOTED_NEXT_X =  {0, 1, 0, -1, 1, -1, 1, -1};
    private static final int[] PROMOTED_NEXT_Y = {1, 0, -1, 0, 1, 1, -1, -1};

    public Pawn(int x, int y, UserType userType) {
        super(x, y, userType);
    }

    @Override
    public PieceType getPieceType() {
        return pieceType;
    }

    @Override
    public void move(int x, int y) {
        super.move(x, y);
        if (y == ((userType == UserType.USER)? 3:0 )) pieceType = PieceType.P_PAWN;
        if (x == 0 && y == 0) pieceType = PieceType.PAWN;
    }

    @Override
    public boolean canMove(int x, int y) {
        if (pieceType == PieceType.PAWN) return normalMove(x,y);
        else return promotedMove(x,y);
    }

    private boolean normalMove(int x, int y){
        int nx = pointer.getX() + ((userType == UserType.USER) ? NEXT_X[0] : NEXT_X[1]);
        int ny = pointer.getY() + ((userType == UserType.USER) ? NEXT_Y[0] : NEXT_Y[1]);
        if (nx < 0 || 2 < nx || ny < 0 || 3 < ny) return false;
        if (nx != x || ny != y) return false;
        if (board.getPiece(nx, ny) == null ||
                board.getPiece(nx, ny).getUserType() != userType) return true;
        return false;
    }

    private boolean promotedMove(int x, int y){
        int nx, ny;
        for (int i=0; i<PROMOTED_NEXT_X.length; i++){
            if (userType == UserType.USER && i >= 6) break;
            if (userType == UserType.RIVAL && (i == 4 || i == 5)) continue;
            nx = pointer.getX() + PROMOTED_NEXT_X[i];
            ny = pointer.getY() + PROMOTED_NEXT_Y[i];
            if (nx < 0 || 8 < nx) continue;
            if (ny < 0 || 8 < ny) continue;
            if (nx != x || ny != y) continue;
            if (board.getPiece(nx,ny) == null) return true;
            if (board.getPiece(nx,ny).getUserType() != userType) return true;
        }
        return false;
    }


}