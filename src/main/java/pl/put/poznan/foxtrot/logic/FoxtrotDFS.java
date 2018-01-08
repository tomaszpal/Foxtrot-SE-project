package pl.put.poznan.foxtrot.logic;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * This class implements Foxtrot interface.
 * It uses modified DFS strategy to search for the shortest path.
 */
public class FoxtrotDFS implements Foxtrot {
    /** This property holds information about visited nodes. */
    private Map<Node, Boolean> visited;
    /** This property holds information about current cost of the path. */
    private Float cost;
    /** This property holds information about current path. */
    private LinkedList<Node> path;
    /** This property holds information about cost of current minimal path. */
    private Float minCost;
    /** This property holds information about current minimal path. */
    private LinkedList<Node> minPath;
    /** This property holds information about entry node. */
    private Node entry;
    /** This property holds information about exit node. */
    private Node exit;

    @Override
    public Path find(Graph graph) throws Exception {
        if (!graph.check()) {
            throw new Exception();
        }
        
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
        return new Path(minPath, minCost);
    }

    /**
     * This method marks given node as visited
     * and updates it current costs. If the node is exit
     * the current path is saved if its shorter than
     * previous minimal path.
     * @param node - Node to be visited.
     */
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
