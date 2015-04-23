package miniprojekti.domain;

import miniprojekti.enums.BibTexType;
import miniprojekti.enums.EntryType;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**

 */

public interface ReferenceInterface {


    /*
    name of the article/book etc
     */
    String getName();

    /*
    could also be enum?
     */
    BibTexType getType();
    /*
      2 Lists of enums what data this kind of Domain must an can contain
     */
    List<EntryType> getOptionalReferenceEntries();
    List<EntryType> getMandatoryReferenceEntries();

    /*
    map where the inputted data is saved
     */
    Map<EntryType, String> getEntries();



    void setEntries(EnumMap<EntryType, String> entries);

}
