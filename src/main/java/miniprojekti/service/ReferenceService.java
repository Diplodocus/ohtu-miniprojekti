package miniprojekti.service;

import miniprojekti.domain.AbstractReference;
import miniprojekti.domain.ArticleReference;
import miniprojekti.enums.EntryType;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/**
 * Created by vrsaari on 20/04/15.
 */

@Service
public class ReferenceService {
    public AbstractReference createReference(Map<String, String[]> entries) {

        EnumMap<EntryType, String> mappi = new EnumMap<EntryType, String>(EntryType.class);

        AbstractReference article = new ArticleReference("uusi", mappi);

        for (Map.Entry<String, String[]> entry : entries.entrySet()) {

            System.out.println(entry.getKey() + " = " + Arrays.toString(entry.getValue()));
            if(entry.getKey().equals("name")) {
                article.setName(entry.getValue()[0]);
            } else{
                System.out.println(EntryType.valueOf(entry.getKey()));
                mappi.put(EntryType.valueOf(entry.getKey()), entry.getValue()[0]);
            }
        }
        article.setEntries(mappi);
        return article;
    }
}
