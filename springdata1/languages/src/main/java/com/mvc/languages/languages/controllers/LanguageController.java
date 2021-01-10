package com.mvc.languages.languages.controllers;

import com.mvc.languages.languages.models.Language;
import com.mvc.languages.languages.services.LanguageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LanguageController {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @RequestMapping("/languages")
    public String index(Model model,@ModelAttribute("language") Language language) {
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        return "root.jsp";
    }
    @RequestMapping(value="/languages", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result,Model model) {
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        if (result.hasErrors()) {
            return "root.jsp";
        } else {
            languageService.createLanguage(language);
            return "redirect:/languages";
        }
       }
    @RequestMapping("/languages/{id}")
    public String show(@PathVariable(value = "id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "show.jsp";
    }
    @RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "edit.jsp";
    }

    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            languageService.updateLanguage(language.getId(),language.getName(),language.getCreator(),language.getCurrentVersion());
            return "redirect:/languages";
        }
    }
    @RequestMapping(value="/languagess/{id}")
    public String destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
}
