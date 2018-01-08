package pl.put.poznan.foxtrot.logic;

/**
 * This class describes a single connection between nodes.
 * Holds information about:
 * - connected nodes,
 * - direction,
 * - value (cost, distance etc.).
 */
public class Connection {
    /** This property holds information about source node of connection. */
    private Node from;
    /** This property holds information about destination node of connection. */
    private Node to;
    /** This property holds information about value (cost, distance etc.) of connection. */
    private Float value;

    public Connection(Node from, Node to, Float value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }

    public Node getFrom() {
        return from;
    }

    public void setFrom(Node from) {
        this.from = from;
    }

    public Node getTo() {
        return to;
    }

    public void setTo(Node to) {
        this.to = to;
    }

    public float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
