package com.swift.overflow.overflow.controllers;

import com.swift.overflow.overflow.models.Answer;
import com.swift.overflow.overflow.models.Question;
import com.swift.overflow.overflow.models.Tag;
import com.swift.overflow.overflow.services.OverflowService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class OverflowController {
    private final OverflowService overflowService;

    public OverflowController(OverflowService overflowService) {
        this.overflowService = overflowService;
    }
    @RequestMapping("/questions")
    public String dashboard(Model model){
        model.addAttribute("questions",overflowService.allQuestion());
        return "questions.jsp";
    }

    @RequestMapping("/questions/new")
    public String newQuestion(@ModelAttribute("newquestion") Question question, @ModelAttribute("tag") Tag tag){
        return "newQuestion.jsp";
    }
    @RequestMapping(value = "/questions/new",method = RequestMethod.POST)
    public String createQuestion(@Valid @ModelAttribute("newquestion")Question question,@Valid @ModelAttribute("tag") Tag tag, BindingResult result){
        if(result.hasErrors()){
            return "newQuestion.jsp";
        }
        else{
            Question question1=overflowService.addQuestion(question,tag);
            return "redirect:/questions";
        }
    }
    @RequestMapping("/questions/{id}")
    public String showQuestion(@PathVariable("id")Long id,Model model,@ModelAttribute("answers") Answer answer){
        model.addAttribute("question",overflowService.findQuestion(id));
        return "questionProfile.jsp";
    }
    @RequestMapping(value = "/questions/{id}", method = RequestMethod.POST)
    public String createAnswer(@Valid @ModelAttribute("answers") Answer answer, BindingResult result, @PathVariable("id")Long id) {
        if (result.hasErrors()) {
            return "newanswer.jsp";
        } else {
            overflowService.createQuestionAnswer(id,answer);
            return "redirect:/questions/"+id;
        }
    }
}
