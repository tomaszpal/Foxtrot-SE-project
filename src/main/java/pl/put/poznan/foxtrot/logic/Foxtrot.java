package pl.put.poznan.foxtrot.logic;

import java.util.ArrayList;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class Foxtrot {
    public ShortestPath bfs(){
        return new ShortestPath(new ArrayList<>(), 0.0f);
    }

    public ShortestPath dfs(String text){
        return new ShortestPath(new ArrayList<>(), 0.0f);
    }

    public ShortestPath greedy(String text){
        return new ShortestPath(new ArrayList<>(), 0.0f);
    }
}
