package pl.put.poznan.foxtrot.rest;

import pl.put.poznan.foxtrot.logic.Node;
import pl.put.poznan.foxtrot.logic.Triplet;

import java.util.List;

public class TripletsWrapper {
    private final List<Triplet<Integer, String, Node.Type>> nodeList;
    private final List<Triplet<Integer, Integer, Float>> connectionList;

    public TripletsWrapper(List<Triplet<Integer, String, Node.Type>> nodeList,
                           List<Triplet<Integer, Integer, Float>> connectionList) {
        this.nodeList = nodeList;
        this.connectionList = connectionList;
    }

    public List<Triplet<Integer, String, Node.Type>> getNodeList() {
        return nodeList;
    }

    public List<Triplet<Integer, Integer, Float>> getConnectionList() {
        return connectionList;
    }
}
