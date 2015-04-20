package miniprojekti.reference;

import javax.persistence.Entity;
import java.util.*;

import static miniprojekti.reference.BibTexType.*;
import static miniprojekti.reference.EntryType.*;

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
