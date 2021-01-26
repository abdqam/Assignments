package com.swift.abdusalam.human;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/your_server")
public class HumanApplication {

    public static void main(String[] args) {
        SpringApplication.run(HumanApplication.class, args);
    }

    @RequestMapping("")
    public String name(@RequestParam(value = "firstname",required = false)String firstName, @RequestParam(value = "lastname",required = false) String lastName){
        if(firstName==null){
            return "<br><h1>Hello Human</h1><br><p>Welcome to SpringBoot</p>";
        }
        else
            return "<br><h1>Hello "+firstName+" "+ lastName+"</h1><a href='/your_server' style='float:right;font-size:large;'>Go back</a><br><p>Welcome to SpringBoot</p>";
    }

}