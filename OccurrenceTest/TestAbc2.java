
/**
 * Write a description of TestAbc2 here.
 * 
 * @author Sathish G 
 * @version 2019-03-08
 */
public class TestAbc2 {
    
   public void findAbc(String input){
       int index = input.indexOf("abc");
       while (true){
           if (index == -1 || index >= input.length() - 3){
               break;
           }
           String found = input.substring(index+1, index+4);
           System.out.println(found);
        //    System.out.println("index " + index);
        //    index = input.indexOf("abc",index+4);
           index = input.indexOf("abc",index+3);
        //    System.out.println("index after updating " + index);
       }
   }

   public void test(){
       //findAbc("abcd");
    //    findAbc("abcdabc");
    //    findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
       findAbc("abcabcabcabca");
   }
}