package com.redfox.chess.util;

public enum  Color{
B(0),W(1);

private int c;

 Color(int c){
    this.c = c;
}
public int color(){
     return c;
}

}