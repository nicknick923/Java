
/**
 This class is used to evaluate reverse polish notation expressions. This
 class only outputs an answer when an expression is valid.

 @author Jake Ira
 @author Nick Sosinski
 */
import java.util.Scanner;
import java.util.StringTokenizer;

public class RpnEvaluator
{

   private final Fraction EMPTY_FRACTION_VALUE = null;
   private Stack fracStack = new Stack();
   private Queue fracQueue = new Queue();
   private Scanner stdin = new Scanner(System.in);
   private boolean isValid = true;
   private StringTokenizer myStringTok;
   private Fraction answer;
   private Fraction mathFrac1;
   private Fraction mathFrac2;

   /**
    This constructor runs the method for command line input.

    @throws java.io.IOException Thrown when the input has failed in some way.
    */
   public RpnEvaluator() throws java.io.IOException
   {
      commandRun();
   }

   /**
    This constructor sets myStringTok to the passed string and thats all.

    @param initStr The full expression string to be processed.
    */
   public RpnEvaluator(String initStr)
   {
      myStringTok = new StringTokenizer(initStr);
   }

   /**
    This class is the one that is called by the parameterless constructor and
    is run until end of file evaluating RPN expressions.

    @throws java.io.IOException Thrown when the input has failed in some way.
    */
   private void commandRun() throws java.io.IOException
   {
      String expressionString;
      int numCompleated = 0;
      while (stdin.hasNext())
      {
         isValid = true;
         while (stdin.hasNext() && isValid)
         {
            expressionString = stdin.next();
            numCompleated++;
            System.out.print("Expression " + numCompleated + " is: ");
            while (isValid && !expressionString.equals("#"))
            {
               processToken(expressionString);
               expressionString = stdin.next();
            }
            if (!expressionString.equals("#"))
               stdin.findInLine("#");
            System.out.println();
            printFinalResult();
         }
      }
      System.out.println("Normal Termination of Program 3.");
   }

   /**
    This method processes the token passed in.

    @param tok The token that is to be processed.
    */
   public void processToken(String tok)
   {
      if (tok.charAt(0) == '(')
         pushFraction(tok);
      else if (tok.equals("+"))
         addHelper();
      else if (tok.equals("-"))
         subtractHelper();
      else if (tok.equals("*"))
         multiplyHelper();
      else
      {
         System.out.print(tok);
         isValid = false;
      }
   }

   /**
    This method is called from the GUI to process to compleat the next step.
    */
   public void processToken()
   {
      if (myStringTok.hasMoreTokens())
      {
         String nextToken = myStringTok.nextToken();
         processToken(nextToken);
      }
      else
         isValid = false;
   }

   /**
    This method returns the fraction stack.

    @return The fraction stack.
    */
   public Stack getStack()
   {
      return fracStack;
   }

   /**
    This method returns the fraction queue.

    @return The fraction queue.
    */
   public Queue getQueue()
   {
      return fracQueue;
   }

   /**
    This method returns true if the rpnExpression is valid up to this point.

    @return True if it is valid, false if it is invalid.
    */
   public boolean getValid()
   {
      return isValid;
   }

   /**
    This method returns true if the processing is complete.

    @return True if it is dine, false if not.
    */
   public boolean getDone()
   {
      return !myStringTok.hasMoreTokens();
   }

   /**
    This method returns the answer.

    @return The answer.
    */
   public Fraction getAnswer()
   {
      if ((!fracStack.isEmpty()) && !myStringTok.hasMoreTokens())
      {
         answer = (Fraction) fracStack.pop();
         if (!fracStack.isEmpty())
            isValid = false;
      }
      return answer;
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

   /**
    This method tests to see if popping two fractions the stack will make the
    program invalid, if it remains valid, then the two fractions have been
    popped into mathFrac1 and mathFrac2 and the method returned true if its
    still valid, false if not.

    @return True if the pop was successful or false if it wasn't.
    */
   private boolean fractionPopper()
   {
      mathFrac1 = EMPTY_FRACTION_VALUE;
      mathFrac2 = EMPTY_FRACTION_VALUE;
      if (!fracStack.isEmpty())
         mathFrac1 = (Fraction) fracStack.pop();
      if (!fracStack.isEmpty())
         mathFrac2 = (Fraction) fracStack.pop();
      isValid = mathFrac1 != EMPTY_FRACTION_VALUE
            && mathFrac2 != EMPTY_FRACTION_VALUE;
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
