/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojekti.controller;

import miniprojekti.reference.*;
import miniprojekti.reference.generate.BibTexGenerator;
import miniprojekti.repository.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

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
        AbstractReference article = new ArticleReference("uusi", new EnumMap<EntryType, String>(EntryType.class));
        model.addAttribute("mandatory", article.getMandatoryReferenceEntries());
        model.addAttribute("optional", article.getOptionalReferenceEntries());

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
    public String view(Model model, @PathVariable("referenceId") Long referenceId) {
        AbstractReference reference = referenceRepository.findOne(referenceId);
        model.addAttribute("reference", reference);
        return "view";
    }

    @RequestMapping("/bibtex/add")
    public String addForm(Model model) {
        ArticleReference article = new ArticleReference("uusi", new EnumMap<EntryType, String>(EntryType.class));
        model.addAttribute("reference", article);
        model.addAttribute("mandatory", article.getMandatoryReferenceEntries());
        model.addAttribute("optional", article.getOptionalReferenceEntries());
        return "new";
    }

    @RequestMapping(value = "/bibtex/add", method = RequestMethod.POST)
    public String add(HttpServletRequest req, Model model) {
        Map<String, String[]> parameterMap = req.getParameterMap();

        //AbstractReference ref = new ArticleReference(parameterMap.get("name")[0], parameterMap.get("entries"));
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {

            System.out.println(entry.getKey() + " = " + Arrays.toString(entry.getValue()));
        }
        BibTexGenerator gen = new BibTexGenerator();
        //String bibtex = gen.generate(uusi);
        //model.addAttribute("reference", bibtex);

        return "view";
    }

    @RequestMapping(value = "/bibtex/{referenceId}", method = RequestMethod.POST)
    public String edit() {

        return "redirect:/bibtex/";
    }
}
