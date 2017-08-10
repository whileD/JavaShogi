package info.whiled.javashogi.core.piece;

public enum PieceType {
    KING("王"),
    ROOK("飛"),
    BISHOP("角"),
    PAWN("歩"),
    P_PAWN("と");


    private final String name;
    PieceType(String s) {
        name = s;
    }

    public String getName() {
        return name;
    }
}

