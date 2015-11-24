
/**
 This class is a digital queue where elements are added to one end and removed
 from the other.

 @author Jake Ira
 @author Nick Sosinski
 */
public class Queue
{

   private Object[] elements;
   private int front, rear, count;

   /**
    Constructor that takes in the wanted size of the queue.

    @param size The number of spots in the queue
    */
   public Queue(int size)
   {
      elements = new Object[size];
      front = rear = count = 0;
   }

   /**
    This method returns a boolean value of true if the queue is empty or false
    if it is not empty.

    @return A boolean value where true means empty and false means not empty
    */
   public boolean isEmpty()
   {
      return count == 0;
   }

   /**
    This method returns a boolean value of true if the queue is full or false
    if it is not full.

    @return A boolean value where true means full and false means not full
    */
   public boolean isFull()
   {
      return count == elements.length;
   }

   /**
    This method adds an object to the end of the queue. If it is full, it may
    crash the program.

    @param x The object to be added to the queue
    */
   public void add(Object x)
   {
      elements[rear] = x;
      rear = (rear + 1) % elements.length;
      count++;
   }

   /**
    This method removes the next object in the queue. If it is empty, it will
    crash the program.

    @return The next object in the queue
    */
   public Object remove()
   {
      Object x = elements[front];
      front = (front + 1) % elements.length;
      count--;
      return x;
   }

   /**
    This method resets the queue.
    */
   public void clear()
   {
      front = rear = count = 0;
   }

   /**
    This method tests the Queue class.

    @param args command line arguments
    */
   public static void main(String args[])
   {
      Queue trialQueue = new Queue(5);
      String testObject1 = "Object 1";
      String testObject2 = "Object 2";
      String testObject3 = "Object 3";
      String testObject4 = "Object 4";
      String testObject5 = "Object 5";

      if (trialQueue.isEmpty())
         System.out.println("isEmpty Method Test---------Pass");
      else
         System.out.println("isEmpty Method Test---------Fail");

      if (trialQueue.isFull())
         System.out.println("isFull Method Test----------Fail");
      else
         System.out.println("isFull Method Test----------Pass");

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

      if (trialQueue.isFull())
         System.out.println("isFull Method Test----------Pass");
      else
         System.out.println("isFull Method Test----------Fail");

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

      if (trialQueue.isFull())
         System.out.println("isFull Method Test----------Fail");
      else
         System.out.println("isFull Method Test----------Pass");

      trialQueue.add(testObject1);
      trialQueue.add(testObject2);
      trialQueue.add(testObject3);
      trialQueue.add(testObject4);
      trialQueue.add(testObject5);

      if (trialQueue.isFull())
         System.out.println("isFull Method Test----------Pass");
      else
         System.out.println("isFull Method Test----------Fail");

      trialQueue.clear();

      if (trialQueue.isEmpty())
         System.out.println("Clear Method Test-----------Pass");
      else
         System.out.println("Clear Method Test-----------Fail");

   }
}
