/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojekti.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import static miniprojekti.enums.BibTexType.*;
import miniprojekti.enums.EntryType;
import static miniprojekti.enums.EntryType.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author johanna
 */
public class BookReferenceInterfaceTest {

    BookReference bookReference;
    BookReference bookReference2;
    BookReference bookReference3;

    @Before
    public void setUp() {
        EnumMap<EntryType, String> entries;
        entries = new EnumMap<EntryType, String>(EntryType.class);
        entries.put(AUTHOR, "Spohrer, James C. and Soloway, Elliot");
        entries.put(TITLE, "Novice mistakes: are the folk wisdoms correct?");
        entries.put(PUBLISHER, "ASD");
        entries.put(VOLUME, "29");
        entries.put(NUMBER, "7");
        entries.put(YEAR, "1986");
        entries.put(PAGES, "624--632");
        bookReference = new BookReference("SS86", entries);

        EnumMap<EntryType, String> entries2;
        entries2 = new EnumMap<EntryType, String>(EntryType.class);
        entries2.put(PAGES, "14--16");
        bookReference2 = new BookReference("SS87", entries2);

        EnumMap<EntryType, String> entries3;
        entries3 = new EnumMap<EntryType, String>(EntryType.class);
        entries3.put(AUTHOR, "");
        entries3.put(TITLE, "");
        entries3.put(JOURNAL, "");
        entries3.put(VOLUME, "");
        entries3.put(NUMBER, "");
        entries3.put(YEAR, "");
        bookReference3 = new BookReference("SS86", entries3);
    }

    @Test
    public void setNameForBookReference() {
        assertEquals("SS86", bookReference.getName());
    }

    @Test
    public void referenceTypeIsSetToBook() {
        assertEquals(BOOK, bookReference.getType());
    }

    @Test
    public void mandatoryReferenceEntriesForBookSetCorrectly() {

        ArrayList<EntryType> mandatoryList;
        mandatoryList = new ArrayList<EntryType>(Arrays.asList(AUTHOR, TITLE, PUBLISHER, YEAR));

        assertEquals(mandatoryList, bookReference.getMandatoryReferenceEntries());
    }

    @Test
    public void optionalReferenceEntriesForBookSetCorrectly() {
        ArrayList<EntryType> optionalList;
        optionalList = new ArrayList<EntryType>(Arrays.asList(NUMBER, VOLUME, SERIES, ADDRESS, EDITION, MONTH, NOTE, KEY));

        assertEquals(optionalList, bookReference.getOptionalReferenceEntries());
    }

    @Test
    public void settingEntriesForBookWorks() {

        EnumMap<EntryType, String> entries2;
        entries2 = new EnumMap<EntryType, String>(EntryType.class);
        entries2.put(AUTHOR, "Juupajuu");
        entries2.put(TITLE, "Juupajuun tarinoita");

        bookReference.setEntries(entries2);

        assertEquals(bookReference.getEntries(), entries2);
    }
    
  @Test
    public void bookValidatePassesWithAllMandatoryFields() {
        List<String> err = new ArrayList<String>();
        assertEquals(bookReference.validate(), err);

    }

    @Test
    public void bookValidateFailsWhenMissingMandatoryFields() {
        List<String> err = new ArrayList<String>();

        err.add("Author is a mandatory field.");
        err.add("Title is a mandatory field.");
        err.add("Publisher is a mandatory field.");
        err.add("Year is a mandatory field.");

        assertEquals(bookReference2.validate(), err);

    }

    @Test
    public void bookValidateFailsWhenFieldEntriesAreInvalid() {
        List<String> err = new ArrayList<String>();

        err.add("Author is a mandatory field.");
        err.add("Title is a mandatory field.");
        err.add("Publisher is a mandatory field.");
        err.add("Year is a mandatory field.");

        assertEquals(bookReference3.validate(), err);

    }
}
