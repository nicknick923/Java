
/**
 This class is a digital stack where elements are added and removed from one
 end only.

 @author Jake Ira
 */
public class Stack
{

   private Object[] elements;
   private int top;

   /**
    Constructor that takes in the wanted size of the stack.

    @param size The number of spots in the stack
    */
   public Stack(int size)
   {
      elements = new Object[size];
      top = 0;
   }

   /**
    This method returns a boolean value of true if the stack is empty or false
    if it is not empty.

    @return A boolean value where true means empty and false means not empty
    */
   public boolean isEmpty()
   {
      return top == 0;
   }

   /**
    This method returns a boolean value of true if the stack is full or false
    if it is not full.

    @return A boolean value where true means full and false means not full
    */
   public boolean isFull()
   {
      return top == elements.length;
   }

   /**
    This method adds an object to the top of the stack. If the stack is full,
    the program will crash.

    @param x The object to be added to the top of the stack
    */
   public void push(Object x)
   {
      elements[top++] = x;
   }

   /*public void push(Object x)
    {
    s = new Node(x, s)
    }
    */
   /**
    This method returns the top object in the stack. If the stack is empty,
    the program will crash.

    @return The object on the top of the stack
    */
   public Object pop()
   {
      return elements[--top];
   }

   /*
    public Object pop()
    {
    Object x = s.info;
    s = s.next;
    return x;
    }

    */
   /**
    This method resets the stack.
    */
   public void clear()
   {
      top = 0;
   }

   /**
    This method tests the Stack class.

    @param args command line arguments
    */
   public static void main(String args[])
   {
      Stack trialStack = new Stack(5);
      String testObject1 = "Object 1";
      String testObject2 = "Object 2";
      String testObject3 = "Object 3";
      String testObject4 = "Object 4";
      String testObject5 = "Object 5";

      if (trialStack.isEmpty())
         System.out.println("isEmpty Method Test---------Pass");
      else
         System.out.println("isEmpty Method Test---------Fail");

      if (trialStack.isFull())
         System.out.println("isFull Method Test----------Fail");
      else
         System.out.println("isFull Method Test----------Pass");

      trialStack.push(testObject1);

      if (trialStack.isEmpty())
         System.out.println("Push Method Test------------Fail");
      else
         System.out.println("Push Method Test------------Pass");

      if (trialStack.isEmpty())
         System.out.println("isEmpty Method Test---------Fail");
      else
         System.out.println("isEmpty Method Test---------Pass");

      if (trialStack.pop().toString().equals("Object 1"))
         System.out.println("Pop Method Test-------------Pass");
      else
         System.out.println("Pop Method Test-------------Fail");

      trialStack.push(testObject1);
      trialStack.push(testObject2);
      trialStack.push(testObject3);
      trialStack.push(testObject4);
      trialStack.push(testObject5);

      if (trialStack.isEmpty())
         System.out.println("isEmpty Method Test---------Fail");
      else
         System.out.println("isEmpty Method Test---------Pass");

      if (trialStack.isFull())
         System.out.println("isFull Method Test----------Pass");
      else
         System.out.println("isFull Method Test----------Fail");

      if (trialStack.pop().toString().equals("Object 5"))
         System.out.println("Pop Method Test-------------Pass");
      else
         System.out.println("Pop Method Test-------------Fail");

      if (trialStack.pop().toString().equals("Object 4"))
         System.out.println("Pop Method Test-------------Pass");
      else
         System.out.println("Pop Method Test-------------Fail");

      if (trialStack.pop().toString().equals("Object 3"))
         System.out.println("Pop Method Test-------------Pass");
      else
         System.out.println("Pop Method Test-------------Fail");

      if (trialStack.pop().toString().equals("Object 2"))
         System.out.println("Pop Method Test-------------Pass");
      else
         System.out.println("Pop Method Test-------------Fail");

      if (trialStack.pop().toString().equals("Object 1"))
         System.out.println("Pop Method Test-------------Pass");
      else
         System.out.println("Pop Method Test-------------Fail");

      if (trialStack.isEmpty())
         System.out.println("isEmpty Method Test---------Pass");
      else
         System.out.println("isEmpty Method Test---------Fail");

      if (trialStack.isFull())
         System.out.println("isFull Method Test----------Fail");
      else
         System.out.println("isFull Method Test----------Pass");

      trialStack.push(testObject1);
      trialStack.push(testObject2);
      trialStack.push(testObject3);
      trialStack.push(testObject4);
      trialStack.push(testObject5);

      if (trialStack.isFull())
         System.out.println("isFull Method Test----------Pass");
      else
         System.out.println("isFull Method Test----------Fail");

      trialStack.clear();

      if (trialStack.isEmpty())
         System.out.println("Clear Method Test-----------Pass");
      else
         System.out.println("Clear Method Test-----------Fail");
   }
}
