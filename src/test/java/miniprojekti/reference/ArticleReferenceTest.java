/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojekti.reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static miniprojekti.reference.EntryType.*;
import static miniprojekti.reference.BibTexType.*;

public class ArticleReferenceTest {

    ArticleReference articleReference;

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

    }

    @Test
    public void typeIsArticle() {
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

}
