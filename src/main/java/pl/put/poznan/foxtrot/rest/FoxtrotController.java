package pl.put.poznan.foxtrot.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.foxtrot.logic.Foxtrot;

import java.util.Arrays;


@RestController
@RequestMapping("/{text}")
public class FoxtrotController {

    private static final Logger logger = LoggerFactory.getLogger(FoxtrotController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String text,
                              @RequestParam(value="transforms", defaultValue="upper,escape") String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // do the transformation, you should run your logic here, below just a silly example
        Foxtrot transformer = new Foxtrot(transforms);
        return transformer.transform(text);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@PathVariable String text,
                      @RequestBody String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // do the transformation, you should run your logic here, below just a silly example
        Foxtrot transformer = new Foxtrot(transforms);
        return transformer.transform(text);
    }



}


