package miniprojekti.service;

import miniprojekti.domain.AbstractReference;
import miniprojekti.enums.EntryType;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import miniprojekti.domain.ReferenceInterface;

/**

 */
@Service
public class BibTexGenerator {


    /**
     * Generates the bibTex as a String from a reference
     * @param referenceInterface reference to be generated
     * @return reference as bibTex string
     */
    public String generate(ReferenceInterface referenceInterface){
        StringBuilder bibTex = new StringBuilder();
        bibTex.append("@")
                .append(referenceInterface.getType().getName())
                .append("{")
                .append(referenceInterface.getName());

        for (EntryType part : referenceInterface.getEntries().keySet()) {
            bibTex.append(",\n");
            generateLine(part.getName(), referenceInterface.getEntries().get(part), bibTex);
        }

        bibTex.append("\n}\n");
        return bibTex.toString();

    }

    public String generateAll(List<ReferenceInterface> referenceInterfaces){

        StringBuilder wholeBibTex = new StringBuilder();
        BibTexGenerator generator = new BibTexGenerator();
        //generates a long string with all the bibTex parts in it
        for (ReferenceInterface referenceInterface : referenceInterfaces) {
            wholeBibTex.append(generator.generate(referenceInterface));
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
