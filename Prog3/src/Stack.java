
/**
This class stores all fractions and operations to be called upon later.
 @author Jake Ira
 */
public class Stack
{

   private Object elements[];
   private int top;

   /**
    This method creates the stack and sets the top to 0.

    @param size size of the stack
    */
   public Stack(int size)
   {
      elements = new Object[size];
      top = 0;
   }

   /**
    This method checks to see if the stack is empty.

    @return true if the stack is empty and false if the stack is full
    */
   public boolean isEmpty()
   {
      return top == 0;
   }

   /**
    Method checks to see if the stack is full.

    @return true if the stack is full and false if the stack is empty
    */
   public boolean isFull()
   {
      return top == elements.length;
   }

   /**
    This method adds a new element to the top of the array.

    @param x element being added to the top of the array
    */
   public void push(Object x)
   {
      elements[top++] = x;
   }

   /**
    This element removes the top element in the array.

    @return element on the top of the array
    */
   public Object pop()
   {
      return elements[--top];
   }

   /**
    This method sets the top of the array equal to 0.
    */
   public void clear()
   {
      top = 0;
   }
}
