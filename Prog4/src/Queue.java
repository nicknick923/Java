
/**
 This class is a generic digital queue where elements are added to one end and
 removed from the other.

 @author Nick Sosinski
 @author Jake Ira
 */
public class Queue<E>
{

   private E[] elements;
   private int front, rear, count;

   /**
    Constructor that takes in the wanted size of the queue.

    @param size The number of spots in the queue.
    */
   public Queue(int size)
   {
      elements = (E[]) new Object[size];
      front = rear = count = 0;
   }

   /**
    This method returns a boolean value of true if the queue is empty or false
    if it is not empty.

    @return A boolean value where true means empty and false means not empty.
    */
   public boolean isEmpty()
   {
      return count == 0;
   }

   /**
    This method returns a boolean value of true if the queue is full or false
    if it is not full.

    @return A boolean value where true means full and false means not full.
    */
   public boolean isFull()
   {
      return count == elements.length;
   }

   /**
    This method adds an object of type E to the end of the queue. If it is
    full, it may crash the program.

    @param x The object of type E to be added to the queue.
    */
   public void add(E x)
   {
      elements[rear] = x;
      rear = (rear + 1) % elements.length;
      count++;
   }

   /**
    This method removes the next object of type E in the queue. If it is
    empty, it will crash the program.

    @return The next object of type in the queue.
    */
   public E remove()
   {
      E x = elements[front];
      front = (front + 1) % elements.length;
      count--;
      return x;
   }
}
