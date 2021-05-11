package main;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController

public class DefaultController {
    @RequestMapping("/")
    public ResponseEntity<Date> getCountry() {

        var headers = new HttpHeaders();
        headers.add("Responded", "DefaultController");

        return ResponseEntity.ok(new Date());
    }
}
