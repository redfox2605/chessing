package com.redfox.chess.pieces;

import com.redfox.chess.util.Color;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    private final int offsetX[] = {1, 1, 2, 2, -1, -1, -2, -2};
    private final int offsetY[] = {-2, 2, -1, 1, -2, 2, -1, 1};

    public Knight(int id, Color color) {
        this.setId(id);
        this.setColor(color);
        this.setName("K"+color+id);

    }

    @Override
    public Path getValidPath(int source_x, int source_y, int destination_x, int destination_y) {

        for(int i=0; i<offsetX.length;i++){
            if((source_x+offsetX[i]) == destination_x && (source_y + offsetY[i]) == destination_y){
                Path path = new Path();
                path.addPoint(new Integer[]{destination_x,destination_y});
                return path;
            }
        }
        return null;
    }

}
