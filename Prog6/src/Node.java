
/**
 This class creates each node in the linked list.

 @author Nick Sosinski
 @author Jake Ira
 */
public class Node
{

   public Node next;
   public Object info;

   /**
    This method creates the nodes for the linked list.

    @param inInfo inputs the information for the node.
    @param inNext inputs a reference to where the next node is.
    */
   public Node(Object inInfo, Node inNext)
   {
      info = inInfo;
      next = inNext;
   }
}
