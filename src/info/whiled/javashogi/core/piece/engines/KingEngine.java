package info.whiled.javashogi.core.piece.engines;

import info.whiled.javashogi.core.UserType;
import info.whiled.javashogi.core.piece.PieceEngine;
import info.whiled.javashogi.core.piece.PiecePointer;

import java.util.ArrayList;
import java.util.List;

/**
 * 王将の動きを作るクラス
 * @author whiled
 */
public class KingEngine extends PieceEngine{

    private final static int nextPattern = 8;
    private final static int[] nextX = {0, 1, 1, 1, 0, -1, -1, -1};
    private final static int[] nextY = {1, 1, 0, -1, -1, -1, 0, 1};

    public KingEngine(int x, int y, UserType userType) {
        super(x, y, userType);
    }

    @Override
    protected void generateNextPointer(){
        List<PiecePointer> next = new ArrayList<>();
        for (int i=0; i<nextPattern; i++){
            if (pointer.getX() + nextX[i] < 0 || pointer.getY() + nextY[i] < 0) continue;
            if (pointer.getX() + nextX[i] > 8 || pointer.getY() + nextY[i] > 8) continue;
            next.add(new PiecePointer(pointer.getX() + nextX[i], pointer.getY() + nextY[i]));
        }
        this.nextPointers = next;
    }
}
