package miniprojekti.reference;

import javax.print.attribute.standard.PagesPerMinute;

/*
 */
public enum EntryType {

    AUTHOR,
    TITLE,
    JOURNAL,
    YEAR,
    VOLUME,
    NUMBER,
    PAGES,
    MONTH,
    NOTE,
    KEY;


   public String getName(){
       return name().toLowerCase();
   }

}
