package com.redfox.chess.pieces;


public interface PieceInterface {
    public Path getValidPath(int source_x, int source_y, int destination_x, int destination_y);
}
