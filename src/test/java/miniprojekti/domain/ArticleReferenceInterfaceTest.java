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

import miniprojekti.enums.EntryType;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static miniprojekti.enums.EntryType.*;
import static miniprojekti.enums.BibTexType.*;

public class ArticleReferenceInterfaceTest {

    ArticleReference articleReference;
    ArticleReference articleReference2;
    ArticleReference articleReference3;

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
        entries2.put(PAGES, "14--16");
        articleReference2 = new ArticleReference("SS87", entries2);

        EnumMap<EntryType, String> entries3;
        entries3 = new EnumMap<EntryType, String>(EntryType.class);
        entries3.put(AUTHOR, "");
        entries3.put(TITLE, "");
        entries3.put(JOURNAL, "");
        entries3.put(VOLUME, "");
        entries3.put(NUMBER, "");
        entries3.put(YEAR, "");
        articleReference3 = new ArticleReference("SS86", entries3);

    }

    @Test
    public void setNameForArticleReference() {
        assertEquals("SS86", articleReference.getName());
    }

    @Test
    public void referenceTypeIsSetToArticle() {
        assertEquals(ARTICLE, articleReference.getType());
    }

    @Test
    public void mandatoryReferenceEntriesForArticleSetCorrectly() {

        ArrayList<EntryType> mandatoryList;
        mandatoryList = new ArrayList<EntryType>(Arrays.asList(AUTHOR, TITLE, JOURNAL, YEAR, VOLUME));

        assertEquals(mandatoryList, articleReference.getMandatoryReferenceEntries());
    }

    @Test
    public void optionalReferenceEntriesForArticleSetCorrectly() {
        ArrayList<EntryType> optionalList;
        optionalList = new ArrayList<EntryType>(Arrays.asList(NUMBER, PAGES, MONTH, NOTE, KEY));

        assertEquals(optionalList, articleReference.getOptionalReferenceEntries());
    }

    @Test
    public void settingEntriesForArticleWorks() {

        EnumMap<EntryType, String> entries2;
        entries2 = new EnumMap<EntryType, String>(EntryType.class);
        entries2.put(AUTHOR, "Juupajuu");
        entries2.put(TITLE, "Juupajuun tarinoita");

        articleReference.setEntries(entries2);

        assertEquals(articleReference.getEntries(), entries2);
    }

    @Test
    public void articleValidatePassesWithAllMandatoryFields() {
        List<String> err = new ArrayList<String>();
        assertEquals(articleReference.validate(), err);

    }

    @Test
    public void articleValidateFailsWhenMissingMandatoryFields() {
        List<String> err = new ArrayList<String>();

        err.add("Author is a mandatory field.");
        err.add("Title is a mandatory field.");
        err.add("Journal is a mandatory field.");
        err.add("Year is a mandatory field.");
        err.add("Volume is a mandatory field.");

        assertEquals(articleReference2.validate(), err);

    }

    @Test
    public void aticleValidateFailsWhenFieldEntriesAreInvalid() {
        List<String> err = new ArrayList<String>();

        err.add("Author is a mandatory field.");
        err.add("Title is a mandatory field.");
        err.add("Journal is a mandatory field.");
        err.add("Year is a mandatory field.");
        err.add("Volume is a mandatory field.");

        assertEquals(articleReference3.validate(), err);

    }

}
