package com.redfox.chess.pieces;

import java.util.ArrayList;
import java.util.List;

public class Path {

    private List<Integer[]> tracePath;

    public Path(){ this.tracePath = new ArrayList<>(); }

    public List<Integer[]> getTracePath() { return tracePath; }

    public void addPoint(Integer[] point){
        tracePath.add(point);
    }
}
