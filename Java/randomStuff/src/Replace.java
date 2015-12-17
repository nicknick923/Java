
/**

 @author Jake Ira
 */
import java.util.Scanner;

public class Replace
{

   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      String output = (String)input.nextLine();
      String newOutput = output.replace('e', '?');
      System.out.println(newOutput);
   }
}
