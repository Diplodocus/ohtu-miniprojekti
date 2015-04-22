package miniprojekti.reference.entity;

import miniprojekti.enums.EntryType;
import miniprojekti.reference.entity.AbstractReference;

import javax.persistence.Entity;
import java.util.*;

import static miniprojekti.enums.BibTexType.*;
import static miniprojekti.enums.EntryType.*;

/**

 */
@Entity
public class ArticleReference extends AbstractReference {


    public ArticleReference(String name, Map<EntryType, String> entries) {
        super(name, entries
                , ARTICLE
                , new ArrayList<EntryType>(Arrays.asList(AUTHOR, TITLE, JOURNAL, YEAR, VOLUME))
                , new ArrayList<EntryType>(Arrays.asList(NUMBER,PAGES,MONTH,NOTE,KEY)));
    }

    public ArticleReference() {
        super();
    }


}
