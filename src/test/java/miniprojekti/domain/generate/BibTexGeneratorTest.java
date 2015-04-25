package miniprojekti.domain.generate;

import miniprojekti.domain.ArticleReference;
import miniprojekti.enums.EntryType;
import miniprojekti.domain.ReferenceInterface;
import miniprojekti.service.BibTexGenerator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.EnumMap;

import static miniprojekti.enums.EntryType.*;

/**

 */
public class BibTexGeneratorTest {
    private ReferenceInterface testReferenceInterface1;
    private ReferenceInterface testReferenceInterface2;
    private BibTexGenerator generator;
    private ArrayList<ReferenceInterface> testReferenceInterfaces;

    /* example:
    @article{SS86,
        author = {Spohrer, James C. and Soloway, Elliot},
        title = {Novice mistakes: are the folk wisdoms correct?},
        journal = {Commun. ACM},
        year = {1986},
        volume = {29},
        number = {7},
        pages = {624--632}
    }
     */

    @Before
    public void setUp(){
        generator = new BibTexGenerator();
        testReferenceInterface1 = makeRef1();
        testReferenceInterface2 = makeRef2();
        testReferenceInterfaces = new ArrayList<ReferenceInterface>();
        testReferenceInterfaces.add(testReferenceInterface1);
        testReferenceInterfaces.add(testReferenceInterface2);
    }



    @Test
    public void generatorTest(){
        assertEquals("The generated file should look like the example",ref1Output(), generator.generate(testReferenceInterface1) );
        assertEquals("The generated file should look like the example",ref2Output(), generator.generate(testReferenceInterface2) );
    }

    @Test
    public void generateAllTest(){

        assertEquals("should generate all", allBibTex(), generator.generateAll(testReferenceInterfaces));
    }




    private String ref1Output(){
        String testBibTex =
                "@article{SS86,\n" +
                        "  author = {Spohrer, James C. and Soloway, Elliot},\n" +
                        "  title = {Novice mistakes: are the folk wisdoms correct?},\n" +
                        "  journal = {Commun. ACM},\n" +
                        "  year = {1986},\n" +
                        "  volume = {29},\n" +
                        "  number = {7},\n" +
                        "  pages = {624--632}\n" +
                        "}\n";
        return testBibTex;
    }

    private String ref2Output(){
        String testBibTex =
                "@article{name,\n" +
                        "  author = {me},\n" +
                        "  title = {how i test java},\n" +
                        "  journal = {github},\n" +
                        "  year = {2015},\n" +
                        "  volume = {1}\n" +
                        "}\n";
        return testBibTex;
    }

    private ReferenceInterface makeRef1(){
        EnumMap<EntryType, String> entries;
        entries = new EnumMap<EntryType, String>(EntryType.class);
        entries.put(AUTHOR, "Spohrer, James C. and Soloway, Elliot");
        entries.put(TITLE, "Novice mistakes: are the folk wisdoms correct?");
        entries.put(JOURNAL, "Commun. ACM");
        entries.put(VOLUME, "29");
        entries.put(NUMBER, "7");
        entries.put(YEAR, "1986");
        entries.put(PAGES, "624--632");
        ArticleReference testReference = new ArticleReference("SS86", entries);
        return testReference;
    }


    private ReferenceInterface makeRef2(){
        EnumMap<EntryType, String> entries;
        entries = new EnumMap<EntryType, String>(EntryType.class);
        entries.put(AUTHOR, "me");
        entries.put(TITLE, "how i test java");
        entries.put(JOURNAL, "github");
        entries.put(VOLUME, "1");
        entries.put(YEAR, "2015");
        ArticleReference testReference = new ArticleReference("name", entries);
        return testReference;
    }

    private String allBibTex(){
        String allText =  ref1Output() + "\n" + ref2Output() + "\n";
        return allText;

    }
}
