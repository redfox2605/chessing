package com.redfox.chess;

public abstract class AbstractPiece implements Piece {



    private int id;
    private int color;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setColor(int color){
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

}
