package info.whiled.javashogi.core.piece.pieces;

import info.whiled.javashogi.core.piece.*;
import info.whiled.javashogi.core.piece.engines.GoldGeneralEngine;

import java.util.List;

public class Pawn implements Piece, Promotional{
    private PieceEngine engine;
    private PieceType type = PieceType.PAWN;

    @Override
    public void move(PiecePointer pointer) {

    }

    @Override
    public List<PiecePointer> getNextPointers() {
        return null;
    }

    @Override
    public PieceType getPieceType() {
        return null;
    }

    @Override
    public void promote() {
        engine = new GoldGeneralEngine(engine.getPiecePointer());
    }
}
