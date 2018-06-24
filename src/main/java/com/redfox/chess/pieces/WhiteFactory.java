package com.redfox.chess.pieces;

import com.redfox.chess.util.Color;

public class WhiteFactory  implements PieceFactory{

    public Piece createKnight(int id){
        return new Knight(id,Color.W);
    }

    public Piece createBishop(int id){
        return new Bishop(id, Color.W);
    }

}
