package miniprojekti.service;

import miniprojekti.enums.EntryType;
import miniprojekti.reference.entity.AbstractReference;
import miniprojekti.reference.entity.ArticleReference;
import miniprojekti.repository.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tixtixti on 23.4.15.
 */
@Service
public class BibtexService {

    @Autowired
    private ReferenceRepository referenceRepository;

    @Autowired
    private ReferenceService referenceService;

    public void editReference( Long referenceId, HttpServletRequest req){
        AbstractReference vanha = referenceRepository.findOne(referenceId);
        Map<String, String[]> parameterMap = req.getParameterMap();
        AbstractReference ref = referenceService.createReference(parameterMap);
        vanha.setEntries((EnumMap) ref.getEntries());
        vanha.setName(ref.getName());
        referenceRepository.save(vanha);
    }

    /**
     * Lisää Referencen tietokantaan, palauttaa controlleri true, jos kaikki meni hyvin ja false jos oli virheitä
     * @param req
     * @param model
     * @return
     */
    public Long addReference(HttpServletRequest req, Model model) {
        Map<String, String[]> parameterMap = req.getParameterMap();
        AbstractReference ref = referenceService.createReference(parameterMap);
        List<String> err = ref.validate();
        if(!err.isEmpty()) {
            model.addAttribute("reference", ref);
            model.addAttribute("errors", err);
            return Long.MAX_VALUE;
        }
        referenceRepository.save(ref);
        return ref.getId();

    }
    public void viewReference(Model model, Long referenceId){
        AbstractReference ref = referenceRepository.findOne(referenceId);
        model.addAttribute("bibtex", new BibTexGenerator().generate(ref));
        model.addAttribute("ref", ref);
    }
    public void getFrontPage(Model model){
        List<AbstractReference> references = new ArrayList<AbstractReference>();
        EnumMap<EntryType, String> sisalto = new EnumMap<EntryType, String>(EntryType.class);
        AbstractReference article = new ArticleReference("uusi", new EnumMap<EntryType, String>(EntryType.class));
        model.addAttribute("mandatory", article.getMandatoryReferenceEntries());
        model.addAttribute("optional", article.getOptionalReferenceEntries());

        List<AbstractReference> reposta = referenceRepository.findAll();

        if (reposta != null && reposta.size() >= 1) {
            for (AbstractReference ref : reposta) {
                if (ref != null) {
                    references.add(ref);
                }
            }
        }
        model.addAttribute("lista", references);
    }
}
