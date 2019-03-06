import java.io.*;
import edu.duke.*;

public class Part1{

    public String findSimpleGene(String dna){

        int startCodon = dna.indexOf("ATG");
        if(startCodon == -1){
            return "";
        }

        int stopCodon =  dna.indexOf("TAA", startCodon+3);
        if(stopCodon == -1){
            return "";
        }
        
        if ((stopCodon - startCodon ) %  3 == 0) {
            return dna.substring(startCodon, stopCodon+3);
        } 
        return "";

    }

    public void testSimpleGene(){

        //
        // DNA with no “ATG”,
        //  DNA with no “TAA”,
        //   DNA with no “ATG” or “TAA”, 
        //   DNA with ATG, 
        //   TAA and the substring between them is a multiple of 3 (a gene), 
        //   and DNA with ATG, TAA and the substring between them is not a multiple of 3. 
        String DNA;
        String outDNA;
        // DNA = "ABCTAA";
        // String outDNA = findSimpleGene(DNA);
        // System.out.println("Result "+ outDNA);
        // DNA = "ATGBCD";
        // outDNA = findSimpleGene(DNA);
        // System.out.println("Result "+ outDNA);
        // DNA = "DFDFD";
        // outDNA = findSimpleGene(DNA);
        // System.out.println("Result "+ outDNA);
        // DNA = "ATGABCDEFTAA";
        // outDNA = findSimpleGene(DNA);
        // System.out.println("Result "+ outDNA);
        // DNA = "ATGABCDEFGTAA";
        // outDNA = findSimpleGene(DNA);
        // System.out.println("Result "+ outDNA);
        DNA = "AAATGCCCTAACTAGATTAAGAAACC";
        outDNA = findSimpleGene(DNA);
        System.out.println("Result "+ outDNA);
    }
    
    public static void main(String args[]){
     Part1 simpleGen = new Part1();
     simpleGen.testSimpleGene();

    }
}