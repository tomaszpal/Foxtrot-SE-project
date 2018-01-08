package pl.put.poznan.foxtrot.logic;

import java.util.ArrayList;
import java.util.List;

public class FoxtrotGreedy implements Foxtrot{


    private List<Connection> path = new ArrayList();
    private List<Connection> opened = new ArrayList();
    private List<Connection> closed = new ArrayList();

    private Connection minConnection;


    private Connection getMinConnection() {
        return minConnection;
    }

    private boolean setMinConnection(){
        if (opened != null && !opened.isEmpty()) {
            Connection best = opened.get(0);
            for (Connection c : opened) {
                if( best.getValue() > c.getValue())
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
        List<Node> nodeList = new ArrayList<>();
        float cost = 0;
        for( Connection c: conList){
            nodeList.add(c.getFrom());
            cost += c.getValue();
        }
        nodeList.add(conList.get(conList.size()-1).getTo());
        return  new Path(nodeList,cost);
    }
    @Override
    public Path find(Graph graph) {
        Node start = graph.getEntry();
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
                //zglos blad ze nie ma exit w grafie
                break;
            }

        } while(!checkIfExit(minCon));

        return getPath(closed); //nie wiem co wrzucic zamiast closed
    }
}
