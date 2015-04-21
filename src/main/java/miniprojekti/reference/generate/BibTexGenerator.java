package miniprojekti.reference.generate;

import miniprojekti.reference.EntryType;
import miniprojekti.reference.Reference;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**

 */
@Service
public class BibTexGenerator {


    /**
     * Generates the bibTex as a String from a reference
     * @param reference reference to be generated
     * @return reference as bibTex string
     */
    public String generate(Reference reference){
        StringBuilder bibTex = new StringBuilder();
        bibTex.append("@")
                .append(reference.getType().getName())
                .append("{")
                .append(reference.getName());

        for (EntryType part : reference.getEntries().keySet()) {
            bibTex.append(",\n");
            generateLine(part.getName(), reference.getEntries().get(part), bibTex);
        }

        bibTex.append("\n}\n");
        return bibTex.toString();

    }

    public String generateAll(ArrayList<Reference> references){

        StringBuilder wholeBibTex = new StringBuilder();
        BibTexGenerator generator = new BibTexGenerator();
        //generates a long string with all the bibTex parts in it
        for (Reference reference : references) {
            wholeBibTex.append(generator.generate(reference));
            wholeBibTex.append("\n");

        }
        return wholeBibTex.toString();
    }


    /**
     *
     * @param whatToGenerate type of the entry as a string
     * @param dataField data for that entry
     * @param bibTex the StringBuilder where it's added
     */
    private void generateLine(String whatToGenerate, String dataField, StringBuilder bibTex){
        bibTex.append("  ").append(whatToGenerate).append(" = {").append(dataField).append("}");
    }



}
