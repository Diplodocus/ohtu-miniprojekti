/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojekti.controller;

import miniprojekti.reference.*;
import miniprojekti.repository.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import static miniprojekti.reference.EntryType.*;
import static miniprojekti.reference.BibTexType.*;

/**
 * @author vrsaari
 */
@Controller
public class BibtexController {

    @Autowired
    private ReferenceRepository referenceRepository;

    @RequestMapping("/bibtex")
    public String list(Model model) {
        List<AbstractReference> references = new ArrayList<AbstractReference>();
        EnumMap<EntryType, String> sisalto = new EnumMap<EntryType, String>(EntryType.class);

        references.add(new ArticleReference(
                        "nimi",
                        sisalto
                )
        );
        references.add(new ArticleReference(
                        "toinen nimi",
                        sisalto
                )
        );
        List<AbstractReference> reposta = referenceRepository.findAll();
        if (reposta != null || reposta.size() < 1) {
            for (AbstractReference ref : reposta) {
                if (ref != null) {
                    references.add(ref);
                }
            }
        }
        model.addAttribute("lista", references);

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
