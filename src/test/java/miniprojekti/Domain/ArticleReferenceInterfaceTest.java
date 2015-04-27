/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojekti.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;

import miniprojekti.enums.EntryType;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static miniprojekti.enums.EntryType.*;
import static miniprojekti.enums.BibTexType.*;

public class ArticleReferenceInterfaceTest {

    ArticleReference articleReference;
    ArticleReference articleReference2;

    @Before
    public void setUp() {
        EnumMap<EntryType, String> entries;
        entries = new EnumMap<EntryType, String>(EntryType.class);
        entries.put(AUTHOR, "Spohrer, James C. and Soloway, Elliot");
        entries.put(TITLE, "Novice mistakes: are the folk wisdoms correct?");
        entries.put(JOURNAL, "Commun. ACM");
        entries.put(VOLUME, "29");
        entries.put(NUMBER, "7");
        entries.put(YEAR, "1986");
        entries.put(PAGES, "624--632");
        articleReference = new ArticleReference("SS86", entries);

        EnumMap<EntryType, String> entries2;
        entries2 = new EnumMap<EntryType, String>(EntryType.class);
        entries2.put(AUTHOR, "Juupajuu");
        entries2.put(TITLE, "Juupajuun tarinoita");
        entries2.put(JOURNAL, "Asd");
        entries2.put(VOLUME, "4");
        entries2.put(NUMBER, "2");
        entries2.put(YEAR, "2015");
        entries2.put(PAGES, "14--16");
        articleReference2 = new ArticleReference("SS87", entries2);

    }

    @Test
    public void setNameTest() {
        assertEquals("SS86", articleReference.getName());
    }

    @Test
    public void typeIsSetToArticle() {
        assertEquals(ARTICLE, articleReference.getType());
    }

    @Test
    public void mandatoryReferenceEntriesSetCorrectly() {

        ArrayList<EntryType> mandatoryList;
        mandatoryList = new ArrayList<EntryType>(Arrays.asList(AUTHOR, TITLE, JOURNAL, YEAR, VOLUME));

        assertEquals(mandatoryList, articleReference.getMandatoryReferenceEntries());
    }

    @Test
    public void optionalReferenceEntriesSetCorrectly() {
        ArrayList<EntryType> optionalList;
        optionalList = new ArrayList<EntryType>(Arrays.asList(NUMBER, PAGES, MONTH, NOTE, KEY));

        assertEquals(optionalList, articleReference.getOptionalReferenceEntries());
    }

    @Test
    public void settingEntriesWorks() {
        EnumMap<EntryType, String> entries;
        entries = new EnumMap<EntryType, String>(EntryType.class);
        entries.put(AUTHOR, "Spohrer, James C. and Soloway, Elliot");
        entries.put(TITLE, "Novice mistakes: are the folk wisdoms correct?");

        articleReference = new ArticleReference("SS86", entries);

        EnumMap<EntryType, String> entries2;
        entries2 = new EnumMap<EntryType, String>(EntryType.class);
        entries2.put(AUTHOR, "Juupajuu");
        entries2.put(TITLE, "Juupajuun tarinoita");
  
        articleReference.setEntries(entries2);

        assertEquals(articleReference.getEntries(), entries2);
    }

}
