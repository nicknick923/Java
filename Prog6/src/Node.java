
/**

 @author Nick Sosinski
 @author Jake Ira
 */
public class Node
{

   public Node next;
   public Object info;

   public Node(Object inInfo, Node inNext)
   {
      info = inInfo;
      next = inNext;
   }

   public Object search(Node list, Object x)
   {
      Node p = list;
      while (p != null && !x.equals(p.info))
         p = p.next;
      if (p == null)
         return p;
      return p.info;
   }

   public Node addToEnd(Node list, Object data)
   {
      if (list == null)
         list = new Node(data, null);
      else
      {
         Node p = list;
         while (p.next != null)
            p = p.next;
         p.next = new Node(data, null);
      }
      return list;
   }

   public Node deleteLastNode(Node list)
   {
      if (list != null)
         if (list.next == null)
            list = null;
         else
         {
            Node p = list;
            while (p.next.next != null)
               p = p.next;
            p.next = null;
         }
      return list;
   }

   public Node deleteFirstOccurrence(Node list, Object data)
   {
      if (list != null)
         if (data.equals(list.info))
            list = list.next;
         else
         {
            Node p = list;
            while (p.next != null && !data.equals(p.next.info))
               p = p.next;
            if (p.next != null)
               p.next = p.next.next;
         }
      return list;
   }
}
