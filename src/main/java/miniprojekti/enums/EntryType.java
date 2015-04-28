package miniprojekti.enums;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.print.attribute.standard.PagesPerMinute;

/*
 */

public enum EntryType {

    AUTHOR("AUTHOR"),
    EDITOR("EDITOR"),
    TITLE("TITLE"),
    BOOKTITLE("BOOKTITLE"),
    JOURNAL("JOURNAL"),
    YEAR("YEAR"),
    VOLUME("VOLUME"),
    NUMBER("NUMBER"),
    PAGES("PAGES"),
    MONTH("MONTH"),
    NOTE("NOTE"),
    PUBLISHER("PUBLISHER"),
    SERIES("SERIES"),
    ORGANIZATION("ORGANIZATION"),
    ADDRESS("ADDRESS"),
    EDITION("EDITION"),
    KEY("KEY");




    private final String type;

    EntryType(String type) {
        this.type = type;
    }

    @Enumerated(EnumType.STRING)
    public String getType() {
        return this.type;
    }
    
    public String getName() {
        return name().toLowerCase();
    }


}
