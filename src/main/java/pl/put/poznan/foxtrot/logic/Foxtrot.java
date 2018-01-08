package pl.put.poznan.foxtrot.logic;

import com.sun.media.sound.InvalidDataException;

/**
 * This interface provides a method that should be used
 * for finding shortest path between entry and exit point in a graph.
 */
public interface Foxtrot {
    /**
     * This method finds shortest path between entry and exit nodes.
     * @param graph - Graph, in which will
     * @return Shortest path between entry and exit point with its cost.
     * @throws InvalidDataException when provided data in a graph is incorrect.
     */
    Path find(Graph graph) throws InvalidDataException;
}
