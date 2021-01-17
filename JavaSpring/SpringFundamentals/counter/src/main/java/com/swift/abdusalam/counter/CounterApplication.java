package com.swift.abdusalam.counter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@SpringBootApplication
@Controller
public class CounterApplication {


    public static void main(String[] args) {
        SpringApplication.run(CounterApplication.class, args);
    }
    @RequestMapping("/your_server")
    public String home(HttpSession session){
        if(session.isNew()){
            session.setAttribute("count",0);
        }
        else{
            Integer count = (Integer) session.getAttribute("count");
            count+=1;
            session.setAttribute("count",count);
        }
        return "root.jsp";
    }
    @RequestMapping("/your_server/counter")
    public String counter(){
        return "counter.jsp";
    }
    @RequestMapping("/your_server/counter2")
    public String counter2(HttpSession session){
        if(session.isNew()){
            session.setAttribute("count",0);
        }
        else
            {
        Integer count = (Integer) session.getAttribute("count");
        count+=2;
        session.setAttribute("count",count);}
        return "counter2.jsp";
    }
    @RequestMapping("/your_server/destroy")
    public String destroy(HttpSession session){
        session.invalidate();
        return "redirect:/your_server";
    }
}
