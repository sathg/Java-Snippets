
/**
 * Write a description of MysteryCode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MysteryCode {

  public String mystery(String dna) {
    int pos = dna.indexOf("T");
    int count = 0;
    int startPos = 0;
    String newDna = "";
    if (pos == -1) {
      return dna;
    }
    while (count < 3) {
      count += 1;
      newDna = newDna + dna.substring(startPos,pos);
      startPos = pos+1;
      pos = dna.indexOf("T", startPos);
      if (pos == -1) {
        break;
      }
    }
    newDna = newDna + dna.substring(startPos);
    return newDna;
  }

  public static void main(String args[]){
    MysteryCode obj = new MysteryCode();
    String mys = obj.mystery("ATGTAAGATGCCCTAGT");
    System.out.println(mys);

  }

}

