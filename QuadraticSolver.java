
package assignment.module2;
import java.util.Scanner;


/**
 * Solving quadratic equation
 * 
 * and how to use it.
 *
 * @author muhammadnaseem
 * @version Feb 24, 2025
 *
 */
public class QuadraticSolver {
    /**
     * main method 
     *
     * @param args None
     */
    public static void main(String[] args) {

    
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the coefficient of the quadratic term: ");
        byte quadraticCoefficient = input.nextByte();
        
        System.out.print("Enter the coeefficient of the linear term: ");
        byte linearCoefficient = input.nextByte();
        
        System.out.print("Enter the value of the constant term: ");
        byte constantTerm = input.nextByte();
        
        double discriminantValue = Math.pow(linearCoefficient, 2) - (4 * quadraticCoefficient * constantTerm);
        
  
        double denominator = 2 * quadraticCoefficient;
        String exponentTwo = "\u00B2";
        
    
        if (discriminantValue < 0) {
            System.out.print("This quadratic equation has no real roots");
        }else {
                double squareRootOfDiscriminant = Math.sqrt(discriminantValue);
                
                double firstRoot = (-linearCoefficient + squareRootOfDiscriminant) / denominator;
                double secondRoot = (-linearCoefficient - squareRootOfDiscriminant) / denominator;
                System.out.printf("The roots of the quadratic expression %dx%s + %dx + %d are%n", 
                    quadraticCoefficient, exponentTwo, linearCoefficient, constantTerm);
                System.out.printf("%.3f and %.3f%n", firstRoot, secondRoot);
         
        }    
        
        
        
        
        
        
       
        
      input.close();  
    }
       
}
