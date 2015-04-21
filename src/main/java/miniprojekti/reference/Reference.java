package miniprojekti.reference;

import miniprojekti.reference.generate.BibTexGenerator;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**

 */

public interface Reference {


    /*
    name of the article/book etc
     */
    String getName();

    /*
    could also be enum?
     */
    BibTexType getType();
    /*
      2 Lists of enums what data this kind of reference must an can contain
     */
    List<EntryType> getOptionalReferenceEntries();
    List<EntryType> getMandatoryReferenceEntries();

    /*
    map where the inputted data is saved
     */
    Map<EntryType, String> getEntries();



    void setEntries(EnumMap<EntryType, String> entries);
}
