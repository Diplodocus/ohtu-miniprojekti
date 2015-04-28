package miniprojekti.service;

import miniprojekti.domain.AbstractReference;
import miniprojekti.domain.ArticleReference;
import miniprojekti.enums.EntryType;
import org.springframework.stereotype.Service;

import java.util.EnumMap;

/**
 * Created by tixtixti on 28.4.15.
 */
@Service
public class ArticleReferenceService extends ReferenceService {

    public ArticleReferenceService(){
        super();
    }
    @Override
    AbstractReference referenssi(EnumMap<EntryType, String> mappi) {
        return new ArticleReference("uusi",mappi);
    }
}
