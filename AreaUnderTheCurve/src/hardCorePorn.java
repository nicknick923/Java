
/**

 @author Jake Ira
 @author Nick Sosinski
 */
import java.util.StringTokenizer;

public class hardCorePorn extends areaUnderTheCurve
{

   public int startingX;
   public int endingX;
   public int numberOfRectangles = 100000;
   public float aMultiplier;
   public float bMultiplier;
   public float cConstant;

   public void run()
   {
      System.out.println("Example Equation Formula: ax^2+bx+c");
      //ax^2+bx+c
      //Hint: Don't forget to prompt the user!!!
      System.err.println("Input a: ");
      aMultiplier = stdin.nextFloat();

      System.err.println("Input b: ");
      bMultiplier = stdin.nextFloat();

      System.err.println("Input c: ");
      cConstant = stdin.nextFloat();

      System.out.println(aMultiplier + "x^2+" + bMultiplier + "x+" + cConstant);

      System.out.println("Input the starting x value");
      //Hint: input the range
      startingX = stdin.nextInt();
      System.out.println("Input the starting ending x value");
      endingX =  stdin.nextInt();
      System.out.println(calcIntegral());
   }

   //Make (a) method(s) to calculate the area.
   public double calcIntegral()
   {
      try
      {
         double cubicIntegralVal = aMultiplier / 3;
         double squaredIntegralVal = bMultiplier / 2;
         double startingIntegral = cubicIntegralVal * (startingX * startingX * startingX) + squaredIntegralVal * (startingX * startingX) + cConstant * (startingX);
         double endingIntegral = cubicIntegralVal * (endingX * endingX * endingX) + squaredIntegralVal * (endingX * endingX) + cConstant * (endingX);
         return endingIntegral - startingIntegral;
      }
      catch (Exception e)
      {
         return -1f;
      }

   }
}
