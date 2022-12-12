package com.codestates.section3week1.coffee;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/coffees", produces = MediaType.APPLICATION_JSON_VALUE)
public class CoffeeController {
}
