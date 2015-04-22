package miniprojekti.reference.entity;

import miniprojekti.enums.BibTexType;
import miniprojekti.enums.EntryType;
import miniprojekti.reference.ReferenceInterface;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.*;

import javax.persistence.Entity;

/**

 */
@Entity
public abstract class AbstractReference extends AbstractPersistable<Long> implements ReferenceInterface {
    //TODO Halutaanko interface abstract classin lisäksi

    private BibTexType type;

    @ElementCollection
    private List<EntryType> mandatoryReferenceEntries;

    /* @ElementCollection(targetClass=EntryType.class)
    @Enumerated(EnumType.STRING) // Possibly optional (I'm not sure) but defaults to ORDINAL.
    @CollectionTable(name="reference_type")
    @Column(name="interest") // Column name in person_interest
    Collection<EntryType> mustHave; */

    @ElementCollection
    private List<EntryType> optionalReferenceEntries;

    private String name;

    @ElementCollection
    @MapKeyEnumerated(EnumType.STRING)
    protected Map<EntryType, String> entries;

    public AbstractReference(String name, Map<EntryType, String> entries, BibTexType type, ArrayList<EntryType> mandatoryReferenceEntries, ArrayList<EntryType> optionalReferenceEntries) {
        this.name = name;
        this.type = type;
        this.mandatoryReferenceEntries = mandatoryReferenceEntries;
        this.entries = entries;
        this.optionalReferenceEntries = optionalReferenceEntries;
    }

    public AbstractReference() {
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

    public abstract List validate();
}
