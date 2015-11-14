
/**

 @author Nick Sosinski
 @author Jake Ira
 */
public class listOfPFigures
{

   private final int figMax = 10;
   private PFigure[] listOfFigures = new PFigure[figMax];
   private int figCount = 0;

   public void removeAllFigures()
   {
      for (int i = 0; i < figCount; i++)
         listOfFigures[i].hide();
      figCount = 0;
   }

   public void drawAll()
   {
      for (int i = 0; i < figCount; i++)
      {
         listOfFigures[i].hide();
         listOfFigures[i].move();
         listOfFigures[i].draw();
      }
   }

   public void addFigure(PFigure inFigure)
   {
      if (figCount < figMax)
         listOfFigures[figCount++] = inFigure;
   }

}
