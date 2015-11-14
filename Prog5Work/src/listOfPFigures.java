
/**

 @author Nick Sosinski
 @author Jake Ira
 */
public class listOfPFigures
{

   private PFigure[] listOfFigures = new PFigure[50];
   private int figCount = 0;

   public void removeAllFigures()
   {
      figCount = 0;
   }
   
   public void drawAll()
   {
      for(int i = 0; i < figCount; i++)
      {
         listOfFigures[i].hide();
         listOfFigures[i].move();
         listOfFigures[i].draw();
      }
   }
   
   public void addFigure(PFigure inFigure)
   {
      listOfFigures[figCount++] = inFigure;
   }

}
