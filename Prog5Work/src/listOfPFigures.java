

import java.awt.*;

/**

 @author Nick Sosinski
 @author Jake Ira
 */
import java.awt.*;

public class listOfPFigures
{

   private final int figMax = 10;
   private PFigure[] listOfFigures = new PFigure[figMax];
   private int figCount = 0;
   private Panel workingPanel;

   public listOfPFigures(Panel p)
   {
      workingPanel = p;
   }

   public void removeAllFigures()
   {
      for (int i = 0; i < figCount; i++)
         listOfFigures[i].hide();
      figCount = 0;

      hideAll();
   }

   public void drawAll()
   {
      hideAll();
      for (int i = 0; i < figCount; i++)
      {
         listOfFigures[i].move();
         listOfFigures[i].draw();
      }
   }

   private void hideAll()
   {
      Graphics g = workingPanel.getGraphics();
      Color oldColor = g.getColor();
      g.setColor(workingPanel.getBackground());
      g.fillRect(0, 0, workingPanel.getWidth(), workingPanel.getHeight());
      g.setColor(oldColor);
   }

   public void addFigure(PFigure inFigure)
   {
      if (figCount < figMax)
         listOfFigures[figCount++] = inFigure;
   }

}
