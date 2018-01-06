package pl.put.poznan.foxtrot.logic;

import java.util.List;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public interface Foxtrot {
    ShortestPath find(List<Node> nodeList, List<Connection> connectionList);
}
