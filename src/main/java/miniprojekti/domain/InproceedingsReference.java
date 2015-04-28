package miniprojekti.domain;

import miniprojekti.enums.BibTexType;
import miniprojekti.enums.EntryType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static miniprojekti.enums.BibTexType.*;
import static miniprojekti.enums.EntryType.*;

/**
 * Created by cec on 28.4.2015.
 */
public class InproceedingsReference extends AbstractReference{


    public InproceedingsReference(String name, Map<EntryType, String> entries) {
        super(name, entries
                , INPROCEEDINGS
                , new ArrayList<EntryType>(Arrays.asList(AUTHOR, TITLE, BOOKTITLE, YEAR))
                , new ArrayList<EntryType>(Arrays.asList(EDITOR, VOLUME, NUMBER, SERIES, PAGES, ADDRESS, MONTH, ORGANIZATION, PUBLISHER, NOTE, KEY)));
    }

        /*
    inproceedings
    An article in a conference proceedings.
    Required fields: author, title, booktitle, year
    Optional fields: editor, volume/number, series, pages, address, month, organization, publisher, note, key
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
        if(this.entries.get(BOOKTITLE).length()<=0) {
            err.add("Booktitle is a mandatory field.");
        }
        if(this.entries.get(YEAR).length()<=0) {
            err.add("Year is a mandatory field.");
        }

        return err;
    }

   
}