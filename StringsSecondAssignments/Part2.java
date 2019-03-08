
/**
 * Counting the number of occurrences of a string in another string 
 * 
 * @author Sathish G 
 * @version (20190308)
 */

import java.io.*;
import edu.duke.*;

public class Part2 {

    public int howMany(String stringa, String stringb){

        int countOcc = 0;
        int startIndex = stringb.indexOf(stringa);
        while(startIndex != -1){
            countOcc = countOcc +1 ;
            startIndex = stringb.indexOf(stringa , startIndex + stringa.length());

        }
        return countOcc;
    }
    
    public void testHowMany(){
        int result;
        result = howMany("GAA", "ATGAACGAATTGAATC") ;
        System.out.println("Result -->"+ result);
        result = howMany("AA", "ATAAA");
        System.out.println("Result -->"+ result);
    }

    public static void main(String args[]){
        Part2 Obj = new Part2();
        Obj.testHowMany();
    }
}

