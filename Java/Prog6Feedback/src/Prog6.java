
/**
 Runs the main for Program 3

 @author Jake Ira
 */
import java.util.Scanner;

public class Prog6
{

   /**
    Runs RpnEvaluator.

    @param args is unused
    */
   public static void main(String args[])
   {
      if (args.length >0)
         for (int i = 0; i < args.length; i++)
            System.out.println(args[i]);
      Scanner stdin =  new Scanner(System.in);
      while (stdin.hasNext())
         System.out.println(stdin.nextLine());
   }
}
