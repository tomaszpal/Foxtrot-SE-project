package pl.put.poznan.foxtrot.logic;

import java.util.*;

/**
 * This class implements Foxtrot interface.
 * It uses modified BFS strategy to search for the shortest path.
 */
public class FoxtrotBFS implements Foxtrot {
    /** This property holds information about nodes that need to be checked. */
    private Set<Node> nodeSet;
    /** This property holds information about costs from entry to node. */
    private Map<Node, Float> costs;
    /** This property holds information about costs from entry to node. */
    private Map<Node, Node> prev;
    /** This property holds information about previously checked nodes. */
    private LinkedList<Node> path;
    /** This property holds information about entry node. */
    private Node entry;
    /** This property holds information about exit node. */
    private Node exit;

    @Override
    public Path find(Graph graph) throws Exception {
        if (!graph.check()) {
            throw new Exception();
        }
        nodeSet = new HashSet<>();
        costs = new HashMap<>();
        prev = new HashMap<>();
        path = new LinkedList<>();
        entry = graph.getEntry();
        exit = graph.getExit();

        for (Node node: graph.getNodeList()) {
            costs.put(node, Float.POSITIVE_INFINITY);
            prev.put(node, null);
            nodeSet.add(node);
        }

        costs.put(entry, 0.0f);

        while (!nodeSet.isEmpty()) {
            Node current = getMinDistNode();
            nodeSet.remove(current);
            if (current == exit) {
                break;
            }
            for (Connection connection: current.getOutgoing()) {
                Node neighbor = connection.getTo();
                Float newDist = costs.get(current) + connection.getValue();
                if (newDist < costs.get(neighbor)) {
                    costs.put(neighbor, newDist);
                    prev.put(neighbor, current);
                }
            }
        }
        Node node = exit;
        while (prev.get(node) != null) {
            path.add(node);
            node = prev.get(node);
        }
        path.add(node);
        Collections.reverse(path);
        Float cost = costs.get(exit);
        return new Path(path, cost);
    }

    /**
     * This method returns Node from nodeSet, which has
     * the lowest distance from entry point in cost map.
     * @return Node from node set with the lowest distance from entry.
     */
    private Node getMinDistNode() {
        Node minNode = null;
        Float min = Float.POSITIVE_INFINITY;
        for (Node node: nodeSet) {
            Float cost = costs.get(node);
            if(cost < min) {
                minNode = node;
                min = cost;
            }
        }
        return minNode;
    }
}
