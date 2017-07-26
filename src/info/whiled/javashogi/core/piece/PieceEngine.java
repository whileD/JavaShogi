package info.whiled.javashogi.core.piece;

import info.whiled.javashogi.core.UserType;

import java.util.List;


abstract public class PieceEngine {
    protected UserType userType;
    protected PiecePointer pointer;
    protected List<PiecePointer> nextPointers;

    public PieceEngine(int x, int y, UserType userType) {
        this.pointer = new PiecePointer(x, y);
        this.userType = userType;
    }

    public PiecePointer getPiecePointer() {
        return pointer;
    }

    public void move(PiecePointer pointer) {
        this.pointer = pointer;
        getPiecePointer();
    }

    public List<PiecePointer> getNextPointers() {
        return nextPointers;
    }

    abstract protected void generateNextPointer();
}
