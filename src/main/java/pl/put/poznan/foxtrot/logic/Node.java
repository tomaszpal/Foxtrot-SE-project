package pl.put.poznan.foxtrot.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * This class defines a node in graph. It contains id, name (optional),
 * type of the node (regular, entry or exit)
 * and incoming and outgoing connections lists.
 */
public class Node {
    /** This property holds information about node id. */
    private Integer id;
    /** This property holds information about node name (it is optional). */
    private String name;
    /** This property holds information about type of node. */
    private Type type;
    /** This property holds information about outgoing connections from node (where this node is source). */
    private List<Connection> outgoing;
    /** This property holds information about outgoing connections from node (where this node is destination). */
    private List<Connection> incoming;

    /** This type defines type of node.
     *  There are three types of node:
     *  - regular,
     *  - entry,
     *  - exit.
     */
    public Node(){
        outgoing = new ArrayList<>();
        //System.out.println("Node created!");
    };

    public enum Type {
        regular, entry, exit
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

    /**
     * This method adds given connection to outgoing list.
     * Outgoing list contains outgoing connections from a node.
     * @param outgoing - Connection to add to outgoing list.
     */
    public void addOutgoing(Connection outgoing) {
        this.outgoing.add(outgoing);
    }

    public List<Connection> getIncoming() {
        return incoming;
    }

    /**
     * This method adds given connection to incoming list.
     * Incoming list contains outgoing connections to a node.
     * @param incoming - Connection to add to incoming list.
     */
    public void addIncoming(Connection incoming) {
        this.incoming.add(incoming);
    }
}
