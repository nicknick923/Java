
/**
 Runs the main for Program 6

 @author Mr. Scanlan
 */
public class Prog6
{

   /**
    Runs RpnEvaluator.

    @param args is unused
    */
   public static void main(String args[])
   {
      try
      {
         if (args.length == 0)
            new RpnEvaluator().run();
         else if (args.length == 1)
            new Prog6Frame().setVisible(true);
      }
      catch (Exception e)
      {
         System.out.println("Program Error!");
      }
   }
}
