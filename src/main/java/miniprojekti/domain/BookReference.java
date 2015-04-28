package miniprojekti.domain;

import miniprojekti.enums.EntryType;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static miniprojekti.enums.BibTexType.ARTICLE;
import static miniprojekti.enums.BibTexType.BOOK;
import static miniprojekti.enums.EntryType.*;
import static miniprojekti.enums.EntryType.VOLUME;
import static miniprojekti.enums.EntryType.YEAR;

/**
 * Created by cec on 28.4.2015.
 */
@Entity
public class BookReference extends AbstractReference{

    public BookReference(String name, Map<EntryType, String> entries) {
        super(name, entries
                , BOOK
                , new ArrayList<EntryType>(Arrays.asList(AUTHOR, TITLE, PUBLISHER, YEAR))
                , new ArrayList<EntryType>(Arrays.asList(NUMBER, VOLUME,SERIES,ADDRESS, EDITION,MONTH,NOTE,KEY)));
    }
    public BookReference(){
        super();
    }



    /*
    book
    //TODO should handle that one of two is mandatory now having author
    A book with an explicit publisher.
    Required fields: author/editor, title, publisher, year
    Optional fields: volume/number, series, address, edition, month, note, key
     */


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
        if(this.entries.get(PUBLISHER).length()<=0) {
            err.add("Publisher is a mandatory field.");
        }
        if(this.entries.get(YEAR).length()<=0) {
            err.add("Year is a mandatory field.");
        }


        return err;
    }



}
