package com.swift.abdusalam.gettingfimiliarwithrouting;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
    @RequestMapping("/{name}")
    public String variable(@PathVariable("name") String word){
        if(word.equals("dojo")){
            return "The dojo is awesome!";
        }
        else if (word.equals("burbank-dojo")) {
            return "Burbank Dojo is located in Southern California";
        }
        else if (word.equals("san-jose")) {
            return "SJ dojo is the headquarters";
        }
        else
            return "Bad Request";
    }
}
