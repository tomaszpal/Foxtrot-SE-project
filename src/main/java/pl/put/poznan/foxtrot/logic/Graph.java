package pl.put.poznan.foxtrot.logic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {
    private List<Node> nodeList;
    private List<Connection> connectionList;
    private Node entry;
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
     * This method checks if graph contains one entry and one exit points.
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
