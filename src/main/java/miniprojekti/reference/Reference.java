package miniprojekti.reference;

import java.util.List;
import java.util.Map;

/**
 * Created by cec on 1.4.2015.
 */
public interface Reference {
    /*
      2 Lists of enums what data this kind of reference must an can contain
     */
    List<Enum> getOptionalReferenceParts();
    List<Enum> getMandatoryReferenceParts();

    /*
    map where the inputted data is saved
     */
    Map<Enum, String> getReferenceParts();


}
