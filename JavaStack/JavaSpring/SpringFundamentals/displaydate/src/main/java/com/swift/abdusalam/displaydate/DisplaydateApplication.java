package com.swift.abdusalam.displaydate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootApplication
@Controller
public class DisplaydateApplication {

    public static void main(String[] args) {
        SpringApplication.run(DisplaydateApplication.class, args);
    }
    @RequestMapping("")
    public String root(){
        return "root.jsp";
    }
    @RequestMapping("/date")
    public String date(Model model){
        Date date =new Date();
        model.addAttribute("date",new SimpleDateFormat("EEEE, 'the' dd 'of' MMMM, yyyy").format(date));
        return "date.jsp";
    }
    @RequestMapping("/time")
    public String time(Model model){
        Date time =new Date();
        model.addAttribute("time",new SimpleDateFormat("hh:mm a").format(time));

        return "time.jsp";
    }

}
