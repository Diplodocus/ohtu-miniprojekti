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
public class InproceedingsReferenceInterfaceTest {

    InproceedingsReference inproceedingsReference;
    InproceedingsReference inproceedingsReference2;
    InproceedingsReference inproceedingsReference3;

    @Before
    public void setUp() {
        EnumMap<EntryType, String> entries;
        entries = new EnumMap<EntryType, String>(EntryType.class);
        entries.put(AUTHOR, "Spohrer, James C. and Soloway, Elliot");
        entries.put(TITLE, "Novice mistakes: are the folk wisdoms correct?");
        entries.put(BOOKTITLE, "ASD");
        entries.put(VOLUME, "29");
        entries.put(NUMBER, "7");
        entries.put(YEAR, "1986");
        entries.put(PAGES, "624--632");
        inproceedingsReference = new InproceedingsReference("SS86", entries);

        EnumMap<EntryType, String> entries2;
        entries2 = new EnumMap<EntryType, String>(EntryType.class);
        entries2.put(PAGES, "14--16");
        inproceedingsReference2 = new InproceedingsReference("SS87", entries2);

        EnumMap<EntryType, String> entries3;
        entries3 = new EnumMap<EntryType, String>(EntryType.class);
        entries3.put(AUTHOR, "");
        entries3.put(TITLE, "");
        entries3.put(BOOKTITLE, "");
        entries3.put(YEAR, "");
        inproceedingsReference3 = new InproceedingsReference("SS86", entries3);
    }

    @Test
    public void setNameForInproceedingsReference() {
        assertEquals("SS86", inproceedingsReference.getName());
    }

    @Test
    public void referenceTypeIsSetToInproceedings() {
        assertEquals(INPROCEEDINGS, inproceedingsReference.getType());
    }

    @Test
    public void mandatoryReferenceEntriesForInproceedingsSetCorrectly() {

        ArrayList<EntryType> mandatoryList;
        mandatoryList = new ArrayList<EntryType>(Arrays.asList(AUTHOR, TITLE, BOOKTITLE, YEAR));

        assertEquals(mandatoryList, inproceedingsReference.getMandatoryReferenceEntries());
    }

    @Test
    public void optionalReferenceEntriesForInproceedingsSetCorrectly() {
        ArrayList<EntryType> optionalList;
        optionalList = new ArrayList<EntryType>(Arrays.asList(EDITOR, VOLUME, NUMBER, SERIES, PAGES, ADDRESS, MONTH, ORGANIZATION, PUBLISHER, NOTE, KEY));

        assertEquals(optionalList, inproceedingsReference.getOptionalReferenceEntries());
    }

    @Test
    public void settingEntriesForInproceedingsWorks() {

        EnumMap<EntryType, String> entries2;
        entries2 = new EnumMap<EntryType, String>(EntryType.class);
        entries2.put(AUTHOR, "Juupajuu");
        entries2.put(TITLE, "Juupajuun tarinoita");

        inproceedingsReference.setEntries(entries2);

        assertEquals(inproceedingsReference.getEntries(), entries2);
    }

    @Test
    public void inproceedingsValidatePassesWithAllMandatoryFields() {
        List<String> err = new ArrayList<String>();
        assertEquals(inproceedingsReference.validate(), err);

    }

    @Test
    public void inproceedingsValidateFailsWhenMissingMandatoryFields() {
        List<String> err = new ArrayList<String>();

        err.add("Author is a mandatory field.");
        err.add("Title is a mandatory field.");
        err.add("Booktitle is a mandatory field.");
        err.add("Year is a mandatory field.");

        assertEquals(inproceedingsReference2.validate(), err);

    }

    @Test
    public void inproceedingsValidateFailsWhenFieldEntriesAreInvalid() {
        List<String> err = new ArrayList<String>();

        err.add("Author is a mandatory field.");
        err.add("Title is a mandatory field.");
        err.add("Booktitle is a mandatory field.");
        err.add("Year is a mandatory field.");

        assertEquals(inproceedingsReference3.validate(), err);
    }


}
