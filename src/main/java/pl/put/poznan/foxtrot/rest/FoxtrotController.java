package pl.put.poznan.foxtrot.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.foxtrot.logic.*;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class FoxtrotController {

    private static final Logger logger = LoggerFactory.getLogger(FoxtrotController.class);
    private Graph graph;

    //Response to GET request
    @CrossOrigin()
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")

    public Path get (@RequestParam(value="method") String method)throws JsonProcessingException {
        try {
            logger.debug("[API] GET Method!");
            Foxtrot search = getMethod(method);
            Path result = search.find(graph);
            logger.info("[API] Request handled correctly.");
            logger.debug("[API-GET] All good!");
            return result;
        } catch (Exception e) {
            logger.info("[API] Request failed, info in debug.");
            logger.debug("[FAIL] " + e.toString());
            e.printStackTrace();
        }
        return null;
    }


    //Response to POST request
    @CrossOrigin()
    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public Path post (@RequestBody TripletsWrapper values, @RequestParam(value="method") String method) throws JsonProcessingException {
        try {
            logger.debug("[API] POST Method!");
            Foxtrot search = getMethod(method);
            graph = parseTriplets(values);
            Path result = search.find(graph);
            logger.info("[API] Request handled correctly.");
            logger.debug("[API-GET] All good!");
            return result;
        } catch (Exception e) {
            logger.info("[API] Request failed, info in debug.");
            logger.debug("[FAIL] " + e.toString());
            e.printStackTrace();
        }
        return null;
    }

    private Graph parseTriplets(TripletsWrapper values) throws Exception {
        List<Node> nodeList = new ArrayList<>();
        List<Connection> connectionList = new ArrayList<>();

        List<Triplet<Integer, String, Node.Type>> nodes = values.getNodeList();
        List<Triplet<Integer, Integer, Float>> connections = values.getConnectionList();


        for (Triplet<Integer, String, Node.Type> nodeTriplet: nodes) {
            Node node = new Node(nodeTriplet.getX(), nodeTriplet.getZ(), nodeTriplet.getY());
            nodeList.add(node);
        }

        for (Triplet<Integer, Integer, Float> connectionTriplet: connections) {
            Node from = findID(nodeList, connectionTriplet.getX());
            Node to = findID(nodeList, connectionTriplet.getY());
            Float cost = connectionTriplet.getZ();
            if (from == null || to == null)
                throw new Exception("Connection list has wrong ids.");
            Connection connection = new Connection(from, to, cost);
            connectionList.add(connection);
        }

        return new Graph(nodeList, connectionList);
    }

    private Node findID(List<Node> nodeList, Integer id) {
        for (Node node: nodeList) {
            if (node.getId().equals(id)) {
                return node;
            }
        }
        return null;
    }

private Foxtrot getMethod(String method) throws Exception {
        Foxtrot search;
        if (method.equals("dfs")) {
            search = new FoxtrotDFS();
        }
        else if (method.equals("bfs")) {
            search = new FoxtrotBFS();
        }
        else if (method.equals("greedy")) {
            search = new FoxtrotGreedy();
        }
        else {
            throw new Exception("Unknown search method!");
        }
        return search;
    }

}


