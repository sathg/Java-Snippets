
/**
 * Write a description of WhichCountriesExport here.
 * 
 * @author SATHISH G
 * @version 2019-03-11
 */

import java.io.*;
import edu.duke.*;
import org.apache.commons.csv.*;


public class WhichCountriesExport {

    public String countryInfo(CSVParser parser, String country){

        for (CSVRecord record : parser){

            String countryrecord = record.get("Country");   
            if (countryrecord .equals(country)){
                return record.get("Country")+ " :" + record.get("Exports")+ " :" + record.get("Value (dollars)");
            }
        }
        return "NOT FOUND";
    }

    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){

        for (CSVRecord record : parser){
            String exports = record.get("Exports");
            if(exports.contains(exportItem1) && exports.contains(exportItem2)){
                System.out.println(record.get("Country"));
            }
        }

    }

    public int numberOfExporters(CSVParser parser, String exportItem){
        int noofExp = 0;
        for (CSVRecord record : parser){
            String exports = record.get("Exports");
            if(exports.contains(exportItem)){
                noofExp = noofExp +1;
            }
        }
        return noofExp;
    }

    public void bigExporters(CSVParser parser, String amount){
        for (CSVRecord record : parser){
            int valueAmount = record.get("Value (dollars)").length();
            if(valueAmount > amount.length()){
                System.out.println(record.get("Country")+ " " + record.get("Value (dollars)"));
            }
        }
    }

    public void tester(){

        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        // for (CSVRecord record : parser){
        //     System.out.println(record);
        // }
        
        String cInfo = countryInfo(parser, "Nauru");
        // System.out.println("Country Info -->"+ cInfo);

        parser = fr.getCSVParser();
        //cotton and flowers
        listExportersTwoProducts(parser,"cotton", "flowers");
        parser = fr.getCSVParser();
        int noofExp = numberOfExporters(parser, "cocoa");
        System.out.println("NO OF EXP cocoa -->"+ noofExp);
        parser = fr.getCSVParser();
        bigExporters(parser,"$999,999,999,999");

    }

}
