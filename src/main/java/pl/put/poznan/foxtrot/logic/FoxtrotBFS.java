package pl.put.poznan.foxtrot.logic;

import java.util.*;

public class FoxtrotBFS implements  Foxtrot{
    private Set<Node> nodeSet;
    private Map<Node, Float> costs;
    private Map<Node, Node> prev;
    private LinkedList<Node> path;
    private Node entry;
    private Node exit;

    @Override
    public ShortestPath find(Graph graph) {
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
        return new ShortestPath(path, cost);
    }

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
