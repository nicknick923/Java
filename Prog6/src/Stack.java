
/**
 This class is a digital stack where elements are added and removed from one
 end only with linked list implementation.

 @author Jake Ira
 */
public class Stack
{

   private Node linkedListStack;

   /**
    Constructor that creates an empty stack.
    */
   public Stack()
   {
      linkedListStack = null;
   }

   /**
    This method returns a boolean value of true if the stack is empty or false
    if it is not empty.

    @return A boolean value where true means empty and false means not empty.
    */
   public boolean isEmpty()
   {
      return linkedListStack == null;
   }

   /**
    This method adds an object to the top of the stack.

    @param inObject The object to be added to the linkedListStack of the
    stack.
    */
   public void push(Object inObject)
   {
      linkedListStack = new Node(inObject, linkedListStack);
   }

   /**
    This method returns the top object in the stack or if the stack is empty
    it returns null.

    @return The top object in the stack or null if the stack is empty.
    */
   public Object pop()
   {
      if (isEmpty())
         return null;
      else
      {
         Object x = linkedListStack.info;
         linkedListStack = linkedListStack.next;
         return x;
      }

   }

   /**
    This method resets the stack.
    */
   public void clear()
   {
      linkedListStack = null;
   }

   /**
    This method tests the Stack class.

    @param args The command line arguments.
    */
   public static void main(String args[])
   {
      Stack trialStack = new Stack();
      String testObject1 = "Object 1";
      String testObject2 = "Object 2";
      String testObject3 = "Object 3";
      String testObject4 = "Object 4";
      String testObject5 = "Object 5";

      if (trialStack.isEmpty())
         System.out.println("isEmpty Method Test---------Pass");
      else
         System.out.println("isEmpty Method Test---------Fail");

      trialStack.push(testObject1);

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

      trialStack.push(testObject1);
      trialStack.push(testObject2);
      trialStack.push(testObject3);
      trialStack.push(testObject4);
      trialStack.push(testObject5);

      trialStack.clear();

      if (trialStack.isEmpty())
         System.out.println("Clear Method Test-----------Pass");
      else
         System.out.println("Clear Method Test-----------Fail");
   }

}
