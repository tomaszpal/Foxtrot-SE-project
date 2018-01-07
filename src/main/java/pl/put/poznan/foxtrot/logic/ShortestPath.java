package pl.put.poznan.foxtrot.logic;

import java.util.List;

public class ShortestPath{
    private List<Node> path;
    private Float costSum;

    public ShortestPath(List<Node> path, Float costSum) {
        this.path = path;
        this.costSum = costSum;
    }

    public List<Node> getPath() {
        return path;
    }

    public Float getCostSum() {
        return costSum;
    }
}
