package info.whiled.javashogi.core.piece.engines;

import info.whiled.javashogi.core.piece.PieceEngine;
import info.whiled.javashogi.core.piece.PiecePointer;

import java.util.ArrayList;
import java.util.List;

/**
 * 王将の動きを作るクラス
 * @author whiled
 */
public class KingEngine implements PieceEngine{
    private PiecePointer pointer;
    private List<PiecePointer> nextPointers;

    private final static int nextPattern = 8;
    private final static int[] nextX = {0, 1, 1, 1, 0, -1, -1, -1};
    private final static int[] nextY = {1, 1, 0, -1, -1, -1, 0, 1};

    public KingEngine(int x, int y){
        pointer = new PiecePointer(x, y);
        generateNextPointer();
    }

    @Override
    public List<PiecePointer> getNextPointers() {
        return nextPointers;
    }

    @Override
    public PiecePointer getPiecePointer() {
        return pointer;
    }

    @Override
    public void move(PiecePointer pointer) {
        this.pointer = pointer;
    }

    public void setPointer(PiecePointer pointer){
        this.pointer = pointer;
        generateNextPointer();
    }

    public PiecePointer getPointer() {
        return pointer;
    }

    private void generateNextPointer(){
        List<PiecePointer> next = new ArrayList<>();
        for (int i=0; i<nextPattern; i++){
            if (pointer.getX() + nextX[i] < 0 || pointer.getY() + nextY[i] < 0) continue;
            if (pointer.getX() + nextX[i] > 8 || pointer.getY() + nextY[i] > 8) continue;
            next.add(new PiecePointer(pointer.getX() + nextX[i], pointer.getY() + nextY[i]));
        }
        this.nextPointers = next;
    }
}
