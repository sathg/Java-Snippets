
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;

public class Part4 {
    
    public void findYoutube(){

        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String s : ur.lines()) {
            String itemLower = s.toLowerCase();
            int pos  = itemLower.indexOf("youtube.com");
            if(pos != -1){
                int start, end;
                start = itemLower.lastIndexOf("\"", pos);
                end = itemLower.indexOf("\"", pos);
                String a = s.substring(start+1, end);
                System.out.println(a);
            }
        }

    }


    public static void main(String args[]){
        Part4 findYou = new Part4();
        findYou.findYoutube();
    }

}
