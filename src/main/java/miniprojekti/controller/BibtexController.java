/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojekti.controller;

import miniprojekti.domain.AbstractReference;
import miniprojekti.domain.ArticleReference;
import miniprojekti.domain.BookReference;
import miniprojekti.domain.InproceedingsReference;
import miniprojekti.enums.EntryType;
import miniprojekti.repository.ReferenceRepository;
import miniprojekti.service.BibtexService;
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
    private BibtexService bibtexService;

    @RequestMapping("/bibtex")
    public String list(Model model) {
       bibtexService.getFrontPage(model);

        return "list";

    }

    @RequestMapping("/bibtex/{referenceId}")
    public String view(Model model, @PathVariable("referenceId") Long referenceId) {

        bibtexService.viewReference(model, referenceId);

        return "view";
    }

    /**
     * Ottaa PathVariablesta tyypin ja tekee lomakkeen sen mukaan
     * @param type
     * @param model
     * @return
     */
    @RequestMapping("/bibtex/add/{type}")
    public String addForm(@PathVariable ("type") String type, ModelMap model) {
        EnumMap<EntryType, String> mappi = new EnumMap<EntryType, String>(EntryType.class);
        AbstractReference article = null;

        if(type.equals("article")){
             article = new ArticleReference("uusi", mappi);

        } else if (type.equals("book")){
             article = new BookReference("uusi", mappi);
        } else {
            article = new InproceedingsReference("uusi", mappi);
        }

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
    @RequestMapping(value = "/bibtex/add/{type}", method = RequestMethod.POST)
    public String add(@PathVariable("type") String type, HttpServletRequest req, Model model) {

         long refID = bibtexService.addReference(type,req,model);

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

        bibtexService.editReference(referenceId, req);

        return "redirect:/bibtex/"+referenceId;
    }

    @RequestMapping("/bibtex/all")
    public String view(Model model) {

        bibtexService.viewAllBibtex(model);

        return "all";
    }

}
