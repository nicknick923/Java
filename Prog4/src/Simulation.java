
/**
 This class is a simulation of a single-line, single-server system and also
 handles all the details of the simulation. In this class you can add
 customers, serve customers, get information on the current customer and also
 information on the line. Finally, it can also return certain statistics that
 were maintained since the creation of the simulation.

 @author Nick Sosinski
 @author Jake Ira
 */
public class Simulation
{

   private static final int MAX_LINE_LENGTH = 5;
   private Queue<Customer> q = new Queue(MAX_LINE_LENGTH);
   private int curTime = 0;               // current time
   private Customer curServed = null;     // current customer being served,
   // null if none being served
   private int peopleCompleted = 0;
   private int peopleNoWait = 0;
   private int peopleThatHadToWait = 0;
   private int sumOfWaitTime = 0;
   // NO other data members
   //    -3 for each violation of
   //    each additional data member
   /**
    This method is called to add a person to the simulation. If the queue is
    full, it sends the customer away. If the queue is not full, it adds it to
    the queue unless there is nobody being served, in which case it places the
    customer at the mercy of the the server.

    @param inCustomer The customer to be added to the simulation.
    @return A boolean value of true if the customer was added or false if they
    weren't added.
    */
   public boolean addCustomer(Customer inCustomer)
   {
      if (!q.isFull())
      {
         if (!isHelpingCustomer())
         {
            curServed = inCustomer;
            peopleNoWait++;
         }
         else
            q.add(inCustomer);
         return true;
      }
      else
         return false;
   }

   /**
    This method is called to serve the next customer in the queue. If there is
    no customer, it sets curServed to null. If there is customer(s) in the
    queue, then it removes the next one and sets it to curServed. It also
    increments the number of people that had to wait in the queue when the
    customer is removed. It adds the customers wait time to the sumOfWaitTime.
    Finally, it increments the number of customers served.
    */
   public void serveCustomer()
   {
      if (q.isEmpty())
         curServed = null;
      else
      {
         peopleThatHadToWait++;
         curServed = q.remove();
         int waitTime = curTime - curServed.getArrivalTime();
         sumOfWaitTime += waitTime;
      }
      peopleCompleted++;
   }

   /**
    This method increments time by time units.

    @param time The number of units to add to time.
    @return A boolean of true if time was incremented, or false if the request
    was denied.
    */
   public boolean advanceTime(int time)
   {
      if (time <= 0)
         return false;
      else
         curTime += time;
      return true;
   }

   /**
    If the server is helping a customer, this method returns as string
    representation of curServed, otherwise if no customer is being served, it
    returns "none".

    @return A string containing either information about the customer or
    "none" indicating there is no customer being served currently.
    */
   public String curCustomer()
   {
      if (curServed == null)
         return "none";
      else
         return curServed.toString();
   }

   /**
    This method returns a boolean value of true if the server is helping a
    customer, or false if not.

    @return A boolean value of true if the server is helping a customer, or
    false if not.
    */
   public boolean isHelpingCustomer()
   {
      return curServed != null;
   }

   /**
    This method returns the sum of the total wait time.

    @return An integer value representing the sum of the wait time.
    */
   public int totalWaitTime()
   {
      return sumOfWaitTime;
   }

   /**
    This calculates the average wait time of the people that had to wait, or 0
    if nobody waited.

    @return A double value representing the average wait time of customers
    that had to wait.
    */
   public double calculateAverageWait()
   {
      if (peopleThatHadToWait > 0)
         return (double) sumOfWaitTime / peopleThatHadToWait;
      return 0;
   }

   /**
    This method returns the number of people that didn't need to wait.

    @return An integer value representing the number of people that didn't
    need to wait.
    */
   public int numWithNoWait()
   {
      return peopleNoWait;
   }

   /**
    This method returns the number of people that were served.

    @return An integer value representing the number of people that were
    served.
    */
   public int numServed()
   {
      return peopleCompleted;
   }

