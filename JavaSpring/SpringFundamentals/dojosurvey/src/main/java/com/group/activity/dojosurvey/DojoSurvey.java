package com.group.activity.dojosurvey;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class DojoSurvey {
    @RequestMapping("")
    public String root(){
        return "root.jsp";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam String name, @RequestParam String location, @RequestParam String language, @RequestParam String comment, HttpSession session){
        session.setAttribute("name", name);
        session.setAttribute("location", location);
        session.setAttribute("language", language);
        session.setAttribute("comment", comment);
        if(language.equals("java")){
            return "javalovers.jsp";
        }
        return "redirect:/result";
    }
    @RequestMapping("/result")
    public String result(){
        return "result.jsp";
    }
    @RequestMapping("/destroy")
    public String destroy(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
