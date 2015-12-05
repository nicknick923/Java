
/**
 This class represents an element in a linked list.

 @author Nick Sosinski
 @author Jake Ira
 */
public class Node
{

   public Node next;
   public Object info;

   /**
    This constructor creates a node with data inInfo and next Node inNext.

    @param inInfo The information for the node.
    @param inNext A reference to where the next node is.
    */
   public Node(Object inInfo, Node inNext)
   {
      info = inInfo;
      next = inNext;
   }
}
