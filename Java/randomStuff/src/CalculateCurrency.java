/**
 
 @author Jake Ira
 */
import java.util.Scanner;

public class CalculateCurrency 
{
   public static void main(String[] args)
   {
    Scanner input = new Scanner(System.in);
    float UsDollars = input.nextFloat();
    double calculateEuros = (double)UsDollars * .8109;
    System.out.println(calculateEuros);
   }
}
