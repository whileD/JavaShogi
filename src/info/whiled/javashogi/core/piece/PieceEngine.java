package info.whiled.javashogi.core.piece;

import info.whiled.javashogi.core.UserType;
import info.whiled.javashogi.core.board.Board;

import java.util.List;


abstract public class PieceEngine {
    protected UserType userType;
    protected PiecePointer pointer;
    protected Board board;

    public PieceEngine(int x, int y, UserType userType) {
        this.pointer = new PiecePointer(x, y);
        this.userType = userType;
    }

    public void setBoard(Board board){
        this.board = board;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UserType getUserType() {
        return userType;
    }

    public void move(int x, int y) {
        pointer.set(x,y);
    }

    abstract protected boolean canMove(int x, int y);
}
