package pl.put.poznan.foxtrot.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.foxtrot.logic.*;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;


@RestController
@RequestMapping("/api")
public class FoxtrotController {

    private static final Logger logger = LoggerFactory.getLogger(FoxtrotController.class);
    Graph graph;

    //Response to GET request
    @CrossOrigin()
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Path get (@RequestParam(value="method") String method, @RequestParam(value="nodeList") List<Triplet<Integer, String, Node.Type>> nodeList,
                     @RequestParam(value="connections") List<Triplet<Integer, Integer, Integer>> connectionList) throws JsonProcessingException {
        Path result = null;


        logger.debug("[API] GET Method!");

        return result;
    }

    //Response to POST request
    @CrossOrigin()
    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public Path post (@RequestBody Graph graph, @RequestParam(value="method") String method) throws JsonProcessingException {
        Path result = null;
        this.graph = graph;
        System.out.println(method);

        logger.debug("[API] POST Method!");

        return result;
    }



}


