package info.whiled.javashogi.core.piece;

import info.whiled.javashogi.core.UserType;
import info.whiled.javashogi.core.board.Board;


abstract public class Piece {
    protected PiecePointer pointer;
    protected UserType userType;
    protected Board board;

    public Piece(int x, int y, UserType userType){
        pointer = new PiecePointer(x,y);
        this.userType = userType;
    }

    abstract public PieceType getPieceType();

    abstract public boolean canMove(int x, int y);

    public boolean canPut(int x, int y){
        return board.getPiece(x,y) == null ? true:false;
    }

    public void move(int x, int y){
        pointer.set(x,y);
    }

    public UserType getUserType(){
        return userType;
    }

    public void setUserType(UserType userType){
        this.userType = userType;
    }
    public void setBoard(Board board){
        this.board = board;
    }
}
