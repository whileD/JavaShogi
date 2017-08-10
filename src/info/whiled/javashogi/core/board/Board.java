package info.whiled.javashogi.core.board;

import info.whiled.javashogi.core.UserType;
import info.whiled.javashogi.core.piece.Piece;
import info.whiled.javashogi.core.piece.PieceType;
import info.whiled.javashogi.core.piece.pieces.Bishop;
import info.whiled.javashogi.core.piece.pieces.King;
import info.whiled.javashogi.core.piece.pieces.Pawn;
import info.whiled.javashogi.core.piece.pieces.Rook;

public class Board {
    private Piece[][] board;
    private final static int BOARD_COLUMN = 3;
    private final static int BOARD_ROW = 4;

    public Board(){
        initBoard();
        attachBoard();
    }


    public void initBoard(){
        board = new Piece[BOARD_ROW][BOARD_COLUMN];
        board[0][1] = new King(1,0, UserType.USER);
        board[3][1] = new King(1, 3, UserType.RIVAL);
        board[1][1] = new Pawn(1,1, UserType.USER);
        board[2][1] = new Pawn(1,2, UserType.RIVAL);
        board[0][2] = new Rook(2, 0, UserType.USER);
        board[3][0] = new Rook(0,3, UserType.RIVAL);
        board[0][0] = new Bishop(0,0, UserType.USER);
        board[3][2] = new Bishop(2,3, UserType.RIVAL);
    }

    private void attachBoard(){
        for (int i=0;i<board.length; i++){
            for (int j=0; j < board[i].length; j++){
                if (board[i][j] == null) continue;
                board[i][j].setBoard(this);
            }
        }
    }

    public void move(int x, int y, int nx, int ny){
        board[ny][nx] = board[y][x];
        board[y][x] = null;
    }

    public void put(int x, int y, Piece piece){
        board[y][x] = piece;
    }

    public Piece getPiece(int x, int y){
        return board[y][x];
    }

    public boolean isEnd() {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == null) continue;
                if (board[i][j].getPieceType() == PieceType.KING) count++;
            }
        }

        return (count == 1) ? true : false;
    }

    public UserType witchWinner(){
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                if (board[i][j] == null) continue;
                if (board[i][j].getPieceType() == PieceType.KING){
                    return board[i][j].getUserType();
                }
            }
        }
        return null;
    }

    public void display() {
        for (int i=board.length-1; i >= 0; i--){
            for (int j=0; j<board[i].length; j++){
                if (board[i][j] == null){
                    System.out.print("・");
                    continue;
                }
                if (board[i][j].getUserType() == UserType.USER)
                    System.out.print("\u001b[00;47m" + board[i][j].getPieceType().getName() + "\u001b[00m");
                else
                    System.out.print("\u001b[00;46m" + board[i][j].getPieceType().getName() + "\u001b[00m");
            }
            System.out.println();
        }
    }
}
