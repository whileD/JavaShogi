package info.whiled.javashogi.core.piece;

public class PiecePointer {
    private int x;
    private int y;

    public PiecePointer(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
