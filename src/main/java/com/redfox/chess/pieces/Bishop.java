package com.redfox.chess.pieces;

import com.redfox.chess.util.Color;

public class Bishop extends Piece {

    public Bishop(int id, Color color){
        super(id,color);
        this.setName("B"+color+id);
    }

    @Override
    public Path getValidPath(int source_x, int source_y, int destination_x, int destination_y) {
        int diff_x = destination_x - source_x;
        int diff_y = destination_y - source_y;

        if( Math.abs(diff_x) == Math.abs(diff_y) ){
            //moving diagonally
            int directionX = diff_x > 0 ? 1 : -1;
            int directionY = diff_y > 0 ? 1 : -1;

            Path path = new Path();
            int pos_x = source_x;
            int pos_y = source_y;
            //diagonal movement so i check just for x
            while(pos_x != destination_x){
                pos_x += directionX;
                pos_y+= directionY;
                path.addPoint(new Integer[]{pos_x,pos_y});
            }
            return path;
        }
        return null;
    }
}
