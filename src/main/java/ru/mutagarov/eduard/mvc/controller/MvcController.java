package ru.mutagarov.eduard.mvc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ru.mutagarov.eduard.mvc.model.Person;
import ru.mutagarov.eduard.mvc.model.PersonDataService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class MvcController {
    @Autowired
    private PersonDataService personDataService;

    @GetMapping(value = "/")
    public ModelAndView home() {
        List<Person> listPerson = personDataService.listAll();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("listPerson", listPerson);
        return mav;
    }

    @GetMapping("/newPerson")
    public Map<String,Object> newPerson(Map<String,Object> model) {
        Person person = new Person();
        model.put("person", person);
        return model;
    }

    @PostMapping("/save")
    public RedirectView saveCustomer(@ModelAttribute("person") Person person) {
        personDataService.save(person);
        return new RedirectView("/");
    }

    @GetMapping("/edit")
    public ModelAndView editCustomerForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("editPerson");
        Person person = personDataService.get(id);
        mav.addObject("person", person);
        return mav;
    }

    @GetMapping("/delete")
    public RedirectView deleteCustomerForm(@RequestParam long id) {
        personDataService.delete(id);
        return new RedirectView("/");
    }
}