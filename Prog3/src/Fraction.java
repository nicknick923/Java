
/**
 This class allows you to create new fraction, and mathematical operations
 such as add subtract and multiply fractions.

 @author Jake Ira
 */
import java.util.StringTokenizer;

public class Fraction
{

   private int numerator, denominator;

   /**
    Initializes the fraction to 0/1.
    */
   public Fraction()
   {
      numerator = 0;
      denominator = 1;
   }

   /**
    Copy constructor that sets numerator equal to inFractions numerator and
    the denominator equal to inFractions denominator then reduces the fraction
    to its lowest form.

    @param inFraction fraction that gets copied into numerator and denominator
    */
   public Fraction(Fraction inFraction)
   {
      numerator = inFraction.numerator;
      denominator = inFraction.denominator;
      Reduce();
   }

   /**
    This function takes the numerator and denominator and sets them equal to
    the two input values then reduces the function.

    @param topNum an integer type parameter to store the numerator
    @param botNum an integer type parameter to store the denominator
    */
   public Fraction(int topNum, int botNum)
   {
      numerator = topNum;
      denominator = botNum;
      Reduce();
   }

   /**
    This method splits the inputed string into tokens where the first is the
    numerator and the second is the denominator, where the delimiter is '/'.

    @param fracString a string to be parsed
    */
   public Fraction(String fracString)
   {
      StringTokenizer st = new StringTokenizer(fracString, "()/");
      numerator = Integer.parseInt(st.nextToken());
      denominator = Integer.parseInt(st.nextToken());
      Reduce();
   }

   /**
    This method calculates the sum of the two fractions.

    @param inFraction fraction you are adding
    @return sum of the fractions
    */
   public Fraction add(Fraction inFraction)
   {

      int calcNumerator = numerator * inFraction.denominator
            + denominator * inFraction.numerator;
      int calcDenominator = denominator * inFraction.denominator;

      Fraction retFraction = new Fraction(calcNumerator, calcDenominator);
      return retFraction;

   }

   /**
    This method calculates the difference of two fractions.

    @param inFraction fraction you are subtracting
    @return difference of the fractions
    */
   public Fraction subtract(Fraction inFraction)
   {

      int calcNumerator = numerator * inFraction.denominator
            - denominator * inFraction.numerator;
      int calcDenominator = denominator * inFraction.denominator;

      Fraction retFraction = new Fraction(calcNumerator, calcDenominator);
      return retFraction;
   }

   /**
    This method calculates the product of two fractions.

    @param inFraction fraction you are multiplying
    @return the product of the two fractions
    */
   public Fraction multiply(Fraction inFraction)
   {
      int calcNumerator = numerator * inFraction.numerator;
      int calcDenominator = denominator * inFraction.denominator;

      Fraction retFraction = new Fraction(calcNumerator, calcDenominator);
      return retFraction;
   }

   /**
    This function returns a string with the numerator divided by the
    denominator.

    @return fraction in the form numerator/denominator
    */
   @Override
   public String toString()
   {
      return "(" + numerator + "/" + denominator + ")";
   }

   /**
    This method checks to see if two things are equal by checking that the
    instances of both are equal.

    @param x object being compared to original
    @return true if they're equal or false if they are not
    */
   @Override

   /**
    This method checks to see if two fractions are equal to each other.
    */
   public boolean equals(Object x)
   {
      if (x instanceof Fraction)
      {
         Fraction f = (Fraction) x;
         return numerator == f.numerator && denominator == f.denominator;
      }
      return false;
   }

   /**
    This function simplifies the function down to its lowest form. If the
    denominator is less than 0 multiply the top and bottom by -1 to make it
    positive.
    */
   private void Reduce()
   {
      int lowest, highest;
      if (Math.abs(numerator) > Math.abs(denominator))
      {
         highest = Math.abs(numerator);
         lowest = Math.abs(denominator);
      }
      else
      {
         highest = Math.abs(denominator);
         lowest = Math.abs(numerator);
      }
      while (lowest != 0)
      {
         int temp = lowest;
         lowest = highest % lowest;
         highest = temp;
      }
      numerator /= highest;
      denominator /= highest;
      if (denominator < 0)
      {
         denominator *= -1;
         numerator *= -1;
      }
   }

   /**
   This method tests the test functions in the fraction class.
   
   @param args command line arguments 
   */
   public static void main(String args[])
   {

      Fraction c1 = new Fraction();
      if (c1.toString().equals("(0/1)"))
         System.out.println("toString method passed");
      else
         System.out.println("toString method failed");

      if (c1.toString().equals("(4/8)"))
         System.out.println("toString method failed");
      else
         System.out.println("toString method passed");
      Fraction c2 = new Fraction(1, 2);
      if (c2.toString().equals("(1/2)"))
         System.out.println("toString method passed");
      else
         System.out.println("toString method failed");

      if (c2.toString().equals("(9/7)"))
         System.out.println("toString method failed");
      else
         System.out.println("toString method passed");
      Fraction c3 = new Fraction(c2);
      if (c3.toString().equals("(1/2)"))
         System.out.println("toString method passed");
      else
         System.out.println("toString method failed");

      if (c3.toString().equals("(6/9)"))
         System.out.println("toString method failed");
      else
         System.out.println("toString method passed");

      if (c2.equals(c3))
         System.out.println("equals method passed");
      else
         System.out.println("equals method failed");

      if (c2.equals(c1))
         System.out.println("equals method failed");
      else
         System.out.println("equals method passed");

      Fraction c4 = new Fraction("(2/4)");
      if (c4.equals(c3))
         System.out.println("Reduce and tokenizer methods passed");
      else
         System.out.println("Reduce and tokenizer methods failed");

      if (c4.equals(c1))
         System.out.println("Reduce and tokenizer methods failed");
      else
         System.out.println("Reduce and tokenizer methods passed");

      Fraction c5 = new Fraction("(3/4)");
      Fraction c6 = new Fraction("(1/4)");
      Fraction c7 = new Fraction("(1/1)");
      /*
       c1 = 0/1
       c2 = 1/2
       c3 = 1/2
       c4 = 1/2
       c5 = 3/4
       c6 = 1/4
       c7 = 1/1
      
       c2+c3 = c7 = 1/1
       c5-c3 = c6 = 1/4
       c2*c3 = c6 = 1/4
       */
      if (c2.add(c3).equals(c7))
         System.out.println("Add method passed");
      else
         System.out.println("Add method failed");

      if (c2.add(c1).equals(c7))
         System.out.println("Add method failed");
      else
         System.out.println("Add method passed");

      if (c5.subtract(c3).equals(c6))
         System.out.println("Subtrat method passed");
      else
         System.out.println("Subtract method failed");

      if (c5.subtract(c1).equals(c6))
         System.out.println("Subtract method failed");
      else
         System.out.println("Subtract method passed");

      if (c2.multiply(c3).equals(c6))
         System.out.println("Multiply method passed");
      else
         System.out.println("Multiply method failed");

      if (c2.multiply(c1).equals(c7))
         System.out.println("Multiply method failed");
      else
         System.out.println("Multiply method passed");

   }

}
