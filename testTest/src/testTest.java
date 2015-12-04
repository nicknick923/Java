
/**

 @author Nick Sosinski
 @author Jake Ira
 */
public class testTest
{

   public static void main(String args[])
   {
      Node list;
      Node p;

      list = new Node(1, new Node(2, new Node(3, new Node(4, null))));
      java.util.Scanner stdin = new java.util.Scanner(System.in);
      while (stdin.hasNext())
      {
         int inInt = stdin.nextInt();
         System.out.println(inInt % 11);
      }

      System.out.println("hi");
   }
}
