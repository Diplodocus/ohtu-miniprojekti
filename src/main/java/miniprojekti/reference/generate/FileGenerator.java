package miniprojekti.reference.generate;

import miniprojekti.reference.Reference;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**

 */
public class FileGenerator {


    /**
     * generate BibTex file from references
     * @param references list of references
     * @param filePath path of target file
     * @return The bibTexFile
     */
    public File generateFile(ArrayList<Reference> references, String filePath){

        return writeToFile(contentGenerator(references), filePath);
    }


    private String contentGenerator(ArrayList<Reference> references){

        StringBuilder wholeBibTex = new StringBuilder();
        BibTexGenerator generator = new BibTexGenerator();
        //generates a long string with all the bibTex parts in it
        for (Reference reference : references) {
            wholeBibTex.append(generator.generate(reference));
            wholeBibTex.append("\n");

        }
        return wholeBibTex.toString();
    }

    /*
     *  Writes string to file
     */
    private File writeToFile(String content, String filePath) {
        BufferedWriter buffWriter = null;
        File file = null;
        try {



            file = new File(filePath);

            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            //doesn't append
            FileWriter filewriter = new FileWriter(file.getAbsoluteFile(), false);
            buffWriter = new BufferedWriter(filewriter);
            buffWriter.write(content);
            buffWriter.close();
            return file;


        } catch (IOException e) {
            e.printStackTrace();

        }
        //returns null if cant write
        //TODO Should this be handled a different way
        return null;


    }
}
