package miniprojekti.reference;

import java.util.ArrayList;

/**

 */
public class References {
    private ArrayList<Reference> references = new ArrayList<Reference>();



    public void addReference(Reference reference){
        references.add(reference);
    }

    public void removeReference(Reference reference){
        references.remove(reference);
    }


    public ArrayList<Reference> getReferences(){
        return references;
    }
}
