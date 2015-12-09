
import com.sun.prism.shader.AlphaTextureDifference_ImagePattern_Loader;

/**

 @author Nick Sosinski
 @author Jake Ira
 */
public class testTest
{

   public static void main(String args[])
   {
      Node list;
      Node p;

      list = new Node(1, new Node(2, new Node(3, new Node(4, null))));
      if (list != null && list.next != null)
         if (list.next.next == null)
         {
            Node tempNode = list.next;
            list.next = list;
            list = tempNode;
         }
         else
         {
            p = list;
            while (p.next.next != null)
               p = p.next;
            Node tempNode = list.next;
            list.next = list;
            list = tempNode;

         }
      System.out.println("hi");
   }
}
