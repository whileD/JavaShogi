package info.whiled.javashogi.core.piece;

import java.util.List;


public interface PieceEngine {
    List<PiecePointer> getNextPointers();
    PiecePointer getPiecePointer();
    void move(PiecePointer pointer);
}
