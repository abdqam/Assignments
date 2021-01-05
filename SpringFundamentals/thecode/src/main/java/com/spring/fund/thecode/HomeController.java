package com.spring.fund.thecode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(){
        return "index.jsp";
    }
    @RequestMapping(value = "/checkcode",method = RequestMethod.POST)
    public String checkcode(@RequestParam(value = "code")String code){
        if(code.equals("bushido"))
            return "redirect:/code";
        return "redirect:/loaderrors";
    }
    @RequestMapping("/code")
    public String code(Model model){
        return "code.jsp";
    }
    @RequestMapping("/loaderrors")
    public String loadErorrs(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("error","you must train harder!");
        return "redirect:/";
    }

}
