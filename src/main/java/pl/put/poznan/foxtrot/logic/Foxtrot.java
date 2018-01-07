package pl.put.poznan.foxtrot.logic;

import com.sun.media.sound.InvalidDataException;

import java.util.List;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
<<<<<<< HEAD
public class Foxtrot {

    public String[] transforms;
    public String text;
    public ShortestPath shortestPath;

    public Foxtrot(String[] transforms, String text) {
        this.transforms = transforms;
        this.text = text;
        this.shortestPath = bfs(new ArrayList<Integer>(10)); //Test call of bfs
    }

    public ShortestPath bfs(ArrayList<Integer> nodeList){
        return new ShortestPath(nodeList, 21.37f);
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
=======
public interface Foxtrot {
    ShortestPath find(Graph graph) throws InvalidDataException;
>>>>>>> remotes/origin/logic
}
