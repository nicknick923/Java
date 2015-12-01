
/**
 This class is used to evaluate reverse polish notation expressions that end
 with a #. This class only outputs an answer when an expression is valid.

 @author Jake Ira
 @author Nick Sosinski
 */
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMsg;
import java.util.Scanner;

public class RpnEvaluator
{
   
   private final Fraction EMPTY_FRACTION_VALUE = null;
   private final Stack fracStack = new Stack();
   private final Queue fracQueue = new Queue();
   private final Scanner stdin = new Scanner(System.in);
   private boolean isValid;
   private String myStringTok;
   private Fraction answer;
   private Fraction mathFrac1;
   private Fraction mathFrac2;
   
   public RpnEvaluator() throws Exception
   {
      commandRun();
   }
   
   public RpnEvaluator(String initStr)
   {
      myStringTok = initStr;
   }

   /**
    This class is the one that is called by Prog6 and is run until end of file
    evaluating RPN expressions.

    @throws java.io.IOException Thrown when the input has failed in some way.
    */
   private void commandRun() throws java.io.IOException
   {
      int numCompleated = 0;
      while (stdin.hasNext())
      {
         isValid = true;
         while (stdin.hasNext() && isValid)
         {
            myStringTok = stdin.next();
            numCompleated++;
            System.out.print("Expression " + numCompleated + " is: ");
            while (isValid && !myStringTok.equals("#"))
            {
               expressionProcessor();
               myStringTok = stdin.next();
            }
            if (!myStringTok.equals("#"))
               stdin.findInLine("#");
            System.out.println();
            printFinalResult();
         }
      }
      System.out.println("Normal Termination of Program 3.");
   }
   
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
   
   public void processToken()
   {
      if (isValid)
      {
         expressionProcessor();
         myStringTok = myStringTok.substring(myStringTok.indexOf(" "));
      }
   }

   /**
    This method determines what to do with the current token.
    */
   private void expressionProcessor()
   {
      while (isValid && !myStringTok.equals("#"))
         if (myStringTok.charAt(0) == '(')
            pushFraction(myStringTok);
         else if (myStringTok.equals("+"))
            addHelper();
         else if (myStringTok.equals("-"))
            subtractHelper();
         else if (myStringTok.equals("*"))
            multiplyHelper();
         else
         {
            System.out.print(myStringTok);
            isValid = false;
         }
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
   
   public boolean getValid()
   {
      return isValid;
   }
   
   public boolean getDone()
   {
      
   }
   
   public Fraction getAnswer()
   {
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
