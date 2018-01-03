package pl.put.poznan.foxtrot.logic;

import java.util.ArrayList;

public class ShortestPath{
    private ArrayList<Integer> path;
    private Float costSum;

    public ShortestPath(ArrayList<Integer> path, Float costSum) {
        this.path = path;
        this.costSum = costSum;
    }

    public ArrayList<Integer> getPath() {
        return path;
    }

    public Float getCostSum() {
        return costSum;
    }
}
