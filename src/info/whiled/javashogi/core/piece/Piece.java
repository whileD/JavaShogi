package info.whiled.javashogi.core.piece;

import java.util.List;

public interface Piece {
    void move(PiecePointer pointer);
    List<PiecePointer> getNextPointers();
    PieceType getPieceType();
}
