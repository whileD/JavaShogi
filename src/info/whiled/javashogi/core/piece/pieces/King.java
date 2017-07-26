package info.whiled.javashogi.core.piece.pieces;

import info.whiled.javashogi.core.UserType;
import info.whiled.javashogi.core.piece.Piece;
import info.whiled.javashogi.core.piece.PieceEngine;
import info.whiled.javashogi.core.piece.PiecePointer;
import info.whiled.javashogi.core.piece.PieceType;
import info.whiled.javashogi.core.piece.engines.KingEngine;

import java.util.List;

public class King implements Piece {
    private PieceEngine engine;
    private final PieceType type = PieceType.KING;

    public King(int x, int y, UserType userType){
        engine = new KingEngine(x,y, userType);
    }

    @Override
    public void move(PiecePointer pointer) {
        engine.move(pointer);
    }

    @Override
    public List<PiecePointer> getNextPointers() {
        return engine.getNextPointers();
    }

    @Override
    public PieceType getPieceType() {
        return type;
    }
}