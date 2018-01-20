package pl.put.poznan.foxtrot.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * This class stores information about
 * path in graph and its cost.
 */
public class Path {
    private List<Node> path;
    private Float cost;

    public Path(List<Node> path, Float costSum) {
        this.path = path;
        this.cost = costSum;
    }

    public List<Node> getPath() {
        return path;
    }

    public List<Integer> getPathIDs() {
        List<Integer> result = new ArrayList<>();
        for (Node node: path) {
            result.add(node.getId());
        }
        return result;
    }
    public Float getCost() {
        return cost;
    }
}
