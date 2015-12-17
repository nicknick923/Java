// Start of Example1.java
import java.util.Scanner;

/**
Simple Java array program.
This program shows some similarities and differences between Java and C++.
Normally, you would comment about what the program DOES.
My comments here are not meant to document but 
to point out some Java features.
@author Tom Scanlan
*/
public class Example1
{
   // These are class-wide data.  Only put "state" information up here.
   // Variables that should be local to methods MUST be local!
   private final int MAX_SIZE = 5;            // New way to declare constants
   private int values[] = new int[MAX_SIZE];  // New way to declare arrays
   private int num_values = 0;                // int's look about the same

   /**
   Runs Example1.
   You can think of this as similar to a C++ "main" for now.
   */
   public void run()
   {
      System.out.println("\n\nEnter some integers, one per line.\n" +
                         "Enter some non-digit character followed" +
                          " by Enter to quit, e.g. 'x'.\n" );
      read();
      float ave = average();
      System.out.println("\nThe average is " + ave);
      System.out.println("The number of values greater than the " +
                         "average is " + numGreaterThan( (int)ave) );
      System.out.println ( "The maximum value is " + maximum() );
      System.out.println ( "The minimum value is " + minimum() );
   }

   /**
   Reads integers and stores them in an array.
   Reads from the standard input and stores in the array "values".
   Quits when there is NO next integer to get or when the array is full.
   Values read in are "appended" to the end of the array.
   */
   private void read()
   {
      Scanner stdin = new Scanner(System.in);
      while ( num_values < values.length && stdin.hasNextInt() ) 
         values[num_values++] = stdin.nextInt();
   }

   /**
   Calculates the average of the integers stored in the array.
   @return average of elements in the array, 0.0 if no elements in the array.
   */
   private float average()
   {
      float ave = 0.0F;  // Floating point constants are doubles without the F
      int sum = 0;
      for ( int i = 0; i < num_values; i++ )
         sum += values[i];
      if ( num_values > 0 )
         ave = (float)sum / (float)num_values;       // Note C-style cast
      return ave;
   }

   /**
   Calculates the number of integers in the array that are greater than val.
   @param val is the value to compare against
   @return number of integers in the array that are greater than val.
   */
   private int numGreaterThan ( int val )
   {
      int count = 0;             // Code for this looks EXACTLY like C++
      for ( int i = 0; i < num_values; i++ )
         if ( values[i] > val )
            ++count;
      return count;
   }

   /**
   Calculates the largest value in the array.
   @return the largest value in the array.
   */
   private int maximum()
   {
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < num_values; i++)
         if ( values[i] > max)
            max = values[i];
      return max;
   }
      /**
   Calculates the smallest value in the array.
   @return the smallest value in the array.
   */
   private int minimum()
   {
      int min = Integer.MAX_VALUE;
      for (int i = 0; i < num_values; i++)
         if ( values[i] < min)
            min = values[i];
      return min;
   }
   
}  // class Example1
