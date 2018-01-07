package pl.put.poznan.foxtrot.logic;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FoxtrotDFS implements Foxtrot {
    private Map<Node, Boolean> visited;
    private Float cost;
    private LinkedList<Node> path;
    private Float minCost;
    private LinkedList<Node> minPath;
    private Node entry;
    private Node exit;

    @Override
    public ShortestPath find(Graph graph) {
        visited = new HashMap<>();
        minCost = Float.POSITIVE_INFINITY;

        entry = graph.getEntry();
        exit = graph.getExit();

        for (Node node: graph.getNodeList()) {
            visited.put(node, false);
        }
        path = new LinkedList<>();
        cost = 0.0f;
        VisitNode(entry);
        minPath.add(exit);
        return new ShortestPath(minPath, minCost);
    }

    private void VisitNode(Node node) {
        if (node == exit) {
            if (cost < minCost) {
                minCost = cost;
                minPath = path;
            }

        }
        else {
            path.add(node);
            visited.put(node, true);
            for (Connection connection : node.getOutgoing()) {
                Node neighbor = connection.getTo();
                if (!visited.get(neighbor)) {
                    cost = cost + connection.getValue();
                    VisitNode(neighbor);
                    path.remove(neighbor);
                }
            }
        }

    }
}
