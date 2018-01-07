package pl.put.poznan.foxtrot.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.foxtrot.logic.Foxtrot;
import pl.put.poznan.foxtrot.logic.Network;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.put.poznan.foxtrot.logic.NetworkWrapper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;


@RestController
@RequestMapping("/{text}")
public class FoxtrotController {

    private static final Logger logger = LoggerFactory.getLogger(FoxtrotController.class);
    public static NetworkWrapper networkWrapper = new NetworkWrapper();

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Foxtrot foxtrot(@PathVariable String text, @RequestParam(value="transforms", defaultValue="upper,escape") String[] transforms) {
        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));
        System.out.println(Arrays.toString(transforms));
        System.out.println(text);
        return new Foxtrot(transforms, text);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public Network post (@RequestBody Network receivedNetwork) throws JsonProcessingException {
        if(receivedNetwork != null) {
            networkWrapper.AddToNetworkList(receivedNetwork);
        } else {
            System.out.println("Received object is null!");
        }
        return receivedNetwork;
    }



}


