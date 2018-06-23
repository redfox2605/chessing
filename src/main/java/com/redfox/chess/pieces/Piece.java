package com.redfox.chess.pieces;

public interface Piece {

    public void isValidMovement(int source_x, int source_y, int destination_x, int destination_y);
    public void isAvailable();
}
