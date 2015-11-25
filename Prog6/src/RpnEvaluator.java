
/**
 This class is used to evaluate reverse polish notation expressions that end
 with a #. This class only outputs an answer when an expression is valid.

 @author Jake Ira
 @author Nick Sosinski
 */
import java.util.Scanner;

public class RpnEvaluator
{

   private final int MAXIMUM_SIZE = 50;
   private final Fraction EMPTY_FRACTION_VALUE = null;
   private final Stack fracStack = new Stack();
   private final Queue fracQueue = new Queue(MAXIMUM_SIZE);
   private final Scanner stdin = new Scanner(System.in);
   private boolean isValid;
   private String token;
   private Fraction mathFrac1;
   private Fraction mathFrac2;

   /**
    This class is the one that is called by Prog3 and is run until end of file
    evaluating RPN expressions.

    @throws java.io.IOException Thrown when the input has failed in some way.
    */
   public void run() throws java.io.IOException
   {
      int numCompleated = 0;
      while (stdin.hasNext())
      {
         isValid = true;
         while (stdin.hasNext() && isValid)
         {
            token = stdin.next();
            numCompleated++;
            System.out.print("Expression " + numCompleated + " is: ");
            expressionProcessor();
            if (!token.equals("#"))
               stdin.findInLine("#");
            System.out.println();
            printFinalResult();
         }
      }
      System.out.println("Normal Termination of Program 3.");
   }

   /**
    This method determines what to do with the current token.
    */
   private void expressionProcessor()
   {
      while (isValid && !token.equals("#"))
      {
         if (token.charAt(0) == '(')
            pushFraction(token);
         else if (token.equals("+"))
            addHelper();
         else if (token.equals("-"))
            subtractHelper();
         else if (token.equals("*"))
            multiplyHelper();
         else
         {
            System.out.print(token);
            isValid = false;
         }
         token = stdin.next();
      }
   }

   /**
    This method creates a fraction object then pushes it onto the stack.

    @param fracString The fraction in the form of a string in parentheses
    */
   private void pushFraction(String fracString)
   {
      Fraction readInFraction = new Fraction(fracString);
      fracStack.push(readInFraction);
      System.out.print(readInFraction.toString());
   }

   /**
    This method prints the results of the expression if valid and if invalid
    notifies the user. It also prepares the program for the next expression.
    */
   private void printFinalResult()
   {
      Fraction finalResult = EMPTY_FRACTION_VALUE;
      if (!fracStack.isEmpty())
         finalResult = (Fraction) fracStack.pop();
      else
         isValid = false;
      if (!fracStack.isEmpty())
         isValid = false;
      if (isValid)
         System.out.println("The value is: " + finalResult.toString());
      else
         System.out.println("Invalid Expression");
      System.out.println("Intermediate results: " + intermediateValue());

      fracQueue.clear();
      fracStack.clear();
      isValid = true;
   }

   /**
    If valid, this method adds two fractions then places the result on the
    queue. It also prints the operator symbol.
    */
   private void addHelper()
   {
      Fraction result;
      if (fractionPopper())
      {
         result = mathFrac1.addFraction(mathFrac2);
         fracQueue.add(result);
         fracStack.push(result);
      }
      System.out.print("+");
   }

   /**
    If valid, this method subtracts two fractions then places the result on
    the queue. It also prints the operator symbol.
    */
   private void subtractHelper()
   {
      Fraction result;
      if (fractionPopper())
      {
         result = mathFrac2.subtractFraction(mathFrac1);
         fracQueue.add(result);
         fracStack.push(result);
      }
      System.out.print("-");
   }

   /**
    If valid, this method multiplies two fractions then places the result on
    the queue. It also prints the operator symbol.
    */
   private void multiplyHelper()
   {
      Fraction result;
      if (fractionPopper())
      {
         result = mathFrac1.multiplyFraction(mathFrac2);
         fracStack.push(result);
         fracQueue.add(result);
      }
      System.out.print("*");
   }

   private boolean fractionPopper()
   {
      mathFrac1 = EMPTY_FRACTION_VALUE;
      mathFrac2 = EMPTY_FRACTION_VALUE;
      if (!fracStack.isEmpty())
         mathFrac1 = (Fraction) fracStack.pop();
      if (!fracStack.isEmpty())
         mathFrac2 = (Fraction) fracStack.pop();
      isValid = mathFrac1 != EMPTY_FRACTION_VALUE && mathFrac2 != EMPTY_FRACTION_VALUE;
      return isValid;

   }

   /**
    This method returns a string of the intermediate values recoded during the
    processing of the expression.

    @return The string of intermediate values.
    */
   private String intermediateValue()
   {
      String intermediateValueString = "";
      while (!fracQueue.isEmpty())
         intermediateValueString += fracQueue.remove().toString();
      return intermediateValueString;
   }
}
