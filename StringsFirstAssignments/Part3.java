import java.io.*;
import edu.duke.*;

/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {

    public boolean twoOccurrences(String stringa, String stringb){

        int substrIndex = 0;
        int countOcc = 0;
        int lenStringa = stringa.length();
        substrIndex = stringb.indexOf(stringa);
        while(substrIndex != -1)
        {
            substrIndex = stringb.indexOf(stringa, substrIndex+lenStringa);
            countOcc =  countOcc +1;
        }

        if (countOcc >= 2){
            return true;
        }
        return false;
    }

    public String lastPart(String stringa, String stringb){
        int startIndex = stringb.indexOf(stringa);
        int lenStringa = stringa.length();
        if (startIndex ==-1){
            return stringb;
        }
        return stringb.substring(startIndex+lenStringa);
    }

    public void testtwoOccurrences(){
        boolean Occ;
        Occ = twoOccurrences("by", "A story by Abby Long");
        System.out.println("Two Occurences -->" + Occ);
        Occ = twoOccurrences("a", "banana");
        System.out.println("Two Occurences -->" + Occ);
        Occ = twoOccurrences("atg", "ctgtatgta") ;
        System.out.println("Two Occurences -->" + Occ);

    }

    public void testlastPart(){
        String result;
        result = lastPart("an", "banana");
        System.out.println("The part of the string after "+ result);
        result = lastPart("zoo", "forest");
        System.out.println("The part of the string after "+ result);
    }

    public static void main(String args[]){
        Part3 twoOccur = new Part3();
        twoOccur.testtwoOccurrences();
        twoOccur.testlastPart();
    }
}
