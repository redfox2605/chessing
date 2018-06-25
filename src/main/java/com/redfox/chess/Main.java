package com.redfox.chess;

import com.redfox.chess.board.ChessBoard;
import com.redfox.chess.util.Color;
import com.redfox.chess.util.InvalidMoveException;

public class Main {
    public static void main(String[] args) {


        ChessBoard chessBoard = new ChessBoard();
        chessBoard.initializeBoard();

        try {
            chessBoard.movePiece(Color.B,0,1,2,2);
        }catch (InvalidMoveException e){
            System.out.println(e.getMessage());
        }
        chessBoard.showBoard();
    }
}
