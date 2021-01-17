package com.mvc.license.license.controllers;

import com.mvc.license.license.models.License;
import com.mvc.license.license.models.Person;
import com.mvc.license.license.services.LicenseService;
import com.mvc.license.license.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PersonController {
    private final PersonService personService;
    private final LicenseService licenseService;

    public PersonController(PersonService personService, LicenseService licenseService) {
        this.personService = personService;
        this.licenseService = licenseService;
    }

    @RequestMapping("")
    public String main() {
        return "root.jsp";
    }

    @RequestMapping("/persons/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "new.jsp";
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "new.jsp";
        } else {
            Person person1=personService.createPerson(person);
            return "redirect:/";
        }
    }
    @RequestMapping("/persons/{id}")
    public String show(@PathVariable("id")Long id, Model model){
        License license=licenseService.findLicense(id);
        model.addAttribute("license",license);
        return "show.jsp";
    }
    @RequestMapping("/license/new")
    public String newLicense(@ModelAttribute("license") License license, Model model) {
        model.addAttribute("persons",personService.unlicensedPersons());
        return "license.jsp";
    }
    @RequestMapping(value = "/license",method = RequestMethod.POST)
    public String createlicense(@Valid @ModelAttribute("license") License license, BindingResult result, @RequestParam("person")Long id) {
        Person person1 = personService.findPerson(id);
        if (result.hasErrors()) {
            return "new.jsp";
        } else {
            License license1=licenseService.createLicense(license);
            licenseService.createLicenseWithPerson(license1,person1);
            return "redirect:/persons/"+license1.getId();
        }
    }


}
