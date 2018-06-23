package com.redfox.chess;

import com.redfox.chess.board.ChessBoard;

public class Main {
    public static void main(String[] args) {


        ChessBoard chessBoard = new ChessBoard();
        chessBoard.initializeBoard();
        chessBoard.showBoard();
    }
}
