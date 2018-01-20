package pl.put.poznan.foxtrot.logic;


import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FoxtrotGreedy implements Foxtrot{

    private List<Connection> opened = new ArrayList();
    private List<Connection> closed = new ArrayList();
    private Node entry = null;
    private Node exit = null;
    private Connection minConnection = null;


    private Connection getMinConnection() {
        return minConnection;
    }

    private boolean setMinConnection(){
        if (opened != null && !opened.isEmpty()) {
            minConnection = opened.get(0);
            for (Connection c : opened) {
                if( minConnection.getValue() > c.getValue())
                    minConnection = c;
            }
            return true;
        }
        else
            return false;
    }

    private boolean checkIfExit(Connection con){
        return con.getTo().getType().equals(Node.Type.exit);
    }

    private Path getPath(List<Connection> conList){
        ArrayList<Node> nodeList = new ArrayList<>();
        Float cost = 0.0f;
        nodeList.add(exit);
        for(Connection c: conList) {
            if (nodeList.get(nodeList.size() - 1).equals(c.getTo())) {
                nodeList.add(c.getFrom());
                cost += c.getValue();
            }
        }
        Collections.reverse(nodeList);
        return new Path(nodeList,cost);
    }
    @Override
    public Path find(Graph graph) throws Exception {
        if (!graph.check()) {
            throw new Exception("Wrong data input.");
        }
        entry = graph.getEntry();
        exit = graph.getExit();
        Node start = entry;
        Connection minCon;
        do {
            opened.addAll(start.getOutgoing());
            if(setMinConnection()) {
                minCon = getMinConnection();
                closed.add(minCon);
                opened.remove(minCon);
                start = minCon.getTo();
            }
            else {
                break;
            }

        } while(!checkIfExit(minCon));
        Collections.reverse(closed);
        for (Connection conn: closed
             ) {
            System.out.println(conn.getFrom().getId() + " " + conn.getTo().getId());

        }
        return getPath(closed); //nie wiem co wrzucic zamiast closed
    }
}
