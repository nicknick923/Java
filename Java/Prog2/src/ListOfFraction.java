
/**
 ListOfFractions is an array of Fractions in which you can perform mathematical
operations as well as add subtract and delete Fractions.

 @author Jake Ira
 */
public class ListOfFraction
{

   private final int GROW_BY = 2;
   private Fraction[] fractionAry = new Fraction[GROW_BY];
   private int numFractions = 0;

   /**
    This method creates a new array GROW_BY larger than the previous list,
    then copies the data from the previous array to the new array
    */
   private void grow()
   {
      Fraction newList[] = new Fraction[fractionAry.length + GROW_BY];
      for (int i = 0; i < numFractions; i++)
         newList[i] = fractionAry[i];
      fractionAry = newList;
   }

   /**
    This method checks if the array is full, if full it then calls the grow
    function to increase the size of the array then adds a new fraction.

    @param newFraction new fraction added to the array
    */
   public void add(Fraction newFraction)
   {
      if (numFractions == fractionAry.length)
         grow();
      fractionAry[ numFractions++] = newFraction;
   }

   /**
    This method checks each fraction in the array to find inFraction.

    @param inFraction fraction that is being looked for.
    @return fraction being searched for
    */
   private int find(Fraction inFraction)
   {
      for (int i = 0; i < numFractions; i++)
         if (fractionAry[i].equals(inFraction))
            return i;
      return -1;
   }

   /**
    This method calls the find function to see if the fraction is in the list,
    if found this method will delete it. If the fraction is not found it will
    return -1.

    @param inFraction fraction being deleted
    @return true if the fraction was delete or false if it was not found
    */
   public boolean delete(Fraction inFraction)
   {
      int index = find(inFraction);
      if (index == -1)
         return false;
      else
      {
         numFractions--;
         for (int i = index; i < numFractions; i++)
            fractionAry[i] = fractionAry[i + 1];
      }
      return true;
   }

   /**
    Prints out the inputed fractions in the list with numPerLine fractions in
    a line.

    @param numPerLine how many fractions are printed on each line
    */
   public void print(int numPerLine)
   {
      int numOutputted = 0;
      if (numPerLine < 1)
         numPerLine = 1;
      while (numOutputted < numFractions)
      {
         String tempString = "";
         for (int i = 0; i < numPerLine && numOutputted < numFractions; i++)
            tempString += fractionAry[numOutputted++] + " ";
         System.out.println(tempString);
      }
      if (numFractions == 0)
         System.out.println();

   }

   /**
    This method adds up all Fractions in the list.

    @return the sum of all fractions in the list
    */
   public Fraction sum()
   {
      Fraction newFraction = new Fraction();
      for (int i = 0; i < numFractions; i++)
         newFraction = newFraction.add(fractionAry[i]);
      return newFraction;
   }

   /**
    This function calculates the product of all Fractions in the list.

    @return the product of all fractions in the list
    */
   public Fraction product()
   {
      Fraction newFraction = new Fraction(1, 1);
      for (int i = 0; i < numFractions; i++)
         newFraction = newFraction.multiply(fractionAry[i]);
      return newFraction;
   }
}
