import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }
    
    public int getNumPoints (Shape s) {
        int totalPoints = 0;
        for (Point currPt : s.getPoints()){
            totalPoints =  totalPoints + 1;
        }
        // Put code here
        // System.out.println("TotalPoints " + totalPoints);
        return totalPoints;
    }


    public double getAverageLength(Shape s) {
        // Put code here
        double avgLen =  getPerimeter(s) / getNumPoints(s);
        // System.out.println("Average Length = " + avgLen);
        return avgLen;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largestSide = 0.0;
        Point prevPt = s.getLastPoint();
        System.out.println("Points " + prevPt);
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if (currDist > largestSide ){
                largestSide = currDist;
            }
            prevPt = currPt;
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largestX = 0.0;
        for (Point currPt : s.getPoints()){
            if (currPt.getX() > largestX){
                largestX = currPt.getX();
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largestPerimeter = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerimeter = getPerimeter(s);
            if (currPerimeter > largestPerimeter){
                largestPerimeter = currPerimeter;
            }
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;
        double largestPerimeter = 0.0;// replace this code
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerimeter = getPerimeter(s);
            if (currPerimeter > largestPerimeter){
                largestPerimeter = currPerimeter;
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int count = getNumPoints(s);
        System.out.println("TotalPoints " + count);
        double average = getAverageLength(s);
        System.out.println("Average Length = " + average);
        double largestSide = getLargestSide(s);
        System.out.println("LargestSide = " + largestSide);
        double largestX = getLargestX(s);
        System.out.println("Largest X = " + largestX);

    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double largestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("largestPerimeter =" + largestPerimeter);

    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String largestPeriFile = getFileWithLargestPerimeter();
        System.out.println("largestPeriFile = " + largestPeriFile);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.printFileNames();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