   /**
    This method returns the current time.

    @return An integer value representing the current time.
    */
   public int getTime()
   {
      return curTime;
   }

   /**
    This method returns the number of customers waiting in the queue.

    @return An integer value representing the number of customers waiting in
    the queue.
    */
   public int numWaiting()
   {
      int count = 0;
      Queue<Customer> tempQueue = new Queue(MAX_LINE_LENGTH);
      while (!q.isEmpty())
      {
         tempQueue.add(q.remove());
         count++;
      }
      while (!tempQueue.isEmpty())
         q.add(tempQueue.remove());
      return count;
   }

   /**
    This method tests the public and private methods of the simulation class.

    @param args The command line arguments. (not used).
    */
   public static void main(String args[])
   {
      Simulation testSim = new Simulation();
      Customer testCustomer;
      int testTime = 0;

      if (testSim.numWaiting() == 0)
         System.out.println("numWaiting--------------Pass");
      else
         System.out.println("numWaiting--------------Fail");

      if (testSim.numWithNoWait() == 0)
         System.out.println("numWithNoWait-----------Pass");
      else
         System.out.println("numWithNoWait-----------Fail");

      if (testSim.calculateAverageWait() == 0)
         System.out.println("calculateAverageWait----Pass");
      else
         System.out.println("calculateAverageWait----Fail");

      if (testSim.getTime() == 0)
         System.out.println("getTime-----------------Pass");
      else
         System.out.println("getTime-----------------Fail");

      if (testSim.numServed() == 0)
         System.out.println("numServed---------------Pass");
      else
         System.out.println("numServed---------------Fail");

      if (testSim.totalWaitTime() == 0)
         System.out.println("totalWaitTime-----------Pass");
      else
         System.out.println("totalWaitTime-----------Fail");

      if (testSim.isHelpingCustomer())
         System.out.println("isHelpingCustomer-------Fail");
      else
         System.out.println("isHelpingCustomer-------Pass");

      if (testSim.curCustomer().equals("none"))
         System.out.println("curCustomer-------------Pass");
      else
         System.out.println("curCustomer-------------Fail");

      testSim.advanceTime(1);
      testTime += 1;
      if (testSim.getTime() == testTime)
         System.out.println("advanceTime-------------Pass");
      else
         System.out.println("advanceTime-------------Fail");

      testSim.advanceTime(-1);
      if (testSim.getTime() == testTime)
         System.out.println("advanceTime-------------Pass");
      else
         System.out.println("advanceTime-------------Fail");

      testSim.advanceTime(0);
      if (testSim.getTime() == testTime)
         System.out.println("advanceTime-------------Pass");
      else
         System.out.println("advanceTime-------------Fail");
      
      if (testSim.getTime() == 1)
         System.out.println("getTime-----------------Pass");
      else
         System.out.println("getTime-----------------Fail");

      testCustomer = new Customer(testTime);
      testSim.addCustomer(testCustomer);
      if (testSim.numWithNoWait() == 1)
         System.out.println("numWithNoWait-----------Pass");
      else
         System.out.println("numWithNoWait-----------Fail");
      testSim.serveCustomer();

      if (testSim.numServed() == 1)
         System.out.println("numServed---------------Pass");
      else
         System.out.println("numServed---------------Fail");
      
      for (int i = 0; i < MAX_LINE_LENGTH + 1; i++)
      {
         testCustomer = new Customer(testTime);
         if (testSim.addCustomer(testCustomer))
            System.out.println("addCustomer-------------Pass");
         else
            System.out.println("addCustomer-------------Fail");
      }

      testCustomer = new Customer(testTime);
      if (testSim.addCustomer(testCustomer))
         System.out.println("addCustomer-------------Fail");
      else
         System.out.println("addCustomer-------------Pass");

      if (testSim.isHelpingCustomer())
         System.out.println("isHelpingCustomer-------Pass");
      else
         System.out.println("isHelpingCustomer-------Fail");

      if (testSim.numWaiting() == 5)
         System.out.println("numWaiting--------------Pass");
      else
         System.out.println("numWaiting--------------Fail");

      int numServed = testSim.peopleCompleted;
      while (testSim.isHelpingCustomer())
      {
         testSim.serveCustomer();
         if (numServed < testSim.peopleCompleted)
         {
            numServed = testSim.peopleCompleted;
            System.out.println("serveCustomer-----------Pass");
         }
         else
         {
            numServed = testSim.peopleCompleted;
            System.out.println("serveCustomer-----------Fail");
         }
      }
      if (testSim.numServed() == 7)
         System.out.println("numServed---------------Pass");
      else
         System.out.println("numServed---------------Fail");

      testCustomer = new Customer(testTime);
      testSim.addCustomer(testCustomer);
      if (testSim.curCustomer().equals(testCustomer.toString()))
         System.out.println("curCustomer-------------Pass");
      else
         System.out.println("curCustomer-------------Fail");
      testSim.serveCustomer();
      
      if (testSim.numServed() == 8)
         System.out.println("numServed---------------Pass");
      else
         System.out.println("numServed---------------Fail");

      //Preping for first average test
      testSim.curTime = 0;
      testSim.peopleCompleted = 0;
      testSim.peopleNoWait = 0;
      testSim.peopleThatHadToWait = 0;
      testSim.sumOfWaitTime = 0;
      if (testSim.calculateAverageWait() == 0)
         System.out.println("calculateAverageWait----Pass");
      else
         System.out.println("calculateAverageWait----Fail");

//prepping for second average test
      testSim.curTime = 7;
      testSim.peopleCompleted = 1;
      testSim.peopleNoWait = 1;
      testSim.peopleThatHadToWait = 1;
      testSim.sumOfWaitTime = 1;
      if (testSim.calculateAverageWait() == 1.0)
         System.out.println("calculateAverageWait----Pass");
      else
         System.out.println("calculateAverageWait----Fail");

      //prepping for third average test
      testSim.curTime = 9;
      testSim.peopleCompleted = 2;
      testSim.peopleNoWait = 1;
      testSim.peopleThatHadToWait = 2;
      testSim.sumOfWaitTime = 1;
      if (testSim.calculateAverageWait() == 0.5)
         System.out.println("calculateAverageWait----Pass");
      else
         System.out.println("calculateAverageWait----Fail");

//prepping for fourth average test
      testSim.curTime = 13;
      testSim.peopleCompleted = 3;
      testSim.peopleNoWait = 1;
      testSim.peopleThatHadToWait = 3;
      testSim.sumOfWaitTime = 7;
      if (testSim.calculateAverageWait() == 2.3333333333333335)
         System.out.println("calculateAverageWait----Pass");
      else
         System.out.println("calculateAverageWait----Fail");

//prepping for fifth average test
      testSim.curTime = 22;
      testSim.peopleCompleted = 8;
      testSim.peopleNoWait = 1;
      testSim.peopleThatHadToWait = 7;
      testSim.sumOfWaitTime = 36;
      if (testSim.calculateAverageWait() == 5.142857142857143)
         System.out.println("calculateAverageWait----Pass");
      else
         System.out.println("calculateAverageWait----Fail");

//prepping for sixth average test
      testSim.curTime = 22;
      testSim.peopleCompleted = 8;
      testSim.peopleNoWait = 1;
      testSim.peopleThatHadToWait = 7;
      testSim.sumOfWaitTime = 36;
      if (testSim.calculateAverageWait() == 5.142857142857143)
         System.out.println("calculateAverageWait----Pass");
      else
         System.out.println("calculateAverageWait----Fail");
//using last setup to check the remaining methods
      if (testSim.totalWaitTime() == 36)
         System.out.println("totalWaitTime-----------Pass");
      else
         System.out.println("totalWaitTime-----------Fail");
   }
}
