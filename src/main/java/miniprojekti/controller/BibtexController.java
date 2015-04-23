/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojekti.controller;

import miniprojekti.Domain.AbstractReference;
import miniprojekti.Domain.ArticleReference;
import miniprojekti.enums.EntryType;
import miniprojekti.service.BibTexGenerator;
import miniprojekti.repository.ReferenceRepository;
import miniprojekti.service.BibtexService;
import miniprojekti.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author vrsaari
 */
@Controller
public class BibtexController {

    @Autowired
    private ReferenceRepository referenceRepository;

    @Autowired
    private ReferenceService referenceService;

    @Autowired
    private BibtexService bes;

    @RequestMapping("/bibtex")
    public String list(Model model) {
       bes.getFrontPage(model);

        return "list";

    }

    @RequestMapping("/bibtex/{referenceId}")
    public String view(Model model, @PathVariable("referenceId") Long referenceId) {

        bes.viewReference(model,referenceId);

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
        model.put("reference", article);
        model.addAttribute("mappi", mappi);
        model.addAttribute("mandatory", article.getMandatoryReferenceEntries());
        model.addAttribute("optional", article.getOptionalReferenceEntries());
        return "new";
    }

    /**
     * Kutsuu serviceä hoitamaan lisäyksen, palauttaa LONG.Maxvaluen mikäli formissa virheitä.
     * @param req
     * @param model
     * @return
     */
    @RequestMapping(value = "/bibtex/add", method = RequestMethod.POST)
    public String add(HttpServletRequest req, Model model) {
         long refID = bes.addReference(req,model);

        if(refID == Long.MAX_VALUE) {
            return "new";
        }

        return "redirect:/bibtex/" + refID;
    }

    @RequestMapping(value = "/bibtex/delete/{referenceId}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("referenceId") Long referenceId) {

        referenceRepository.delete(referenceId);

        return "redirect:/bibtex/";
    }

    @RequestMapping(value = "bibtex/edit/{referenceId}", method = RequestMethod.GET)
    public String edit(@PathVariable("referenceId") Long referenceId, Model model) {

        AbstractReference ref = referenceRepository.findOne(referenceId);

        model.addAttribute("reference", ref);
        return "edit";
    }

    @RequestMapping(value = "/bibtex/edit/{referenceId}", method = RequestMethod.POST)
    public String change(@PathVariable("referenceId") Long referenceId, HttpServletRequest req) {

        bes.editReference(referenceId,req);

        return "redirect:/bibtex/"+referenceId;
    }

}
