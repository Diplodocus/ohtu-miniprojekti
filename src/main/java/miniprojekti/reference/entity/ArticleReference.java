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

    public List<String> validate() {

        List<String> err = new ArrayList<String>();
        if(this.getName().equals("")) {
            err.add("Name is a mandatory field.");
        }
        if(this.entries.get(AUTHOR).length()<=0) {
            err.add("Author is a mandatory field.");
        }
        if(this.entries.get(TITLE).length()<=0) {
            err.add("Title is a mandatory field.");
        }
        if(this.entries.get(JOURNAL).length()<=0) {
            err.add("Journal is a mandatory field.");
        }
        if(this.entries.get(YEAR).length()<=0) {
            err.add("Year is a mandatory field.");
        }
        if(this.entries.get(VOLUME).length()<=0) {
            err.add("Volume is a mandatory field.");
        }

        return err;
    }

}
