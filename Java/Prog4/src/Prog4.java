
/**
 Runs the main for Program 4.

 @author Nick Sosinski
 @author Jake Ira
 */
public class Prog4
{

   /**
    Runs ConsoleSimulation.

    @param args The command line arguments passed in. (Not used in this
    program).
    */
   public static void main(String args[])
   {
      try
      {
         ConsoleSimulation cs = new ConsoleSimulation();
         cs.run();
      }
      catch (Exception e)
      {
         System.out.println("Program Error!");
      }
   }
}
