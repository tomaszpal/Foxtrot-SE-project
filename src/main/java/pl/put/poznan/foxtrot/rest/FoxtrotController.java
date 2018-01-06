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
    public Foxtrot foxtrot(@PathVariable String text, @RequestParam(value="transforms", defaultValue="upper,escape") String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));
        System.out.println(Arrays.toString(transforms));
        System.out.println(text);

        // do the transformation, you should run your logic here, below just a silly example
        return new Foxtrot(transforms, text);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@PathVariable String text,
                      @RequestBody String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // do the transformation, you should run your logic here, below just a silly example
//        Foxtrot transformer = new Foxtrot(transforms);
//        return transformer.transform(text);
        return "Hello POST";
    }



}


