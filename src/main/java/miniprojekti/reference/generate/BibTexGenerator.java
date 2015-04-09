package miniprojekti.reference.generate;

import miniprojekti.reference.EntryType;
import miniprojekti.reference.Reference;

/**
 * Created by cec on 1.4.2015.
 */
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
