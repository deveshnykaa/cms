package com.HelloWorld.PrintHelloWorld.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HW {
    @RequestMapping(value = "/hello")
    public String sayHello(){
        return  "Hello World";
    }
}
