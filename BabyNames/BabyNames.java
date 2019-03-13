
/**
 * Write a description of BabyNames here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;
import org.apache.commons.csv.*;

public class BabyNames {

    // public void printNames(){
    // }

    public void totalBirths(FileResource fr){
        int totalNames = 0;
        int totalGirlNames = 0;
        int totalBoyNames = 0;

        for (CSVRecord record : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(record.get(2));
            if (record.get(1).equals("M")){
                totalBoyNames = totalBoyNames +1 ;
            }
            else {
                totalGirlNames = totalGirlNames +1;
            }
            totalNames = totalNames +1;
        }

        System.out.println("Total Names -->" + totalNames);
        System.out.println("Total totalGirlNames -->" + totalGirlNames);
        System.out.println("Total totalBoyNames -->" + totalBoyNames);

    }

 
    public int getRank(int year, String name, String gender){

        // String fileName = "testing/yob"+year+"short.csv";
        String fileName = "us_babynames/us_babynames_by_year/yob"+year+".csv";
        FileResource fr = new FileResource(fileName);
        int rank = 0;
        for (CSVRecord record : fr.getCSVParser(false)){
            if (record.get(1).equals(gender) && record.get(0).equals(name) ){
                rank = rank +1;
                return rank;
            }

            if(record.get(1).equals(gender)){
                rank = rank +1;
            }

        }
        return -1;
    }

    public String getName(int year, int rank, String gender){

        // String fileName = "testing/yob"+year+"short.csv";
        String fileName = "us_babynames/us_babynames_by_year/yob"+year+".csv";
        FileResource fr = new FileResource(fileName);
        String name = "";
        int iterRank = 0;
        for (CSVRecord record : fr.getCSVParser(false)){
            if(record.get(1).equals(gender)){
                iterRank = iterRank +1;
            }
            if (iterRank == rank && record.get(1).equals(gender)){
                return record.get(0);
            }
        }
        return "NO NAME";
    }

    public void whatIsNameInYear(String name, int year, int newYear, String gender){

        int rank = getRank(year, name, gender);
        String newName = getName(newYear, rank, gender);
        System.out.println(name + "born in "+ year+ " would be " + newName + " if she was born in " + newYear);

    }

    public int yearOfHighestRank(String name, String gender){
        int highestRank = -1 ;
        int highestRankYear = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            String fileName = f.getName();
            // int year = Integer.parseInt( fileName.replace("yob", "").replace("short.csv","") );
            int year = Integer.parseInt( fileName.replace("yob", "").replace(".csv","") );
            int rank = getRank(year, name, gender);
            // System.out.println("Year :"+ year +", name: "+ name +", rank : "+rank + ",highestRank: " +highestRank +", highestRankyear :" +highestRankYear );
            if ((rank < highestRank && rank >0) || highestRank == -1){
                highestRank = rank;
                highestRankYear = year;
            }
        }
        if (highestRank == -1){
            return -1;
        }
        else {
            return highestRankYear;
        }
    }

    public Double getAverageRank(String name, String gender){

        Double noofSelectedFiles = 0.0;
        Double sumRank = 0.0;

        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            String fileName = f.getName();
            // int year = Integer.parseInt( fileName.replace("yob", "").replace("short.csv","") );
            int year = Integer.parseInt( fileName.replace("yob", "").replace(".csv","") );
            int rank = getRank(year, name, gender);
            System.out.println("Year :"+ year +", name: "+ name +", rank : "+rank + ",sumRank: " +sumRank +", noofSelectedFiles :" +noofSelectedFiles );
            if (rank == -1){
                return -1.0;
            }
            sumRank = sumRank + rank;
            noofSelectedFiles = noofSelectedFiles +1;

        }
        return sumRank/noofSelectedFiles;
        
    }
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender){

        int countBirth= 0;
        // String fileName = "testing/yob"+year+"short.csv";
        String fileName = "us_babynames/us_babynames_by_year/yob"+year+".csv";
        // int inRank = getRank(year, name, gender);
        FileResource fr = new FileResource(fileName);
        for(CSVRecord record : fr.getCSVParser(false)){
            
            if (record.get(1).equals(gender) && record.get(0).equals(name) ){
                // countBirth = countBirth + record.get(2);
                return countBirth;
            }

            if(record.get(1).equals(gender)){
                countBirth = countBirth + Integer.parseInt(record.get(2));
            }

        }

        return 0;

    }

    public  void testTotalBirths(){
        FileResource fr = new FileResource();
        totalBirths(fr);
    }

    public void testGetRank(){
        int rank = getRank(1971,"Frank","M");
        System.out.println("Rank 1960 Frank M -> "+ rank);
    }

    public void testGetName(){
        String name = getName(1980, 350, "F");
        System.out.println("Name 1980 rank 350 F -> "+ name);

        // String name = getName(1982, 450, "M");
        System.out.println("Name 1982 rank 450  M -> "+ getName(1982, 450, "M"));


    }

    public void testWhatIsNameInYear(){
        // whatIsNameInYear("Isabella",2012, 2014, "F");
        whatIsNameInYear("Susan",1972, 2014, "F");
        whatIsNameInYear("Owen",1974, 2014, "M");

    }

    public void testYearOfHighestRank(){
        // int fileYear = yearOfHighestRank("Mason", "M");
        // System.out.println("Mason M -> "+ fileYear);

        System.out.println("Genevieve F -> "+  yearOfHighestRank("Genevieve", "F"));
        System.out.println("Mich M -> "+  yearOfHighestRank("Mich", "M"));


    }

    public void testGetAverageRank(){
        // Double AvgRank = getAverageRank("Jacob", "M");
        // System.out.println("AvgRank Jacob M -> "+ AvgRank);

        System.out.println("AvgRank Susan F -> "+ getAverageRank("Susan", "F"));
        System.out.println("AvgRank Robert M -> "+ getAverageRank("Robert", "M"));



    }
    
    public void testGetTotalBirthsRankedHigher(){
        // int totalBirth = getTotalBirthsRankedHigher(2012, "Ethan", "M");
        // System.out.println("totalBirth Ethan M -> "+ totalBirth);

        System.out.println("totalBirth Emily F 1990 -> "+ getTotalBirthsRankedHigher(1990, "Emily", "F"));
        System.out.println("totalBirth Emily F 1990 -> "+ getTotalBirthsRankedHigher(1990, "Drew", "M"));


    }
}
