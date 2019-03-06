
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;

public class Part2 {

    public String findSimpleGene(String dna, int startCodon, int stopCodon){

        // int startCodon = dna.indexOf("ATG");
        // if(startCodon == -1){
        //     return "";
        // }

        // int stopCodon =  dna.indexOf("TAA", startCodon+3);
        // if(stopCodon == -1){
        //     return "";
        // }
        
        if ((stopCodon - startCodon ) %  3 == 0) {
            return dna.substring(startCodon, stopCodon+3);
        } 
        return "";

    }

    public void testSimpleGene(String DNA){

        //
        // DNA with no “ATG”,
        //  DNA with no “TAA”,
        //   DNA with no “ATG” or “TAA”, 
        //   DNA with ATG, 
        //   TAA and the substring between them is a multiple of 3 (a gene), 
        //   and DNA with ATG, TAA and the substring between them is not a multiple of 3. 
        String upperCaseDNA = DNA.toUpperCase();

        int startCodon = upperCaseDNA.indexOf("ATG");
        if(startCodon == -1){
            System.out.println("Result ");
            return;
        }

        int stopCodon =  upperCaseDNA.indexOf("TAA", startCodon+3);
        if(stopCodon == -1){
            System.out.println("Result ");
            return;
        }

        String  outDNA;
        outDNA = findSimpleGene(DNA, startCodon , stopCodon);
        System.out.println("Result "+ outDNA);
        
    }

    public static void main(String args[]){
        Part2 simpleGen = new Part2();
        String DNA;
        DNA = "ABCTAA";
        simpleGen.testSimpleGene(DNA);
        DNA = "ATGBCD";
        simpleGen.testSimpleGene(DNA);
        DNA = "DFDFD";
        simpleGen.testSimpleGene(DNA);
        DNA = "ATGABCDEFTAA";
        simpleGen.testSimpleGene(DNA);
        DNA = "ATGABCDEFGTAA";
        simpleGen.testSimpleGene(DNA);
        DNA = "ATGGGTTAAGTC";
        simpleGen.testSimpleGene(DNA);
        DNA = "gatgctataat";
        // DNA = DNA.toUpperCase();
        simpleGen.testSimpleGene(DNA);

    }
}
