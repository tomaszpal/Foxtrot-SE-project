package pl.put.poznan.foxtrot.logic;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FoxtrotBFSTest {
    private Foxtrot search;
    private Graph graphMock;
    private Float expectedCost;
    private List<Integer> expectedPath;
    @Before
    public void setUp() {
        search = new FoxtrotBFS();
        ArrayList<Node> nodeList = new ArrayList<>();
        ArrayList<Connection> connectionList = new ArrayList<>();

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

        n1.addOutgoing(c1);
        n1.addOutgoing(c2);

        n2.addIncoming(c1);
        n2.addOutgoing(c3);

        n3.addIncoming(c1);
        n3.addOutgoing(c4);

        n4.addIncoming(c3);
        n4.addOutgoing(c5);

        n5.addIncoming(c4);
        n5.addIncoming(c5);

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

        graphMock = mock(Graph.class);
        when(graphMock.check()).thenReturn(true);
        when(graphMock.getNodeList()).thenReturn(nodeList);
        when(graphMock.getConnectionList()).thenReturn(connectionList);
        when(graphMock.getEntry()).thenReturn(n1);
        when(graphMock.getExit()).thenReturn(n5);

        expectedCost = 7.0f;
        expectedPath = new ArrayList<>();
        expectedPath.add(0);
        expectedPath.add(2);
        expectedPath.add(4);
    }


    @Test
    public void findCorrect() throws Exception {
        Path path = search.find(graphMock);

        assertTrue(path.getCost().equals(expectedCost));
        assertTrue(path.getPathIDs().equals(expectedPath));
        verify(graphMock, times(1)).check();
        verify(graphMock, times(1)).getEntry();
        verify(graphMock, times(1)).getExit();
        verify(graphMock, times(1)).getNodeList();
    }

    @Test(expected = Exception.class)
    public void findWrongData() throws Exception {
        when(graphMock.check()).thenReturn(false);

        Path path = search.find(graphMock);
        verify(graphMock, times(1)).check();
    }
}