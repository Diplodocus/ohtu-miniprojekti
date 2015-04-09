package miniprojekti.reference;

import javax.print.attribute.standard.PagesPerMinute;

/**
 * Created by cec on 1.4.2015.,
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
