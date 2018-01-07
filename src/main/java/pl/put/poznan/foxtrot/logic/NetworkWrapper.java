package pl.put.poznan.foxtrot.logic;

import java.util.ArrayList;


public class NetworkWrapper {

    public ArrayList<Network> networkList = new ArrayList<Network>();

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }

    public NetworkWrapper() {
    }

    public void AddToNetworkList(Network newNetwork){
        networkList.add(newNetwork);
    }
}
