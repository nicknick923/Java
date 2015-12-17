/**
 
 @author Jake Ira
 */
import java.util.Scanner;
public class Circumference 
{
   public static void main(String[] args)
   {
      double pi = 3.14159;
      
      Scanner input = new Scanner(System.in);
      float radius = input.nextFloat();
      double circumference = pi * radius * radius;
      System.out.println("Pi = " + pi);
      System.out.println("Radius = " + radius);
      System.out.println(circumference);
      
   }
}
