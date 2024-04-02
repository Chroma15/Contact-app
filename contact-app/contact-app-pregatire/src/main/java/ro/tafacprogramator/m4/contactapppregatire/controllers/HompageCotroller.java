package ro.tafacprogramator.m4.contactapppregatire.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HompageCotroller {

    @GetMapping("/")
    String homepage() {
        return "Hello there";
    }

}
