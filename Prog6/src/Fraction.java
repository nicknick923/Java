
/**
 This class has commands to create and perform mathematics on individual
 fractions.

 @author Nick Sosinski
 */
import java.util.StringTokenizer;

public class Fraction
{

   private int numerator, denominator;

   /**
    Default constructor that creates a fraction 0/1.
    */
   public Fraction()
   {
      numerator = 0;
      denominator = 1;
   }

   /**
    Copy Constructor.

    @param inFraction The fraction to be copied.
    */
   public Fraction(Fraction inFraction)
   {
      numerator = inFraction.numerator;
      denominator = inFraction.denominator;
      reduce();
   }

   /**
    Constructor that is passed in a string in the form of numerator "/"
    denominator.

    @param FractionString The fraction string in the form of
    numerator/denominator
    */
   public Fraction(String FractionString)
   {
      StringTokenizer st = new StringTokenizer(FractionString, "/()");
      numerator = Integer.parseInt(st.nextToken());
      denominator = Integer.parseInt(st.nextToken());
      reduce();
   }

   /**
    Fraction constructor that takes two integer values and creates a fraction
    object.

    @param nu The fractions numerator
    @param de The fractions denominator
    */
   public Fraction(int nu, int de)
   {
      numerator = nu;
      denominator = de;
      reduce();
   }

   /**
    This method returns the the fraction in the form of a string with
    (numerator / denominator).

    @return A string in the form of "(" numerator "/" denominator ")"
    */
   @Override
   public String toString()
   {
      return "(" + numerator + "/" + denominator + ")";
   }

   /**
    This method returns a boolean value of true if two fraction objects are
    equal, and false if not.

    @param x The second object to be compared
    @return The boolean value indicating weather the two objects were equal
    */
   @Override
   public boolean equals(Object x)
   {
      if (x instanceof Fraction)
      {
         Fraction f = (Fraction) x;
         return f.numerator == numerator && f.denominator == denominator;
      }
      return false;
   }

   /**
    This method simply reduces the fraction.
    */
   private void reduce()
   {
      int lowest, highest, temp;
      if (Math.abs(numerator) > Math.abs(denominator))
      {
         lowest = Math.abs(denominator);
         highest = Math.abs(numerator);
      }
      else
      {
         highest = Math.abs(denominator);
         lowest = Math.abs(numerator);
      }
      while (lowest != 0)
      {
         temp = lowest;
         lowest = highest % lowest;
         highest = temp;
      }
      numerator = numerator / highest;
      denominator = denominator / highest;
      if (denominator < 0)
      {
         numerator = numerator * -1;
         denominator = denominator * -1;
      }
   }

   /**
    This method takes a fraction and adds it to the the fraction that called
    the method and returns the result of the addition.

    @param inFraction The other summand fraction
    @return The resulting fraction in reduced form
    */
   public Fraction addFraction(Fraction inFraction)
   {
      Fraction f1, f2, returnFraction;
      returnFraction = new Fraction();
      f1 = new Fraction(numerator, denominator);
      f2 = new Fraction(inFraction);
      returnFraction.numerator = (f1.numerator * f2.denominator)
            + (f2.numerator * f1.denominator);
      returnFraction.denominator = f1.denominator * f2.denominator;
      returnFraction.reduce();
      return returnFraction;
   }

   /**
    This method returns the result of the subtraction of the calling fraction
    minus the passed in fraction.

    @param inFraction The subtrahend fraction
    @return The resulting fraction in reduced form
    */
   public Fraction subtractFraction(Fraction inFraction)
   {
      Fraction f1, f2, returnFraction;
      returnFraction = new Fraction();
      f1 = new Fraction(numerator, denominator);
      f2 = new Fraction(inFraction);
      returnFraction.numerator = (f1.numerator * f2.denominator)
            - (f2.numerator * f1.denominator);
      returnFraction.denominator = f1.denominator * f2.denominator;
      returnFraction.reduce();
      return returnFraction;
   }

   /**
    This method returns the product of the passed in fraction times the
    fraction that called the method.

    @param inFraction The other multiplicand fraction
    @return The resulting fraction in reduced form
    */
   public Fraction multiplyFraction(Fraction inFraction)
   {
      Fraction f1, f2, returnFraction;
      returnFraction = new Fraction();
      f1 = new Fraction(numerator, denominator);
      f2 = new Fraction(inFraction);
      returnFraction.numerator = f1.numerator * f2.numerator;
      returnFraction.denominator = f1.denominator * f2.denominator;
      returnFraction.reduce();
      return returnFraction;
   }

   /**
    This method tests the Fraction class.

    @param args command line arguments
    */
   public static void main(String args[])
   {
      Fraction c1 = new Fraction();
      Fraction c2 = new Fraction(c1);
      Fraction c3 = new Fraction(1, 4);
      Fraction c4 = new Fraction("(5/8)");
      Fraction c5 = new Fraction(c4);
      Fraction c6 = new Fraction("(4/64)");
      Fraction c7 = new Fraction("(1/16)");
      Fraction c8 = new Fraction("(18/32)");
      Fraction c9 = new Fraction("(9/16)");
      Fraction c10 = new Fraction("(5/32)");

      if (c1.toString().equals("(0/1)"))
         System.out.println("toString----------------Pass");
      else
         System.out.println("toString----------------Fail");

      if (c2.toString().equals("(0/1)"))
         System.out.println("Copy Constructor--------Pass");
      else
         System.out.println("Copy Constructor--------Fail");

      if (c3.toString().equals("(1/4)"))
         System.out.println("Two Integer Constructor-Pass");
      else
         System.out.println("Two Integer Constructor-Fail");

      if (c4.toString().equals("(5/8)"))
         System.out.println("Tokenizer Constructor---Pass");
      else
         System.out.println("Tokenizer Constructor---Fail");

      if (c1.equals(c2))
         System.out.println("Equals Method-----------Pass");
      else
         System.out.println("Equals Method-----------Fail");

      if (c1.equals(c3))
         System.out.println("Equals Method-----------Fail");
      else
         System.out.println("Equals Method-----------Pass");

      c4.reduce();
      if (c5.equals(c4))
         System.out.println("Reduce Method-----------Pass");
      else
         System.out.println("Reduce Method-----------Fail");

      c6.reduce();
      if (c7.equals(c6))
         System.out.println("Reduce Method-----------Pass");
      else
         System.out.println("Reduce Method-----------Fail");

      c8.reduce();
      if (c9.equals(c5))
         System.out.println("Reduce Method-----------Fail");
      else
         System.out.println("Reduce Method-----------Pass");

      if (c7.addFraction(c9).equals(c4))
         System.out.println("Add Method--------------Pass");
      else
         System.out.println("Add Method--------------Fail");

      if (c7.addFraction(c9).equals(c7))
         System.out.println("Add Method--------------Fail");
      else
         System.out.println("Add Method--------------Pass");

      if (c4.subtractFraction(c7).equals(c9))
         System.out.println("Subtract Method---------Pass");
      else
         System.out.println("Subtract Method---------Fail");

      if (c4.subtractFraction(c7).equals(c4))
         System.out.println("Subtract Method---------Fail");
      else
         System.out.println("Subtract Method---------Pass");

      if (c3.multiplyFraction(c4).equals(c10))
         System.out.println("Multiply Method---------Pass");
      else
         System.out.println("Multiply Method---------Fail");

      if (c3.multiplyFraction(c4).equals(c6))
         System.out.println("Multiply Method---------Fail");
      else
         System.out.println("Multiply Method---------Pass");
   }
}
