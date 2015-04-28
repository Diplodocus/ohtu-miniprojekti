package miniprojekti.service;

import miniprojekti.domain.AbstractReference;
import miniprojekti.domain.ArticleReference;
import miniprojekti.enums.EntryType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.EnumMap;

import static miniprojekti.enums.EntryType.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by cec on 28.4.2015.
 */
public class BibTexGenSpecialsTest {
    private AbstractReference testReferenceInterface1;
    private BibTexGenerator generator;
    private ArrayList<AbstractReference> testReferenceInterfaces;

    @Before
    public void setUp(){
        generator = new BibTexGenerator();
        testReferenceInterface1 = makeRef1();
        testReferenceInterfaces = new ArrayList<AbstractReference>();
        testReferenceInterfaces.add(testReferenceInterface1);
    }

    @Test
    public void generatorTest(){
        assertEquals("The generated file should look like the example",ref1Output(), generator.generate(testReferenceInterface1) );
    }

    @Test
    public void generateAllTest(){

        assertEquals("should generate all", ref1Output().trim(), generator.generateAll(testReferenceInterfaces).trim());
    }



    private String ref1Output(){
        String testBibTex =
                "@article{SS86,\n" +
                        "  author = {\\\"{A}ij\\\"{a}l\\\"{a}},\n" +
                        "  title = {\\aa\\\"{a}\\\"{o}},\n" +
                        "  journal = {\\ss},\n" +
                        "  year = {1986},\n" +
                        "  volume = {29},\n" +
                        "  number = {7},\n" +
                        "  pages = {624--632}\n" +
                        "}\n";
        return testBibTex;
    }

    private AbstractReference makeRef1(){
        EnumMap<EntryType, String> entries;
        entries = new EnumMap<EntryType, String>(EntryType.class);
        entries.put(AUTHOR, "Äijälä");
        entries.put(TITLE, "åäö");
        entries.put(JOURNAL, "ß");
        entries.put(VOLUME, "29");
        entries.put(NUMBER, "7");
        entries.put(YEAR, "1986");
        entries.put(PAGES, "624--632");
        ArticleReference testReference = new ArticleReference("SS86", entries);
        return testReference;
    }
}
