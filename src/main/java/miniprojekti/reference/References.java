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

    public ArrayList<Reference> getReferences(BibTexType type){
        ArrayList<Reference> referenceOfType = new ArrayList<Reference>();
        for (Reference reference : references) {
            if (reference.getType() == type){
                referenceOfType.add(reference);
            }
        }
        return referenceOfType;
    }
}
