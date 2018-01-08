package pl.put.poznan.foxtrot.logic;


/**
 * This interface provides a method that should be used
 * for finding shortest path between entry and exit point in a graph.
 */
public interface Foxtrot {
    /**
     * This method finds shortest path between entry and exit nodes.
     * @param graph - Graph, in which will
     * @return Shortest path between entry and exit point with its cost.
     * @throws Exception when provided data in a graph is incorrect.
     */
    Path find(Graph graph) throws Exception;
}
