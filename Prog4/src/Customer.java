
/**
 This class represents a customer with data including an arrival time stamp
 and a number. There is a static integer variable named customerCount that is
 incremented for each new customer created.

 @author Nick Sosinski
 @author Jake Ira
 */
public class Customer
{

   private static int customerCount = 0;   // # of customers created
   private final int customerNumber;      // Set to incremented customerCount 
   private final int arrivalTime;

   /**
    This method creates a customer with the customer number being a unique
    number that is assigned to the incremented customer count, and a arrival
    time that is passed in through the parameter inTIme.

    @param inTime The time the customer was created.
    */
   public Customer(int inTime)
   {
      arrivalTime = inTime;
      customerNumber = ++customerCount;
   }

   /**
    This method returns "C" followed by customer number, followed by "/T"
    followed by the arrival time.

    @return A String containing: "C" followed by customer number, followed by
    "/T" followed by the arrival time.
    */
   @Override
   public String toString()
   {
      return "C" + customerNumber + "/T" + arrivalTime;
   }

   /**
    This method returns the arrival time of the customer.

    @return An integer value of the arrival time.
    */
   public int getArrivalTime()
   {
      return arrivalTime;
   }
}
