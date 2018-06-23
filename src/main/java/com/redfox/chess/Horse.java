package com.redfox.chess;

public class Horse extends AbstractPiece{



    final int posx[]={x+1,x+1,x+2,x+2,x-1,x-1,x-2,x-2};
    final int posy[]={y-2,y+2,y-1,y+1,y-2,y+2,y-1,y+1};


    public Horse(int id, Color color, String name){
        this.setId(id);
        this.setColor(color.color());
        this.setName(name);

    }


public void mov

    @Override
    public void isValidMovement(int source_x, int source_y, int destination_x, int destination_y) {



    }

    @Override
    public void isAvailable() {

    }
}
