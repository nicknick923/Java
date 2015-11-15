
/**

 @author Nick Sosinski
 @author Jake Ira
 */
import java.awt.*;

public class listOfPFigures
{

   private final int figMax = 1000;
   private PFigure[] listOfFigures;
   private int figCount;
   private final Panel workingPanel;
   

   /**
    This constructor prepares listOfPFigures for use and gets the panel the
    game will play on.

    @param p The panel the game will be played on.
    */
   public listOfPFigures(Panel p)
   {
      listOfFigures = new PFigure[figMax];
      figCount = 0;
      workingPanel = p;
   }

   public PFigure userHitObject()
   {
      for (int i = 1; i < figCount; i++)
         if (listOfFigures[i].collidedWith(listOfFigures[0]))
            return listOfFigures[i];
      return null;
   }

   public void resetList()
   {
      hideAll();
      figCount = 0;
      listOfFigures = new PFigure[figMax];
   }

   public void drawAll(boolean alternateDrawMethod)
   {

      if (alternateDrawMethod)
      {
         hideAll();
         for (int i = 0; i < figCount; i++)
         {
            listOfFigures[i].move();
            listOfFigures[i].draw();
         }
         avoidFlicker();
      }
      else
         for (int i = 0; i < figCount; i++)
         {
            listOfFigures[i].hide();
            listOfFigures[i].move();
            listOfFigures[i].draw();
         }
   }

   public void hideAll()
   {
      Graphics g = workingPanel.getGraphics();
      Color oldColor = g.getColor();
      g.setColor(workingPanel.getBackground());
      g.fillRect(0, 0, workingPanel.getWidth(), workingPanel.getHeight());
      g.setColor(oldColor);
   }

   private void avoidFlicker()
   {
      Graphics g = workingPanel.getGraphics();
      g.setColor(workingPanel.getBackground());
      g.fillRect(0, 0, 0, 0);
   }

   public void addFigure(PFigure inFigure)
   {
      if (figCount < figMax)
         listOfFigures[figCount++] = inFigure;
   }

}
