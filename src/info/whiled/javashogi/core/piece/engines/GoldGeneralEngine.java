package info.whiled.javashogi.core.piece.engines;

import info.whiled.javashogi.core.UserType;
import info.whiled.javashogi.core.piece.Piece;
import info.whiled.javashogi.core.piece.PieceEngine;
import info.whiled.javashogi.core.piece.PiecePointer;

import java.util.ArrayList;
import java.util.List;

public class GoldGeneralEngine extends PieceEngine {
    public GoldGeneralEngine(int x, int y, UserType userType) {
        super(x, y, userType);
    }

    @Override
    public List<PiecePointer> getNextPointers() {
        return null;
    }

    @Override
    protected void generateNextPointer() {
        nextPointers.clear();
        if (pointer.getX() + 1 < 9) nextPointers.add(new PiecePointer(pointer.getX() + 1, pointer.getY()));
        if (pointer.getX() - 1 >= 0) nextPointers.add(new PiecePointer(pointer.getX() - 1, pointer.getY()));
        if (pointer.getY() + 1 < 9) nextPointers.add(new PiecePointer(pointer.getX(), pointer.getY() + 1));
        if (pointer.getY() - 1 >= 0) nextPointers.add(new PiecePointer(pointer.getX(), pointer.getY() - 1));
        switch (userType){
            case USER:
                if (pointer.getX() + 1 < 9 && pointer.getY() + 1 < 9) nextPointers.add(new PiecePointer())
        }
    }
}
