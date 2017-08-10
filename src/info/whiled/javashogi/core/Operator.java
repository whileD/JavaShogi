package info.whiled.javashogi.core;

import info.whiled.javashogi.core.board.Board;

public class Operator {
    private Board board;
    private Player[] players;
    private int turn = 0;

    public Operator() {
        this.board = new Board();
        players = new Player[2];
        players[0] = new Player(this.board, UserType.USER);
        players[1] = new Player(this.board, UserType.RIVAL);
    }

    public void start() {
        while (!board.isEnd()) {
            players[turn].next();
            nextTurn();
        }
        end();
    }

    public void end(){
        board.display();
        System.out.println("勝者:" + board.witchWinner().getType());
    }

    private void nextTurn() {
        if (turn == 0) turn = 1;
        else turn = 0;
    }
}
