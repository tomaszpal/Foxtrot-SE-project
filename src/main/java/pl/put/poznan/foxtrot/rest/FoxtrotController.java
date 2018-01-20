package pl.put.poznan.foxtrot.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.foxtrot.logic.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;


@RestController
@RequestMapping("/{text}")
public class FoxtrotController {

    private static final Logger logger = LoggerFactory.getLogger(FoxtrotController.class);
    Graph lastGraph;

    //Response to GET request
    @CrossOrigin()
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Path get (@RequestParam(value="transforms", defaultValue="dfs") String transforms) throws JsonProcessingException {
        Path result = null;
        Graph graph = lastGraph;
        System.out.println(transforms);
        try {
            if (transforms.equals("bfs")) {
                System.out.println("Using BFS");
                FoxtrotBFS foxtrotBFS = new FoxtrotBFS();
                graph.createOutgoing();
                result = foxtrotBFS.find(graph);
            }
            if (transforms.equals("dfs")) {
                System.out.println("Using DFS");
                FoxtrotDFS foxtrotDFS = new FoxtrotDFS();
                graph.createOutgoing();
                result = foxtrotDFS.find(graph);
            }
        } catch (Exception ex) {
            ex.printStackTrace(new PrintStream(System.out));
            result = new Path(new ArrayList<Node>(Arrays.asList(new Node(), new Node(), new Node())), (float) 7.6);
        }
        return result;
    }

    //Response to POST request
    @CrossOrigin()
    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public Path post (@RequestBody Graph graph, @RequestParam(value="transforms", defaultValue="dfs") String transforms) throws JsonProcessingException {
        Path result = null;
        lastGraph = graph;
        System.out.println(transforms);
        try{
            if(transforms.equals("bfs")){
                System.out.println("Using BFS");
                FoxtrotBFS foxtrotBFS = new FoxtrotBFS();
                graph.createOutgoing();
                result = foxtrotBFS.find(graph);
            }
            if(transforms.equals("dfs")){
                System.out.println("Using DFS");
                FoxtrotDFS foxtrotDFS = new FoxtrotDFS();
                graph.createOutgoing();
                result = foxtrotDFS.find(graph);
            }
        } catch (Exception ex) {
            ex.printStackTrace(new PrintStream(System.out));
        }
        return result;
    }



}


