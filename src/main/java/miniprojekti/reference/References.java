package miniprojekti.reference;

import java.util.ArrayList;

/**
    Saisiko tästä luokasta jotain fiksua? Mihin tämä kuuluu, mitä tämä tekee? Miksi ei ole annotaatioita
 */
public class References {
    private ArrayList<ReferenceInterface> referenceInterfaces = new ArrayList<ReferenceInterface>();



    public void addReference(ReferenceInterface referenceInterface){
        referenceInterfaces.add(referenceInterface);
    }

    public void removeReference(ReferenceInterface referenceInterface){
        referenceInterfaces.remove(referenceInterface);
    }


    public ArrayList<ReferenceInterface> getReferenceInterfaces(){
        return referenceInterfaces;
    }
}
