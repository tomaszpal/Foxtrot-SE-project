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

    public void setUp() {

        Graph graph;
         List<Node> nodeList;
         List<Connection> connectionList;

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

        ObjectMapper mapper = new ObjectMapper();
        try {mapper.writeValue(new File("file.json"), graph);}
        catch (Exception e){

        }
    }

    //Response to GET request
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
        }
        return result;
    }

    //Response to POST request
    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public Path post (@RequestBody Graph graph, @RequestParam(value="transforms", defaultValue="dfs") String transforms) throws JsonProcessingException {
        Path result = null;
        lastGraph = graph;
        System.out.println(transforms);
        setUp();
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


