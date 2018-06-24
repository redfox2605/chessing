package com.redfox.chess.pieces;

import com.redfox.chess.util.Color;

public abstract class Piece implements PieceInterface {

    private int id;
    private Color color;
    private String name = "";
    private boolean isTaken = false;

    public Piece(int id, Color color) {
        this.id = id;
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public boolean isTaken(){ return isTaken; }

    public void setTaken() {
        isTaken = true;
    }
}
