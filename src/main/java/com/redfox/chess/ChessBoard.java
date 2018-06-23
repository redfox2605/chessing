package com.redfox.chess;

public class ChessBoard {

    private Box[][] board;

    public ChessBoard() {
        this.board = new Box[8][8];
        int last = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = last % 2 == 0 ? new Box(Color.W.color()) : new Box(Color.B.color());
                last++;
            }
            last--;
        }
    }


    public void initializeBoard() {
        System.out.println("initializing board");
        //Initialize black
        board[0][1].setPiece(new Horse(0, Color.B,"H"+Color.B+0));
        board[0][6].setPiece(new Horse(1, Color.B,"H"+Color.B+1));

        //Initialize white
        board[7][1].setPiece(new Horse(0, Color.W,"H"+Color.W+1));
        board[7][6].setPiece(new Horse(1, Color.W,"H"+Color.W+1));


    }

    public boolean removePiece(int x, int y) {

        return true;
    }

    public void movePiece(int source_x, int source_y, int dest_x, int dest_y){

    }

    public void showBoard() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(board[i][j].getPiece() == null) {
                    System.out.print(board[i][j].getColor() + "    ");
                }else{
                    System.out.print(board[i][j].getPiece().getName() + "  ");
                }
            }
            System.out.println();
        }
    }
}
