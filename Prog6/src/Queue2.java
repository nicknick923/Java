
/**
 This class is a digital queue where elements are added to one end and removed
 from the other.

 @author Nick Sosinski
 */
public class Queue2
{

   private Node front, rear;

   /**
    Constructor that creates an empty queue.
    */
   public Queue2()
   {
      front = null;
      rear = null;
   }

   /**
    This method returns a boolean value of true if the queue is empty or false
    if it is not empty.

    @return A boolean value where true means empty and false means not empty.
    */
   public boolean isEmpty()
   {
      return front == null;
   }

   /**
    This method adds an object to the end of the queue.

    @param x The object to be added to the queue.
    */
   public void add(Object x)
   {
      if (front == null)
      {
         front = new Node(x, null);
         rear = front;
      }
      else
      {
         rear.next = new Node(x, null);
         rear = rear.next;
      }
   }

   /**
    This method removes the next object in the queue.

    @return The next object in the queue or null if the queue is empty.
    */
   public Object remove()
   {
      if (front == null)
         return null;
      Object x = front.info;
      front = front.next;
      if (front == null)
         rear = null;
      return x;
   }

   /**
    This method resets the queue.
    */
   public void clear()
   {
      front = rear = null;
   }

   /**
    This method tests the Queue2 class.

    @param args The command line arguments.
    */
   public static void main(String args[])
   {
      Queue2 trialQueue = new Queue2();
      String testObject1 = "Object 1";
      String testObject2 = "Object 2";
      String testObject3 = "Object 3";
      String testObject4 = "Object 4";
      String testObject5 = "Object 5";

      if (trialQueue.isEmpty())
         System.out.println("isEmpty Method Test---------Pass");
      else
         System.out.println("isEmpty Method Test---------Fail");

      trialQueue.add(testObject1);

      if (trialQueue.isEmpty())
         System.out.println("Add Method Test-------------Fail");
      else
         System.out.println("Add Method Test-------------Pass");

      if (trialQueue.isEmpty())
         System.out.println("isEmpty Method Test---------Fail");
      else
         System.out.println("isEmpty Method Test---------Pass");

      if (trialQueue.remove().toString().equals("Object 1"))
         System.out.println("Remove Method Test----------Pass");
      else
         System.out.println("Remove Method Test----------Fail");

      trialQueue.add(testObject1);
      trialQueue.add(testObject2);
      trialQueue.add(testObject3);
      trialQueue.add(testObject4);
      trialQueue.add(testObject5);

      if (trialQueue.isEmpty())
         System.out.println("isEmpty Method Test---------Fail");
      else
         System.out.println("isEmpty Method Test---------Pass");

      if (trialQueue.remove().toString().equals("Object 1"))
         System.out.println("Remove Method Test----------Pass");
      else
         System.out.println("Remove Method Test----------Fail");

      if (trialQueue.remove().toString().equals("Object 2"))
         System.out.println("Remove Method Test----------Pass");
      else
         System.out.println("Remove Method Test----------Fail");

      if (trialQueue.remove().toString().equals("Object 3"))
         System.out.println("Remove Method Test----------Pass");
      else
         System.out.println("Remove Method Test----------Fail");

      if (trialQueue.remove().toString().equals("Object 4"))
         System.out.println("Remove Method Test----------Pass");
      else
         System.out.println("Remove Method Test----------Fail");

      if (trialQueue.remove().toString().equals("Object 5"))
         System.out.println("Remove Method Test----------Pass");
      else
         System.out.println("Remove Method Test----------Fail");

      if (trialQueue.isEmpty())
         System.out.println("isEmpty Method Test---------Pass");
      else
         System.out.println("isEmpty Method Test---------Fail");

      trialQueue.add(testObject1);
      trialQueue.add(testObject2);
      trialQueue.add(testObject3);
      trialQueue.add(testObject4);
      trialQueue.add(testObject5);

      trialQueue.clear();

      if (trialQueue.isEmpty())
         System.out.println("Clear Method Test-----------Pass");
      else
         System.out.println("Clear Method Test-----------Fail");

   }
}
