
/**

 @author Jake Ira
 @author Nick Sosinski
 */
import java.util.StringTokenizer;

public class hardCorePorn extends areaUnderTheCurve
{

   private int startingX;
   private int endingX;
   private int numberOfRectangles = 100000;
   private float aMultiplier;
   private float bMultiplier;
   private float cConstant;

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

      System.out.println("Input the range formatted like \"[2,3]\"");
      //Hint: input the range
      String range = stdin.nextLine();

      StringTokenizer st = new StringTokenizer(range, "{},");
      startingX = Integer.getInteger(st.nextToken());
      endingX = Integer.getInteger(st.nextToken());
   }

   //Make (a) method(s) to calculate the area.
   public float calcIntegral()
   {
      try
      {
         double cubicIntegralVal = aMultiplier / 3;
         double squaredIntegralVal = bMultiplier / 2;
         int x = whatever;
         double startingintegral = cubicIntegralVal * (startingX * startingX * startingX) + ;

         return cubicIntegralVal + x ^ 3;
      }
      catch (Exception e)
      {
         return -1f;
      }

   }

   public float findArea() throws Exception
   {
      try
      {

         return -1f;
      }
      catch (Exception e)
      {
         throw e;
      }
   }
}
