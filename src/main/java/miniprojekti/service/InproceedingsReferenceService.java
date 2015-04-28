package miniprojekti.service;

import miniprojekti.domain.AbstractReference;
import miniprojekti.domain.InproceedingsReference;
import miniprojekti.enums.EntryType;
import org.springframework.stereotype.Service;

import java.util.EnumMap;

/**
 * Created by tixtixti on 28.4.15.
 */
@Service
public class InproceedingsReferenceService extends ReferenceService {

    public InproceedingsReferenceService(){
        super();
    }
    @Override
    AbstractReference referenssi(EnumMap<EntryType, String> mappi) {
        return new InproceedingsReference("uusi",mappi);
    }
}

