package com.redfox.chess.pieces.factory;

import com.redfox.chess.pieces.Piece;

public interface PieceFactory {

    Piece createKnight(int id);
    Piece createBishop(int id);
}
