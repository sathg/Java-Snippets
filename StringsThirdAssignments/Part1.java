
/**
 * Three condons gene
 * 
 * @author Sathish G 
 * @version (20190308)
 * 
 * three stop codons “TAA”, “TAG”, or “TGA”
 */

import java.math.*;
import edu.duke.*;
import java.io.*;

public class Part1 {

    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int currIndex;
        currIndex = dna.indexOf(stopCodon,startIndex+ stopCodon.length());
        // System.out.println(stopCodon.length());
        while(currIndex != -1) {
            if ((currIndex -startIndex) % 3 == 0){
                return currIndex;
            }
            currIndex = dna.indexOf(stopCodon, currIndex + 1);
            // System.out.println(currIndex);

        }
        return dna.length();
    }

    public String findGene(String dna){
        int startCondon;
        // String 
        startCondon = dna.indexOf("ATG");
        if (startCondon == -1) {
            return "";
        }

        int taaIndex = findStopCodon(dna, startCondon, "TAA");
        int tagIndex = findStopCodon(dna, startCondon, "TAG");
        int tgaIndex = findStopCodon(dna, startCondon, "TGA");

        int minIndex = Math.min(taaIndex, Math.min(tagIndex,tgaIndex));
        if (dna.length() == minIndex){
            return "";
        }

        return dna.substring(startCondon, minIndex+3);
        
    }

    public void testFindStopCodon(){
        int stopCondon;
        stopCondon = findStopCodon("AATGCTAACTAGCTGATAGT",1, "TAG");

        System.out.println("STOP Condon -> "+ stopCondon);
        stopCondon = findStopCodon("AATGCTATAAAGCTGACT",1, "TAA");
        System.out.println("STOP Condon -> "+ stopCondon);
    }

    public void testFindGene(){
        String DNA;
        String outDNA;
        DNA = "ABCTAA";
        outDNA = findGene(DNA);
        System.out.println("Result "+ outDNA);
        DNA = "ATGBCD";
        outDNA = findGene(DNA);
        System.out.println("Result "+ outDNA);
        DNA = "DFDFD";
        outDNA = findGene(DNA);
        System.out.println("Result "+ outDNA);
        DNA = "ATGABCDEFTAA";
        outDNA = findGene(DNA);
        System.out.println("Result "+ outDNA);
        DNA = "ATGABCDEFGTAA";
        outDNA = findGene(DNA);
        System.out.println("Result "+ outDNA);
        DNA = "AAATGCCCTGACTAGATTAAGAAACC";
        outDNA = findGene(DNA);
        System.out.println("Result "+ outDNA);

    }

    public static void main(String args[]){
        Part1 findCondon = new Part1();
        findCondon.testFindStopCodon();
        findCondon.testFindGene();
    }

}
