
/**

 @author Jake Ira
 */
import java.util.Scanner;

public class CalculateDistance
{

   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      float tankSize = input.nextFloat();
      float Mpg = input.nextFloat();
      System.out.println (tankSize * Mpg);
   }
}
