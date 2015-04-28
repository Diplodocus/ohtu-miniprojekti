package miniprojekti.service;

import miniprojekti.enums.EntryType;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import miniprojekti.domain.*;
/**
 *
 */
@Service
public class BibTexGenerator {
    private Map<Character, String> specialLetters = new HashMap<Character, String>();

    public BibTexGenerator() {
        makeSpecialLettersMap();


    }





    /**
     * Generates the bibTex as a String from a referenceD   
     * @param referenceInterface reference to be generated
     * @return reference as bibTex string
     */
    public String generate(ReferenceInterface referenceInterface) {
        StringBuilder bibTex = new StringBuilder();
        bibTex.append("@")
                .append(referenceInterface.getType().getName())
                .append("{")
                .append(referenceInterface.getName());

        for (EntryType part : referenceInterface.getEntries().keySet()) {
            if (!referenceInterface.getEntries().get(part).isEmpty()) {
                bibTex.append(",\n");
                generateLine(part.getName(), referenceInterface.getEntries().get(part), bibTex);
            }
        }

        bibTex.append("\n}\n");

        return changeSpecials(bibTex.toString());
        //return bibTex.toString();
    }

    public String generateAll(ArrayList<ReferenceInterface> referenceInterfaces) {

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
    private void generateLine(String whatToGenerate, String dataField, StringBuilder bibTex) {
        bibTex.append("  ").append(whatToGenerate).append(" = {").append(dataField).append("}");
    }


    private String changeSpecials(String toChange){
        StringBuilder changedString= new StringBuilder();
        // loop trough all characters in string
        for (int i = 0; i <toChange.length() ; i++) {
            char thisChar = toChange.charAt(i);
            String charSequence = specialLetters.get(thisChar);
            if (charSequence != null){
                changedString.append(charSequence);
            }
            else{
                changedString.append(thisChar);
            }
        }
        return changedString.toString();
    }




    private void makeSpecialLettersMap(){
        specialLetters.put('Ä', "\\\"{A}");
        specialLetters.put('ä', "\\\"{a}");
        specialLetters.put('Ë', "\\\"{E}");
        specialLetters.put('ë', "\\\"{e}");
        specialLetters.put('Ï', "\\\"{I}");
        specialLetters.put('ï', "\\\"{i}");
        specialLetters.put('Ö', "\\\"{O}");
        specialLetters.put('ö', "\\\"{o}");
        specialLetters.put('Ü', "\\\"{U}");
        specialLetters.put('ü', "\\\"{u}");


        specialLetters.put('ő', "\\H{o}");
        specialLetters.put('ő', "\\H{o}");

        specialLetters.put('Â', "\\^{A}");
        specialLetters.put('â', "\\^{a}");
        specialLetters.put('Ê', "\\^{E}");
        specialLetters.put('ê', "\\^{e}");
        specialLetters.put('Î', "\\^{I}");
        specialLetters.put('î', "\\^{i}");
        specialLetters.put('Ô', "\\^{Ô}");
        specialLetters.put('ô', "\\^{o}");
        specialLetters.put('Û', "\\^{U}");
        specialLetters.put('û', "\\^{u}");

        specialLetters.put('À', "\\`{A}");
        specialLetters.put('à', "\\`{a}");
        specialLetters.put('È', "\\`{E}");
        specialLetters.put('è', "\\`{e}");
        specialLetters.put('Ì', "\\`{I}");
        specialLetters.put('ì', "\\`{i}");
        specialLetters.put('Ò', "\\`{O}");
        specialLetters.put('ò', "\\`{o}");
        specialLetters.put('Ù', "\\`{U}");
        specialLetters.put('ù', "\\`{u}");

        specialLetters.put('Á', "\\’{A}");
        specialLetters.put('É', "\\’{E}");
        specialLetters.put('Í', "\\’{I}");
        specialLetters.put('Ó', "\\’{O}");
        specialLetters.put('Ú', "\\’{U}");
        specialLetters.put('Ý', "\\’{Y}");

        specialLetters.put('á', "\\'{a}");
        specialLetters.put('é', "\\'{e}");
        specialLetters.put('í', "\\'{i}");
        specialLetters.put('ó', "\\'{o}");
        specialLetters.put('ú', "\\'{u}");
        specialLetters.put('ý', "\\'{y}");

        specialLetters.put('Ã', "\\~{A}");
        specialLetters.put('ã', "\\~{a}");
        specialLetters.put('Ñ', "\\~{N}");
        specialLetters.put('ñ', "\\~{n}");
        specialLetters.put('Õ', "\\~{O}");
        specialLetters.put('õ', "\\~{o}");

        specialLetters.put('Ç', "\\c{C}");
        specialLetters.put('ç', "\\c{c}");

        specialLetters.put('ß', "\\ss");

        specialLetters.put('Ă', "\\u{A}");
        specialLetters.put('ă', "\\u{a}");
        specialLetters.put('Ĕ', "\\u{E}");
        specialLetters.put('ĕ', "\\u{e}");
        specialLetters.put('Ĭ', "\\u{I}");
        specialLetters.put('ĭ', "\\u{i}");
        specialLetters.put('Ŏ', "\\u{O}");
        specialLetters.put('ŏ', "\\u{o}");
        specialLetters.put('ŏ', "\\u{o}");
        specialLetters.put('Ŭ', "\\u{U}");
        specialLetters.put('ŭ', "\\u{u}");

        specialLetters.put('Ø', "\\O");
        specialLetters.put('ø', "\\o");

        specialLetters.put('Æ', "\\AE");
        specialLetters.put('æ', "\\ae");

        specialLetters.put('Å', "\\AA");
        specialLetters.put('å', "\\aa");

        specialLetters.put('°', "\\textdegree");



    }









}
