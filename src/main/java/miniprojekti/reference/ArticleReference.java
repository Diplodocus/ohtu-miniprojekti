package miniprojekti.reference;

import java.util.*;

import static miniprojekti.reference.BibTexType.*;
import static miniprojekti.reference.EntryType.*;

/**
 * Created by cec on 8.4.2015.
 */
public class ArticleReference extends AbstractReference {


    public ArticleReference(String name, EnumMap<EntryType, String> entries) {
        super(name, entries
                , ARTICLE
                , new ArrayList<EntryType>(Arrays.asList(AUTHOR, TITLE, JOURNAL, YEAR, VOLUME))
                , new ArrayList<EntryType>(Arrays.asList(NUMBER,PAGES,MONTH,NOTE,KEY)));
    }


}
