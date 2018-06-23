package com.redfox.chess;

import com.redfox.chess.pieces.AbstractPiece;

public class EmptyPiece extends AbstractPiece {

    private  EmptyPiece(){
        this.setName("EMP");
    }
    @Override
    public void isValidMovement(int source_x, int source_y, int destination_x, int destination_y) {

    }

    @Override
    public void isAvailable() {

    }
}
