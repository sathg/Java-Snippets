
/**
 * Write a description of Part2 here.
 * 
 * @author SATHISH G 
 * @version 2019-03-08
 */
import java.io.*;
import edu.duke.*;

public class Part2 {

    public float cgRatio(String dna){
        int index =0, cgCount =0;
        while(index < dna.length()) {
        System.out.println(dna.substring(index, index+1));
        System.out.println(dna.substring(index, index+1)== "G");

        if (dna.substring(index, index+1).toUpperCase().equals("C") || dna.substring(index, index+1).toUpperCase().equals("G"))
        // if (dna.substring(index, index+1) == "C" || dna.substring(index, index+1) =="G" )
        {
                cgCount = cgCount +1;
            }
            index ++;
        }
        if (cgCount == 0){
            return 0;
        }
        System.out.println(cgCount);
        System.out.println(dna.length());
        return ((float)cgCount)/dna.length();
    }

    // public int countCTG(String dna){

    //     int index = 0, ctgCount =0;
    //     while(index < dna.length()) {
    //         if (dna.substring(index, index+3) == "CTG"){
    //             ctgCount = ctgCount +1;
    //         }
    //     index = index+3;
    //     }
    //     return ctgCount;   
    // }

    public static void main(String args[]){
        Part2 obj = new Part2();
        float cgR = obj.cgRatio("ATGAAACAAATCCTGG");
        System.out.println(cgR);
    }
}
