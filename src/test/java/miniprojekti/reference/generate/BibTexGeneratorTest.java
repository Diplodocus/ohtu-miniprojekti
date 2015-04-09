package miniprojekti.reference.generate;

import miniprojekti.reference.ArticleReference;
import miniprojekti.reference.EntryType;
import miniprojekti.reference.Reference;
import org.junit.Before;
import org.junit.Test;

import java.util.EnumMap;

import static miniprojekti.reference.EntryType.*;

/**

 */
public class BibTexGeneratorTest {
    private Reference testReference;

    /* example:
    @article{SS86,
        author = {Spohrer, James C. and Soloway, Elliot},
        title = {Novice mistakes: are the folk wisdoms correct?},
        journal = {Commun. ACM},
        volume = {29},
        number = {7},
        year = {1986},
        pages = {624--632},

    }
     */

    @Before
    public void setUp(){
        EnumMap<EntryType, String> entries;
        entries = new EnumMap<EntryType, String>(EntryType.class);
        entries.put(AUTHOR, "Spohrer, James C. and Soloway, Elliot");
        entries.put(TITLE, "Novice mistakes: are the folk wisdoms correct?");
        entries.put(JOURNAL, "Commun. ACM");
        entries.put(VOLUME, "29");
        entries.put(NUMBER, "7");
        entries.put(YEAR, "1986");
        entries.put(PAGES, "624--632");
        testReference = new ArticleReference("SS86", entries);


    }

    @Test
    public void test(){

    }
}
