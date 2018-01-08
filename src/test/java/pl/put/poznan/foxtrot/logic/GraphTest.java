package pl.put.poznan.foxtrot.logic;


import org.junit.Before;
import org.junit.After;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;


class GraphTest {

    private Graph graph;
    private List<Node> nodeList;
    private List<Connection> connectionList;

    GraphTest() {}

    @Before
    public void setUp() {
        nodeList = new ArrayList<>();
        connectionList = new ArrayList<>();

        Node n1 = new Node(0, Node.Type.entry, "name1");
        Node n2 = new Node(1, Node.Type.regular, "name2");
        Node n3 = new Node(2, Node.Type.regular, "name3");
        Node n4 = new Node(3, Node.Type.regular, "name4");
        Node n5 = new Node(4, Node.Type.exit, "name5");

        Connection c1 = new Connection(n1, n2, 1.0f);
        Connection c2 = new Connection(n1, n3, 3.0f);
        Connection c3 = new Connection(n2, n4, 2.0f);
        Connection c4 = new Connection(n3, n5, 4.0f);
        Connection c5 = new Connection(n4, n5, 5.0f);


        nodeList.add(n1);
        nodeList.add(n2);
        nodeList.add(n3);
        nodeList.add(n4);
        nodeList.add(n5);

        connectionList.add(c1);
        connectionList.add(c2);
        connectionList.add(c3);
        connectionList.add(c4);
        connectionList.add(c5);

        graph = new Graph(nodeList, connectionList);
    }

    @After
    public void tearDown() {
        nodeList.clear();
        connectionList.clear();
    }

    @Test
    public void checkGood() {
        boolean result = graph.check();
        assertTrue(result);
    }

    @Test
    public void checkUnique() {
        Node node = new Node(0, Node.Type.regular, "name6");
        graph.getNodeList().add(node);
        boolean result = graph.check();
        assertFalse(result);
    }

    @Test
    public void check2Entries() {
        Node node = new Node(5, Node.Type.entry, "name6");
        graph.getNodeList().add(node);
        boolean result = graph.check();
        assertFalse(result);
    }

    @Test
    public void check2Exits() {
        Node node = new Node(5, Node.Type.exit, "name6");
        graph.getNodeList().add(node);
        boolean result = graph.check();
        assertFalse(result);
    }

    @Test
    public void checkUnreachable() {
        graph.check();
        for (Connection connection: graph.getExit().getIncoming()) {
            Node node = connection.getFrom();
            node.getOutgoing().clear();
        }
        graph.getExit().getIncoming().clear();
        boolean result = graph.check();
        assertFalse(result);
    }
}