package car.web.rest;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloRest {

    @GetMapping("/hello")
    String sayHello() {return "Hey Universe!";}
}
