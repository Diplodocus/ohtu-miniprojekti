/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojekti.reference;

import java.util.ArrayList;
import java.util.EnumMap;

import miniprojekti.enums.EntryType;
import miniprojekti.reference.entity.ArticleReference;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static miniprojekti.enums.EntryType.*;

/**
 *
 * @author johanna
 */
public class ReferencesTest {

    References references;
    ArticleReference reference1;
    ArticleReference reference2;
    ArrayList<ReferenceInterface> list;

    @Before
    public void setUp() {
        references = new References();
        list = new ArrayList<ReferenceInterface>();

        EnumMap<EntryType, String> entries;
        entries = new EnumMap<EntryType, String>(EntryType.class);
        entries.put(AUTHOR, "Spohrer, James C. and Soloway, Elliot");
        entries.put(TITLE, "Novice mistakes: are the folk wisdoms correct?");

        reference1 = new ArticleReference("SS86", entries);

        EnumMap<EntryType, String> entries2;
        entries2 = new EnumMap<EntryType, String>(EntryType.class);
        entries2.put(AUTHOR, "Juupajuu");
        entries2.put(TITLE, "Juupajuun tarinoita");

        reference2 = new ArticleReference("SS87", entries);

    }

    @Test
    public void addReferenceToReferencesList() {
        references.addReference(reference1);
        list.add(reference1);

        assertEquals(references.getReferenceInterfaces(), list);

    }

    @Test
    public void removeReferenceFromReferences() {
        list.add(reference2);
        references.addReference(reference1);
        references.addReference(reference2);
        references.removeReference(reference1);

        assertEquals(references.getReferenceInterfaces(), list);
    }


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
