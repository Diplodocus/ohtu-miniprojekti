package miniprojekti.reference.generate;

import miniprojekti.reference.Reference;

/**
 * Created by cec on 1.4.2015.
 */
public class BibTexGenerator {
    private Reference reference;

    //Todo should it be able to take a list of references and generate one whole document
    public BibTexGenerator(Reference reference){
        this.reference = reference;
    }

    public void generate(){
        String bibTex = "";
        for (Enum part : reference.getReferenceParts().keySet()) {
            generateLine(part.toString(), reference.getReferenceParts().get(part));
        }

    }



    private String generateLine(String whatToGenerate, String dataField){
        return "  " + whatToGenerate + " = {" + dataField + "},\n";
    }



}
