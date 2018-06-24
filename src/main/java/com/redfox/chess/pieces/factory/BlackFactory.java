package com.redfox.chess.pieces.factory;

import com.redfox.chess.pieces.Bishop;
import com.redfox.chess.pieces.Knight;
import com.redfox.chess.pieces.Piece;
import com.redfox.chess.pieces.factory.PieceFactory;
import com.redfox.chess.util.Color;

public class BlackFactory implements PieceFactory {
    @Override
    public Piece createKnight(int id) {
        return new Knight(id, Color.B);
    }

    @Override
    public Piece createBishop(int id) {
        return new Bishop(id,Color.B);
    }
}
