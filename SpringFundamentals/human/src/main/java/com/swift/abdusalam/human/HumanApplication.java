package com.swift.abdusalam.human;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/your_server")
public class HumanApplication {

    public static void main(String[] args) {
        SpringApplication.run(HumanApplication.class, args);
    }
    @RequestMapping("")
    public String human(){
        return "<br><h1>Hello Human</h1><br><p>Welcome to SpringBoot</p>";
    }

    @RequestMapping("/{first_name}")
    public String name(@PathVariable("first_name") String firstName){
            return "<br><h1>Hello "+firstName+"</h1><a href='/your_server' style='float:right;font-size:large;'>Go back</a><br><p>Welcome to SpringBoot</p>";
    }
    @RequestMapping("/{first_name}/{last_name}")
    public String fullname(@PathVariable("first_name") String firstName,@PathVariable("last_name") String lastName){
        return "<br><h1>Hello "+firstName+" "+lastName+"</h1><a href='/your_server' style='float:right;font-size:large;'>Go back</a><br><p>Welcome to SpringBoot</p>";
    }

}
