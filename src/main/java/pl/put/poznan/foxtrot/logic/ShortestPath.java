package pl.put.poznan.foxtrot.logic;

import java.util.List;

public class ShortestPath{
    private List<Integer> path;
    private Float costSum;

    public ShortestPath(List<Integer> path, Float costSum) {
        this.path = path;
        this.costSum = costSum;
    }

    public List<Integer> getPath() {
        return path;
    }

    public Float getCostSum() {
        return costSum;
    }
}
