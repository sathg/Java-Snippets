
/**
 * Write a description of TestAbc here.
 * 
 * @author SATHISH G 
 * @version 2019-03-08
 */
public class TestAbc {

    public void findAbc(String input) {
    int index = input.indexOf("abc");
    while (true) {
        if (index == -1 || index >= input.length() - 3) {
            break;
        }
        }
        String found = input.substring(index+1, index+4);
        System.out.println(found);
        index = input.indexOf("abc", index+4);
    }

   public void test() {
    findAbc("abcd");
    findAbc("abcdabc");
}

}
