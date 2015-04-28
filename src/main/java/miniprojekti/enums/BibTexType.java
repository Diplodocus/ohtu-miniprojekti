package miniprojekti.enums;

/**
 *
 */
public enum BibTexType {

    ARTICLE,
    BOOK,
    INPROCEEDINGS;
    public String getName() {
        return name().toLowerCase();
    }
}
