package pl.put.poznan.foxtrot.logic;

import pl.put.poznan.foxtrot.logic.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class Foxtrot {

    public String[] transforms;
    public String text;

    public Foxtrot(String[] transforms, String text) {
        this.transforms = transforms;
        this.text = text;
    }

    public ShortestPath bfs(){
        return new ShortestPath(new ArrayList<>(), 0.0f);
    }

    public ShortestPath dfs(String text){
        return new ShortestPath(new ArrayList<>(), 0.0f);
    }

    public ShortestPath greedy(String text){
        return new ShortestPath(new ArrayList<>(), 0.0f);
    }

    public String transform(String text) {
        return "Modified text: " + text + "\nTransforms: " + Arrays.toString(transforms);
    }
}
