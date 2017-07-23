package info.whiled.javashogi.scene;

import javafx.scene.shape.Rectangle;

/**
 * Created by whiled on 17/07/14.
 */
public class BoardSquare extends Rectangle {
    public static final int CELL_SIZE = 30;
    public BoardSquare(int i, int j) {
        super(i*CELL_SIZE, j*CELL_SIZE, CELL_SIZE, CELL_SIZE);
    }
}
