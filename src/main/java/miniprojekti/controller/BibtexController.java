/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojekti.controller;

import miniprojekti.reference.*;
import miniprojekti.reference.generate.BibTexGenerator;
import miniprojekti.repository.ReferenceRepository;
import miniprojekti.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private ReferenceService referenceService;

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
    public String addForm(ModelMap model) {
        EnumMap<EntryType, String> mappi = new EnumMap<EntryType, String>(EntryType.class);

        ArticleReference article = new ArticleReference("uusi", mappi);

        for(EntryType key:article.getMandatoryReferenceEntries()) {
            mappi.put(key, null);
        }
        for(EntryType key:article.getOptionalReferenceEntries()) {
            mappi.put(key, null);
        }
        article.setEntries(mappi);
        System.out.println(article.getEntries().toString());
        model.put("reference", article);
        model.addAttribute("mappi", mappi);
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
        AbstractReference ref = referenceService.createReference(parameterMap);
       // referenceRepository.save(ref);
        BibTexGenerator bg = new BibTexGenerator();
        System.out.println(ref.getEntries());
        model.addAttribute("bibtex", bg.generate(ref));
        //String bibtex = gen.generate(uusi);
        //model.addAttribute("reference", bibtex);

        return "view";
    }

    @RequestMapping(value = "/bibtex/{referenceId}", method = RequestMethod.POST)
    public String edit() {

        return "redirect:/bibtex/";
    }
}
