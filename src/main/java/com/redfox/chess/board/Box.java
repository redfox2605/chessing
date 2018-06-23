package com.redfox.chess.board;

import com.redfox.chess.pieces.AbstractPiece;

public class Box {

    private int color;
    private AbstractPiece piece;


    public Box(int color){
        this.color = color;
    }

    public void setPiece(AbstractPiece piece) {
        this.piece = piece;
    }

    public int getColor() {

        return color;
    }


    public AbstractPiece getPiece() {
        return piece;
    }

    public String showBox(){
        return "Box color: " + color + " Piece:" + piece.getName();
    }


}
