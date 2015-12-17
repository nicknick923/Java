
/**

 @author Jake Ira
 */
import java.util.Scanner;

public class FahrenheitToCelsius
{

   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      float degFahr = input.nextFloat();
      float celsiusConverter = (degFahr - 32) * ((float) 5 / 9);
      System.out.println(celsiusConverter);
   }
}
