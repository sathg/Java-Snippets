
/**
 * Write a description of CSVMax here.
 * 
 * @author SATHISH G 
 * @version 2019-03-11
 */
import java.io.*;
import edu.duke.*;
import org.apache.commons.csv.*;

public class CSVMax {

    public CSVRecord coldestHourInFile(CSVParser parser){

        CSVRecord coldestHour = null;
        for(CSVRecord record : parser){

            if(coldestHour == null){

                coldestHour = record;
            }

            double currentTemp = Double.parseDouble(record.get("TemperatureF"));
            double coldestTemp = Double.parseDouble(coldestHour.get("TemperatureF"));

            if(currentTemp < coldestTemp){
                coldestHour = record;
            }
        }
        return coldestHour;
    }

    public String fileWithColdestTemperature(){

        CSVRecord coldestHourFile = null;
        File coldestfileName = null; 
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);

            if(coldestHourFile == null){
                coldestHourFile = coldestHourInFile(fr.getCSVParser());
                coldestfileName = f;

            }

            CSVRecord currentTempFile = coldestHourInFile(fr.getCSVParser());

            double currentTemp = Double.parseDouble(currentTempFile.get("TemperatureF"));
            double coldestTemp = Double.parseDouble(coldestHourFile.get("TemperatureF"));

            if (currentTemp < coldestTemp){
                coldestHourFile = currentTempFile;
                coldestfileName = f;
            }

        }

        return coldestfileName.getName();
    }


    public CSVRecord lowestHumidityInFile(CSVParser parser){
        
    }

    public void testFileWithColdestTemperature(){

        String coldestfileName = fileWithColdestTemperature();
        System.out.println(coldestfileName);
        

    }

    public void testcoldestHourInFile(){
        FileResource fr = new FileResource();
        CSVRecord coldestHour = coldestHourInFile(fr.getCSVParser());
        System.out.println(coldestHour.get("TemperatureF"));
    }
}
