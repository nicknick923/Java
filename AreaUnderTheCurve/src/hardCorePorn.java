/**
 
 @author Jake Ira
 @author Nick Sosinski
 */
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
      for(int i =0; i < 10; i++)
         System.out.println(stdin.next());
      
      System.out.println("Example Equation Formula: ax^2+bx+c");
      //ax^2+bx+c
      //Hint: Don't forget to prompt the user!!!
      System.err.println("Input a: ");
      aMultiplier = stdin.nextFloat();
      
      System.err.println("Input b: ");
      bMultiplier = stdin.nextFloat();
      
      System.err.println("Input c: ");
      cConstant = stdin.nextFloat();
   }
   
}