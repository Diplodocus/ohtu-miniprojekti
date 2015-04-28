package miniprojekti.service;

import miniprojekti.domain.AbstractReference;
import miniprojekti.domain.BookReference;
import miniprojekti.enums.EntryType;

import java.util.EnumMap;

/**
 * Created by tixtixti on 28.4.15.
 */
public class BookReferenceService extends ReferenceService {

    public BookReferenceService(){
        super();
    }
    @Override
    AbstractReference referenssi(EnumMap<EntryType, String> mappi) {
        return new BookReference("uusi",mappi);
    }
}

