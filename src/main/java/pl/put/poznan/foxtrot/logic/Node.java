package pl.put.poznan.foxtrot.logic;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private Integer id;
    private String name;
    private Type type;
    private List<Connection> outgoing;
    private List<Connection> incoming;

    public enum Type {
        entry, exit, regular
    }

    public Node(Integer id, Type type) {
        this(id, type, null);
    }

    public Node(Integer id, Type type, String name) {
        this.id = id;
        this.type = type;
        this.outgoing = new ArrayList<>();
        this.incoming = new ArrayList<>();
        this.name = name;
    }

    public Integer getId() {
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

    public List<Connection> getOutgoing() {
        return outgoing;
    }

    public void addOutgoing(Connection outgoing) {
        this.outgoing.add(outgoing);
    }

    public List<Connection> getIncoming() {
        return incoming;
    }

    public void addIncoming(Connection incoming) {
        this.incoming.add(incoming);
    }
}
