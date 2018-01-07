package pl.put.poznan.foxtrot.logic;

import java.util.List;

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
     * This method checks if graph contains entry and exit points.
     * @return True if graph contains the points, false otherwise.
     */
    public boolean check() {
        boolean hasEntry = false;
        boolean hasExit = false;

        for (Node node: nodeList) {
            if (node.getType() == Node.Type.entry) {
                hasEntry = true;
                entry = node;
            }
            else if (node.getType() == Node.Type.exit){
                hasExit = true;
                exit = node;
            }
        }
        return hasEntry & hasExit;
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
