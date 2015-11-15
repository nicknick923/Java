
/**
This class stores and manipulates all intermediate values.
 @author Jake Ira
 */
public class Queue
{

   private int front, rear, count;
   private Object elements[];

   /**
    This method creates the queue and sets the front rear and count to 0.

    @param size size of the queue
    */
   public Queue(int size)
   {
      elements = new Object[size];
      front = rear = count = 0;
   }

   /**
    Adds an element to the end of the array.

    @param x element being added to the end of the queue
    */
   public void add(Object x)
   {
      elements[rear] = x;
      rear = rear + 1 % elements.length;
      count++;
   }

   /**
    This method removes and returns the last value in the array.

    @return the last value in the array
    */
   public Object remove()
   {
      Object x = elements[front];
      front = front + 1 % elements.length;
      count--;
      return x;
   }

   /**
    This method checks to see if the queue is empty.

    @return true if the queue is empty and false if the queue is full
    */
   public boolean isEmpty()
   {
      return count == 0;
   }

   /**
    Method checks to see if the queue is full.

    @return true if the queue is full and false if the queue is empty
    */
   public boolean isFull()
   {
      return count == elements.length;
   }

   /**
    This method sets the count front and rear of the array equal to 0.
    */
   public void clear()
   {
      count = front = rear = 0;
   }
   
   public void switcher()
   {
      if (elements[] < 2)
   }
   
}
