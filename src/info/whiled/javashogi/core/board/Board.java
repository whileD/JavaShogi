package info.whiled.javashogi.core.board;

import info.whiled.javashogi.core.piece.Piece;
import info.whiled.javashogi.core.piece.pieces.King;

public class Board {
    private Piece[][] board;

    public Board(){
        initBoard();
    }

    public void initBoard(){
        board = new Piece[9][9];
        board[0][4] = new King(0,4);
        board[8][4] = new King(8,4);
    }

    public Piece[][] getBoard() {
        return board;
    }

    public Piece getPiece(int x, int y){
        return board[x][y];
    }
}
