
/**
 This class creates a simulation object and then reads and processes commands
 from the standard input until the "Q" command is given.

 @author Nick Sosinski
 @author Jake Ira
 */
import java.util.Scanner;

public class ConsoleSimulation
{

   Scanner stdin = new Scanner(System.in);
   Simulation sim = new Simulation();

   /**
    This method reads and processes commands from the standard input until the
    "Q" command is given. If the command is invalid, it reads the rest of the
    line and discards it.
    */
   public void run()
   {
      String command = stdin.next();
      while (!command.equalsIgnoreCase("Q"))
      {
         if (command.equalsIgnoreCase("A"))
            customerArrival();
         else if (command.equalsIgnoreCase("C"))
            serviceCompleated();
         else if (command.equalsIgnoreCase("T"))
            advanceTime();
         else if (command.equalsIgnoreCase("P"))
            printStats();
         else
         {
            stdin.nextLine();
            System.out.println(command.charAt(0)
                  + " is not a valid command!");
         }
         command = stdin.next();
      }
      endMessage();
   }

   /**
    This method is called when the new customer command is given and it
    creates a new customer, the adds it to the simulation. If the customer
    wasn't added, it notifies the user what the customers data is and how many
    people are waiting. Otherwise it notifies the user that the customer was
    never added to the queue.
    */
   private void customerArrival()
   {
      Customer newCustomer = new Customer(sim.getTime());
      if (sim.addCustomer(newCustomer))
         System.out.println("A customer entered system at time "
               + sim.getTime() + ". Number waiting in queue is "
               + sim.numWaiting() + ".");
      else
         System.out.println("Customer arrived but left immediately because"
               + " the line was full (too long) at time " + sim.getTime()
               + ".");
   }

   /**
    This method is called when the complete customer command is given and if
    the simulation is serving a customer, it notifies the user that that
    customer has finished, what time they have finished, and the number of
    customers waiting. If the simulation is not serving a customer, it
    notifies the user that no customer was being served at theat specific
    time.
    */
   private void serviceCompleated()
   {
      if (sim.isHelpingCustomer())
      {
         String servedCustomer = sim.curCustomer();
         sim.serveCustomer();
         System.out.println("Customer " + servedCustomer
               + " finished at time " + sim.getTime() + ". Number waiting is "
               + sim.numWaiting() + ".");
      }
      else
         System.out.println("No customer is being served at the present time "
               + "of " + sim.getTime() + ".");
   }

   /**
    This method is called when the advance time command is given and it then
    reads in the next integer, and if its positive, it increments the time and
    outputs the amount updated by and also the current time. If the next
    integer was not positive, it notifies the user that it was not updated by
    that amount.
    */
   private void advanceTime()
   {
      int changeAmmount = stdin.nextInt();
      if (!sim.advanceTime(changeAmmount))
         System.out.println("Time not updated with " + changeAmmount + ".");
      else if (changeAmmount == 1)
         System.out.println("Time updated by " + changeAmmount
               + " time unit and time is now " + sim.getTime() + ".");
      else
         System.out.println("Time updated by " + changeAmmount
               + " time units and time is now " + sim.getTime() + ".");
   }

   /**
    This method is called when the print statistics command is given and it
    prints out the following information: average wait time, total wait time,
    number of people that didn't need to wait, and the total number of people
    served.
    */
   private void printStats()
   {
      System.out.println();
      System.out.println("The average wait time for customers who are"
            + " finished waiting is " + sim.calculateAverageWait() + ".");
      System.out.println("The sum of the total wait time is "
            + sim.totalWaitTime() + ".");
      System.out.println("The number of people that did NOT have to wait is "
            + sim.numWithNoWait() + ".");
      System.out.println("The number of people served is " + sim.numServed()
            + ".");
      System.out.println();
   }

   /**
    This method is called when the quit command is given and it prints out a
    message notifying the user that the quit command was given and it then
    prints out the statistics as the end of the program, followed by a normal
    termination message.
    */
   private void endMessage()
   {
      System.out.println();
      System.out.println("Quit (Q) command given.");
      System.out.println("Statistics at end of the program are:");
      printStats();
      System.out.print("Normal Termination of Program 4!");
   }
}
