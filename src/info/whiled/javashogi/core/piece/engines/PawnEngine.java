package info.whiled.javashogi.core.piece.engines;

import info.whiled.javashogi.core.piece.PieceEngine;
import info.whiled.javashogi.core.piece.PiecePointer;

import java.util.List;

public class PawnEngine implements PieceEngine {
    private PiecePointer pointer;

    private final static int nextPatter = 1;
    private final static int[] nextX = {0};
    private final static int[] nextY = {1};

    @Override
    public List<PiecePointer> getNextPointers() {
        return null;
    }

    @Override
    public PiecePointer getPiecePointer() {
        return null;
    }

    @Override
    public void move(PiecePointer pointer) {
        this.pointer = pointer;
        /**
         * promotion処理
         * boardに書くかはわからん
         */
    }
}
