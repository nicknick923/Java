
/**

 @author Nick Sosinski
 @author Jake Ira
 */
public class runner
{

   public void run()
   {
      TA a;
      TB b;


      try
      {
         a = new TB(6, 3);
         a.doIt1();

         System.out.println("Valid");
      }
      catch (Exception e)
      {
         System.out.println("Invalid");
      }



      try
      {

         System.out.println("Valid");
      }
      catch (Exception e)
      {
         System.out.println("Invalid");
      }

      try
      {

         System.out.println("Valid");
      }
      catch (Exception e)
      {
         System.out.println("Invalid");
      }

      try
      {

         System.out.println("Valid");
      }
      catch (Exception e)
      {
         System.out.println("Invalid");
      }

   }
}
