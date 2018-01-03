package pl.put.poznan.foxtrot.logic;

import java.util.List;

public class Node {
    private Integer id;
    private String name;
    private Type type;
    private List<Node> outgoing;
    private List<Node> incoming;

    public Node(Integer id, Type type, List<Node> outgoing, List<Node> incoming) {
        this(id, type, outgoing, incoming, null);
    }

    public Node(int id, Type type, List<Node> outgoing, List<Node> incoming, String name) {
        this.id = id;
        this.type = type;
        this.outgoing = outgoing;
        this.incoming = incoming;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Node> getOutgoing() {
        return outgoing;
    }

    public void setOutgoing(List<Node> outgoing) {
        this.outgoing = outgoing;
    }

    public List<Node> getIncoming() {
        return incoming;
    }

    public void setIncoming(List<Node> incoming) {
        this.incoming = incoming;
    }
}
