
/**
 This class reads in fractions and operators as strings, then pops of the two
 fractions before the operator as well as the operator converts the fraction
 strings to fractions then performs the operation that was provided then
 pushes the result back on to the stack.

 @author Jake Ira
 */
import java.util.Scanner;

public class RpnEvaluator
{

   private Scanner stdin;
   private Stack newStack;
   private Queue newQueue;
   private final int MAX_SIZE = 50;
   private boolean valid;
   private String command;

   /**
    This method consists of nested while loops that will read in a fraction as
    a string convert it to a fraction and call the necessary function based
    off the operand that is given.

    @throws java.io.IOException
    */
   public void run() throws java.io.IOException
   {
      newStack = new Stack(MAX_SIZE);
      newQueue = new Queue(MAX_SIZE);

      int count = 1;
      stdin = new Scanner(System.in);

      while (stdin.hasNext())
      {
         valid = true;
         while (valid && stdin.hasNext())
         {
            System.out.print("Expression " + count + " is: ");
            command = stdin.next();
            whichOperand();
            System.out.println();
            if (!command.equals("#"))
               stdin.findInLine("#");
            printResult();
            newQueue.clear();
            newStack.clear();
            valid = true;
            count++;
         }
      }
      System.out.println("Normal Termination of Program 3.");
   }

   /**
    This method reads in the fraction and pushes it onto the stack.

    @param fracString fraction being read in.
    */
   private void read(String fracString)
   {
      Fraction readInFraction = new Fraction(fracString);
      newStack.push(readInFraction);
      System.out.print(readInFraction.toString());
   }

   /**
    This method takes the previous two elements from the array and multiplies
    them together then pushes back the product.
    */
   private void multiply()
   {
      System.out.print("*");
      Fraction frac2 = null;
      Fraction frac1 = null;
      Fraction result = null;
      if (!newStack.isEmpty())
         frac2 = (Fraction) newStack.pop();
      if (!newStack.isEmpty())
         frac1 = (Fraction) newStack.pop();
      if (frac2 != null && frac1 != null)
      {
         result = frac1.multiply(frac2);
         newStack.push(result);
         newQueue.add(result);
      }
      else
         valid = false;
   }

   /**
    This method checks to see if the list contains fractions, if the list is
    not empty it will pop the top value from the stack and set finalResult
    equal to it, and if the stack is empty it will set valid to false and
    return an error message.
    */
   private void printResult()
   {
      Fraction finalResult = null;
      if (!newStack.isEmpty())
         finalResult = (Fraction) newStack.pop();
      else
         valid = false;
      if (!newStack.isEmpty())
         valid = false;
      if (!valid)
         System.out.println("Invalid Expression");
      else
         System.out.println("The value is: " + finalResult.toString());
      System.out.println("Intermediate results: " + intermediateValue());

   }

   /**
    This method takes the previous two elements from the array and adds them
    together then pushes back the sum.
    */
   private void add()
   {
      System.out.print("+");
      Fraction frac2 = null;
      Fraction frac1 = null;
      Fraction result = null;
      if (!newStack.isEmpty())
         frac2 = (Fraction) newStack.pop();
      if (!newStack.isEmpty())
         frac1 = (Fraction) newStack.pop();
      if (frac2 != null && frac1 != null)
      {
         result = frac1.add(frac2);
         newStack.push(result);
         newQueue.add(result);
      }
      else
         valid = false;
   }

   /**
    This method takes the previous two elements from the array and subtracts
    them together then pushes back the sum.
    */
   private void subtract()
   {
      System.out.print("-");
      Fraction frac2 = null;
      Fraction frac1 = null;
      Fraction result = null;
      if (!newStack.isEmpty())
         frac2 = (Fraction) newStack.pop();
      if (!newStack.isEmpty())
         frac1 = (Fraction) newStack.pop();
      if (frac2 != null && frac1 != null)
      {
         result = frac1.subtract(frac2);
         newStack.push(result);
         newQueue.add(result);
      }
      else
         valid = false;

   }

   /**
    This method runs a while loop to output all of the fractions within the
    queue.

    @return fractions in the queue.
    */
   private String intermediateValue()
   {
      String intermediateValueString = "";
      while (!newQueue.isEmpty())
         intermediateValueString += newQueue.remove().toString();
      return intermediateValueString;
   }

   /**
    This method runs a while loop to determine which operation needs to be
    run, then calls the method based on the operand given, then reads in the
    next string.
    */
   private void whichOperand()
   {
      while (!command.equals("#") && valid)
      {
         if (command.charAt(0) == '(')
            read(command);
         else if (command.equals("*"))
            multiply();
         else if (command.equals("+"))
            add();
         else if (command.equals("-"))
            subtract();
         else
         {
            valid = false;
            System.out.print(command);
         }
         command = stdin.next();
      }
   }
}
