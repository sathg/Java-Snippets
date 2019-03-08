/**
 * Counting no of genes in a DNA
 * 
 * @author Sathish G 
 * @version (20190308)
 */
import java.io.*;
import edu.duke.*;

public class Part3 {


    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int currIndex;
        currIndex = dna.indexOf(stopCodon,startIndex+ stopCodon.length());
        while(currIndex != -1) {
            if ((currIndex -startIndex) % 3 == 0){
                return currIndex;
            }
            currIndex = dna.indexOf(stopCodon, currIndex + 1);

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
    
    public int countGenes(String dna ){
        int countOcc = 0;
        int startIndex = 0;
        String geneString = findGene(dna);
        while(!geneString.isEmpty()){
            countOcc = countOcc +1 ;
            startIndex = dna.indexOf(geneString,startIndex) + geneString.length();
            geneString = findGene(dna.substring(startIndex));
        }
        return countOcc;

    }

    public void testCountGenes(){
        int result;
        result = countGenes("ATGTAAGATGCCCTAGT") ;
        System.out.println("Result -->"+ result);

    }

    public static void main(String args[]){
        Part3 obj = new Part3();
        obj.testCountGenes();
    }
}
