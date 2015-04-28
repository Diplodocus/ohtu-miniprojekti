package miniprojekti.enums;

/**
 *
 */
public enum BibTexType {

    ARTICLE,
    BOOK;
    public String getName() {
        return name().toLowerCase();
    }
}
