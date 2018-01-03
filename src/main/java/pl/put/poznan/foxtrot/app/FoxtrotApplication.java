package pl.put.poznan.foxtrot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.foxtrot.rest"})
public class FoxtrotApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoxtrotApplication.class, args);
    }
}
