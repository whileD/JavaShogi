package info.whiled.javashogi.core;

import info.whiled.javashogi.core.board.Board;
import info.whiled.javashogi.core.piece.Piece;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Board board;
    private UserType userType;
    private List<Piece> capturedPiece;
    private boolean endHand;

    public Player(Board board, UserType userType) {
        this.board = board;
        this.userType = userType;
        capturedPiece = new ArrayList<>();
        endHand = false;
    }

    public void next() {
        /*
        次の一手が決まるまで繰り返す
        (選択→移動可能か？→可能なら移動する。場所によってはプロモートするかどうかを決めたり、取った駒をリストにおいとく。無理ならまた最初から)
         */
        System.out.println("-----" + userType.getType() + "-----");
        showBoard();
        while (!endHand) {
            IOUtils.prompt("mv:駒の移動, dp:盤面の出力, cp:手持ちの駒の確認, pcp:持ち駒を置く");
            switch (IOUtils.inputString()){
                case "mv":
                    movePiece();
                    break;
                case "dp":
                    showBoard();
                    break;
                case "cp":
                    showCapturedPiece();
                    break;
                case "pcp":
                    putPiece();
                    break;
            }
        }
        endHand = false;
    }


    private void showBoard(){
        board.display();
    }

    private void showCapturedPiece(){
        for (int i=0; i<capturedPiece.size(); i++)
            System.out.print(i+1 + ":" + capturedPiece.get(i).getPieceType().getName() + " ");
        System.out.println();
    }

    private void putPiece(){
        if (capturedPiece.size() == 0) return;
        showCapturedPiece();
        IOUtils.prompt("どれを置きますか?");
        int sel = IOUtils.inputNumber();
        IOUtils.prompt("どこに置きますか？");
        int nextX = IOUtils.inputNumber();
        int nextY = IOUtils.inputNumber();

        Piece currentPiece = capturedPiece.get(sel);
        if (currentPiece.canPut(nextX,nextY)){
            currentPiece.move(nextX,nextY);
            board.put(nextX,nextY,currentPiece);
            endHand = true;
        }else {
            System.out.println("おけません");
        }
    }

    private void movePiece(){
        IOUtils.prompt("駒を選択してください 入力例:0 1");
        int pieceX = IOUtils.inputNumber();
        int pieceY = IOUtils.inputNumber();

        if (board.getPiece(pieceX,pieceY) == null) return;
        if (board.getPiece(pieceX,pieceY).getUserType() != userType){
            System.out.println("移動できません");
            return;
        }
        Piece currentPiece = board.getPiece(pieceX, pieceY);

        IOUtils.prompt("どこに移動させますか？");
        int nextX = IOUtils.inputNumber();
        int nextY = IOUtils.inputNumber();
        if (currentPiece.canMove(nextX, nextY)) {
            currentPiece.move(nextX,nextY);
            if (board.getPiece(nextX,nextY) != null){
                capturedPiece.add(board.getPiece(nextX, nextY));
                capturedPiece.forEach(e -> {
                    e.setUserType(userType);
                    e.move(0,0);
                });
            }
            board.move(pieceX, pieceY, nextX, nextY);
            endHand = true;
        } else {
            System.out.println("移動できません");
        }
    }
}
