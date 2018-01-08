package pl.put.poznan.foxtrot.logic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This class holds information about graph (nodes, connections,
 * entry and exit nodes). Additionaly it provides methods to verify
 * correctness of data.
 */
public class Graph {
    /** This property holds information about nodes in graph. */
    private List<Node> nodeList;
    /** This property holds information about connections in graph. */
    private List<Connection> connectionList;
    /** This property holds information about entry node. */
    private Node entry;
    /** This property holds information about exit node. */
    private Node exit;

    public Graph(List<Node> nodes, List<Connection> connections) {
        nodeList = nodes;
        connectionList = connections;

        for (Node node: nodeList) {
            for (Connection connection: connectionList) {
                if (node.equals(connection.getFrom())) {
                    node.addOutgoing(connection);
                }
                else if (node.equals(connection.getTo())) {
                    node.addIncoming(connection);
                }
            }
        }
    }

    /**
     * This method checks if graph contains exactly one entry and one exit point.
     * @return True if graph contains exactly one of each points (one entry, one exit),
     *         false otherwise.
     */
    private boolean checkPoints() {
        boolean hasEntry = false;
        boolean hasExit = false;

        for (Node node: nodeList) {
            if (node.getType() == Node.Type.entry) {
                if (hasEntry) {
                    hasEntry = false;
                    break;
                }
                else {
                    hasEntry = true;
                    entry = node;
                }
            }
            else if (node.getType() == Node.Type.exit){
                if (hasExit) {
                    hasExit = false;
                    break;
                }
                else {
                    hasExit = true;
                    exit = node;
                }
            }
        }
        return hasEntry & hasExit;
    }

    /**
     * This method checks if exit point is reachable from entry point.
     * @return True if exit point is reachable from entry point,
     *         false otherwise.
     */
    private boolean checkReachable() {
        HashMap<Node, Boolean> visited = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        for (Node node: nodeList) {
            visited.put(node, false);
        }
        visited.put(entry, true);
        queue.add(entry);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Connection connection: current.getOutgoing()) {
                Node neighbor = connection.getTo();
                if (neighbor == exit)
                    return true;
                if (!visited.get(neighbor)) {
                    visited.put(neighbor, true);
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }

    /**
     * This method checks if graph has only one entry and only one exit point,
     * then it checks if exit point is reachable from entry point.
     * @return True if both conditions are met, false otherwise.
     */
    public boolean check() {
        return checkPoints() && checkReachable();
    }

    public Node getEntry() {
        return entry;
    }

    public Node getExit() {
        return exit;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    public List<Connection> getConnectionList() {
        return connectionList;
    }

    public void setConnectionList(List<Connection> connectionList) {
        this.connectionList = connectionList;
    }
}
