
/**
 This class determines based off user command whether to add, delete,
 multiply, print, calculate the sum, or calculate the product of the fractions
 in the array then prints out corresponding statements .

 @author Jake Ira
 */
import java.util.Scanner;

public class FractionManipulator
{

   private Scanner stdin;
   private ListOfFraction myList = new ListOfFraction();

   /**
    This function Consists of a nested if statement to determine which method
    needs to be run based off the entered command.

    @throws java.io.IOException
    */
   public void run() throws java.io.IOException
   {
      stdin = new Scanner(System.in);
      String command = stdin.next();
      while (!command.equalsIgnoreCase("Q"))
      {
         if (command.equalsIgnoreCase("A"))
            add();
         else if (command.equalsIgnoreCase("D"))
            delete();
         else if (command.equalsIgnoreCase("M"))
            multiply();
         else if (command.equalsIgnoreCase("P"))
            print();
         else if (command.equalsIgnoreCase("S"))
            sum();
         else
            System.out.println(command + " is not a valid command!");
         command = stdin.next();
      }
      System.out.println("Normal Termination of Program 2!");
   }

   /**
    This method adds another fraction to the list.
    */
   private void add()
   {
      Fraction newFraction = new Fraction(stdin.next());
      myList.add(newFraction);
      System.out.println(newFraction + " was added to the list.");

   }

   /**
    This method deletes a fraction from the list if its in the list and
    outputs and error message if it is not in the list.
    */
   private void delete()
   {
      Fraction newFraction = new Fraction(stdin.next());
      if (myList.delete(newFraction))
         System.out.println(newFraction + " was removed from the list.");
      else
         System.out.println(newFraction + " is not in the list.");
   }

   /**
    This method prints out "The numbers in the list are: " the calls the print
    method in the fraction class to output all the numbers in the list.
    */
   private void print()
   {
      int numPerLine = stdin.nextInt();
      System.out.println("The numbers in the list are:");
      myList.print(numPerLine);
   }

   /**
    This method calls the product function in the Fractions class and outputs
    the product of the list.
    */
   private void multiply()
   {
      System.out.println("The product of the list is: " + myList.product());
   }

   /**
    This method calls the sum function in the Fractions class and outputs the
    sum of the list.
    */
   private void sum()
   {
      System.out.println("The sum of the list is: " + myList.sum());
   }
}
