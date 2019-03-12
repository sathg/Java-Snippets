
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
            if(currentTemp == -9999){
                currentTemp = Double.parseDouble(coldestHour.get("TemperatureF"));
            }
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

        CSVRecord lowestHumidity = null;
        for(CSVRecord record : parser){

            if(lowestHumidity == null){

                lowestHumidity = record;
            }
            int currentHum = 0;
            if (record.get("Humidity").equals("N/A")){
                currentHum = Integer.parseInt(lowestHumidity.get("Humidity"));
            }
            else {
                System.out.println(record.get("DateUTC"));
                currentHum = Integer.parseInt(record.get("Humidity"));
            }
            int lowestHum = Integer.parseInt(lowestHumidity.get("Humidity"));

            if(currentHum < lowestHum){
                lowestHumidity = record;
            }
        }
        return lowestHumidity;
        
    }

    public CSVRecord lowestHumidityInManyFiles(){

        CSVRecord lowestHumidityFile = null;
        File lowestHumidityFileName = null; 
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);

            if(lowestHumidityFile == null){
                lowestHumidityFile = lowestHumidityInFile(fr.getCSVParser());
                lowestHumidityFileName = f;

            }

            CSVRecord currentTempFile = lowestHumidityInFile(fr.getCSVParser());

            double currentTemp = Double.parseDouble(currentTempFile.get("Humidity"));
            double coldestTemp = Double.parseDouble(lowestHumidityFile.get("Humidity"));

            if (currentTemp < coldestTemp){
                lowestHumidityFile = currentTempFile;
                lowestHumidityFileName = f;
            }

        }
        return lowestHumidityFile;

    }

    public double averageTemperatureInFile(CSVParser parser){

        double avgTemp = 0;
        int countSize = 0;
        for(CSVRecord record : parser){
            avgTemp = avgTemp + Double.parseDouble(record.get("TemperatureF"));
            countSize = countSize +1 ;

        }
        if(countSize>0){
            return avgTemp/countSize;

        }
        return 0;
    }

    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){


        double avgTemp = 0;
        int countSize = 0;
        for(CSVRecord record : parser){
            int currentHum = Integer.parseInt(record.get("Humidity"));
            if(currentHum >= value ) {
                avgTemp = avgTemp + Double.parseDouble(record.get("TemperatureF"));
                countSize = countSize +1 ;
            }

        }
        if(countSize>0){
            return avgTemp/countSize;

        }
        return 0;
        
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

    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.print("Lowest Humidity was " +csv.get("Humidity")+ " at ");
        System.out.println(csv.get("DateUTC"));

    }

    public void testLowestHumidityInManyFiles(){
        CSVRecord csv = lowestHumidityInManyFiles();
        System.out.print("Lowest Humidity was " +csv.get("Humidity")+ " at ");
        System.out.println(csv.get("DateUTC"));
    }

    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        double avgTem = averageTemperatureInFile(fr.getCSVParser());
        System.out.println("Average Temp"+ avgTem);

    }

    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        double avgTem = averageTemperatureWithHighHumidityInFile(fr.getCSVParser(), 80);
        if(avgTem ==0 ){
            System.out.println("No temperatures with that humidity");
        }
        else{
            System.out.println("Average Temp when high Humidity is "+ avgTem);

        }

    }
}
