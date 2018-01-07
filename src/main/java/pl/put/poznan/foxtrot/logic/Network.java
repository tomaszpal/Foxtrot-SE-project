package pl.put.poznan.foxtrot.logic;

import java.util.ArrayList;

public class Network {

    public Network() {
        super();
    }

    public Network(ArrayList<Integer> nodes) {
        this.nodes = nodes;
    }


    public ArrayList<Integer> nodes;
    public ArrayList<ArrayList<Integer>> connections;

    public void createNetwork(Network recievedData) {
        this.nodes = recievedData.nodes;
    }


}
