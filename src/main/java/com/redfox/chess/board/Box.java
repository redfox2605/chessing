package com.redfox.chess.board;

import com.redfox.chess.pieces.Piece;
import com.redfox.chess.util.Color;

public class Box {

    private Color color;
    private Piece piece;
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Box(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void removePiece(){
        this.piece = null;
    }

    public Color getColor() {

        return color;
    }


    public Piece getPiece() {
        return piece;
    }

    public String showBox(){
        return "Box color: " + color + " PieceInterface:" + piece.getName();
    }


}
