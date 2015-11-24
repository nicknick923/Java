
/**

 @author Nick Sosinski
 @author Jake Ira
 */
public class Sorts
{

   private int ary[];

   public Sorts()
   {
      resetArray();
   }

   public void run()
   {
      System.out.println("Unsorted:");
      printArray(ary);
      bubbleSort();
      
   }

   private void resetArray()
   {
      ary = new int[]
      {
         12, 6, 856, 43, -34, 8, 754, -643
      };
   }

   private void bubbleSort()
   {
      System.out.println("Bubble Sort:");
      for (int i = 0; i <= ary.length; i++)
         for (int j = ary.length - 1; j >= i + 1; j--)
            if (ary[j] < ary[j - 1])
               swap(ary, j, j - 1);
      printArray(ary);
      resetArray();
   }

   private void printArray(int[] array)
   {
      for (int i = 0; i < array.length; i++)
         System.out.println(array[i]);
   }

   private void swap(int[] array, int index1, int index2)
   {
      int temp = array[index2];
      array[index2] = array[index1];
      array[index1] = temp;
   }
}
