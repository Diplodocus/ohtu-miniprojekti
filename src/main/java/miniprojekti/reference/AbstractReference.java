package miniprojekti.reference;

import java.util.*;

import static miniprojekti.reference.BibTexType.ARTICLE;
import static miniprojekti.reference.EntryType.*;

/**

 */
public class AbstractReference implements Reference {
    //TODO Halutaanko interface abstract classin lisäksi
    private final BibTexType type;
    private final ArrayList<EntryType> mustHave;
    private final ArrayList<EntryType> mayHave;
    private String name;
    protected EnumMap<EntryType, String> entries;

    public AbstractReference(String name, EnumMap<EntryType, String> entries, BibTexType type, ArrayList<EntryType> mustHave, ArrayList<EntryType> mayHave) {
        this.name = name;
        this.type = type;
        this.mustHave = mustHave;
        this.entries = entries;
        this. mayHave = mayHave;
    }

    /**
     * @return name of the reference
     */
    @Override
    public String getName(){
        return name;
    }

    /**
     * @return type of the reference
     */
    @Override
    public BibTexType getType() {
        return type;
    }

    /**
     *
     * @return the entries that my be added to the reference
     */
    @Override
    public List<EntryType> getOptionalReferenceEntries() {
        return mayHave;
    }

    /**
     *
     * @return the entries that must be added to the reference
     */
    @Override
    public List<EntryType> getMandatoryReferenceEntries() {
        return mustHave;
    }

    /**
     *
     * @return the entries of the reference
     */
    @Override
    public Map<EntryType, String> getEntries() {
        return entries;
    }

    /**
     *
     * @param entries new entries for the reference
     */
    @Override
    public void setEntries(EnumMap<EntryType, String> entries) {
        this.entries = entries;
    }
}
