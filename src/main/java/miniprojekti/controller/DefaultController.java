package miniprojekti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import miniprojekti.model.Person;
import miniprojekti.service.PersonService;
import java.util.Map;

@Controller
public class DefaultController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/")
    public String listPeople(Model model) {

//        Person p = new Person();
//        p.setFirstName("Torsti");
//        p.setLastName("Torstai");
//        model.addAttribute("torsti", p);
//        model.addAttribute("peopleList", personService.listPeople());

        return "redirect:/bibtex";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person person, BindingResult result) {

        personService.addPerson(person);

        return "redirect:/people/";
    }

    @RequestMapping("/delete/{personId}")
    public String deletePerson(@PathVariable("personId") Integer personId) {

        personService.removePerson(personId);

        return "redirect:/people/";
    }
}
