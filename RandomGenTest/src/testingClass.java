
import java.util.Random;

/**

 @author Nick Sosinski
 @author Jake Ira
 */
public class testingClass
{

   private static int randValue;
   private static final int randMin = -20;
   private static final int randMax = 20;
   private static final int numberOfRuns = 50000000;
   private static int[] randArray = new int[numberOfRuns];

   public static void main(String args[])
   {
      for (int i = 0; i < numberOfRuns; i++)
      //{
         randValue = getRandom(randMin, randMax);
         /*randArray[randValue + Math.abs(randMin)]++;
      }
      int count = 0;
      for (int i = 0; i < (randMax - randMin); i++)
      {
         System.out.format("%3d", i - Math.abs(randMin));
         System.out.print(":" + randArray[i] + "\n");
         count += randArray[i];
      }
      System.out.println("Total Generated:" + count);
      */
   }

   private static int getRandom(int min, int max)
   {
      Random randGen = new Random();
      double randVal = randGen.nextDouble();
      randVal = randVal * (double) (max - min);
      randVal = randVal + (double) (min - 1);
      if ((((int) randVal) + 1) == max || (((int) randVal) + 1) == min)
         System.out.println("==");
      return (((int) randVal) + 1);
   }
}
