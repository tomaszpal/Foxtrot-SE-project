package pl.put.poznan.foxtrot.logic;

import java.util.List;
import java.util.Queue;
import java.util.Set;


public class FoxtrotBFS implements  Foxtrot{
    @Override
    public ShortestPath find(List<Node> nodeList, List<Connection> connectionList) {
        Set<Node> nodeSet;
        Queue<Node> nodeQueue;

        for (Node node: nodeList) {
            for (Connection connection: connectionList) {
                if (node.getId().equals(connection.getFrom())) {
                    node.addOutgoing(connection);
                }
                else if (node.getId().equals(connection.getTo())) {
                    node.addIncoming(connection);
                }
            }
        }
        return null;
    }

}
