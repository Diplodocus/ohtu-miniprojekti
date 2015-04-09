/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojekti.controller;

import miniprojekti.repository.ReferenceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author vrsaari
 */
@Controller
public class BibtexController {

    private ReferenceRepository referenceRepository;

    @RequestMapping("/bibtex")
    public String list(Model model) {
        model.addAttribute("lista", referenceRepository.findAll());

        return "list";
    }
    
    @RequestMapping("/bibtex/{referenceId}")
    public String view(Model model) {
        
        return "view";
    }
    
    @RequestMapping(value = "/bibtex", method = RequestMethod.POST)
    public String add() {
        
        return "redirect:/bibtex/";
    }
    
    @RequestMapping(value = "/bibtex/{referenceId}", method = RequestMethod.POST)
    public String edit() {
        
        return "redirect:/bibtex/";
    }
}
