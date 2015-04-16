package miniprojekti.reference;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import java.util.*;

/**

 */
@Entity
public class AbstractReference extends AbstractPersistable<Long> implements Reference {
    //TODO Halutaanko interface abstract classin lisäksi
    private final BibTexType type;
    private final ArrayList<EntryType> mandatoryReferenceEntries;
    private final ArrayList<EntryType> optionalReferenceEntries;
    private String name;
    protected EnumMap<EntryType, String> entries;

    public AbstractReference(String name, EnumMap<EntryType, String> entries, BibTexType type, ArrayList<EntryType> mandatoryReferenceEntries, ArrayList<EntryType> optionalReferenceEntries) {
        this.name = name;
        this.type = type;
        this.mandatoryReferenceEntries = mandatoryReferenceEntries;
        this.entries = entries;
        this.optionalReferenceEntries = optionalReferenceEntries;
    }

    /**
     * @return name of the reference
     */
    @Override
    public String getName(){
        return name;
    }

    /**
     * Set name
     * @param name
     */
    public void setName(String name) { this.name = name;}

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
        return optionalReferenceEntries;
    }

    /**
     *
     * @return the entries that must be added to the reference
     */
    @Override
    public List<EntryType> getMandatoryReferenceEntries() {
        return mandatoryReferenceEntries;
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
