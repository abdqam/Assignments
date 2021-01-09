package com.swift.abdusalam.bookschema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class BookschemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookschemaApplication.class, args);
    }
    @RequestMapping("")
    public String root(){
        return "root.jsp";
    }


}
