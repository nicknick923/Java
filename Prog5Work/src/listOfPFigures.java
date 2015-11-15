
/**

 @author Nick Sosinski
 @author Jake Ira
 */
import java.awt.*;

public class listOfPFigures
{

   private final int figMax = 1000;
   private final PFigure[] listOfFigures = new PFigure[figMax];
   private int figCount = 0;
   private final Panel workingPanel;

   public listOfPFigures(Panel p)
   {
      
      workingPanel = p;
   }

   public PFigure userHitObject()
   {
      for (int i = 0; i < figCount; i++)
         if (listOfFigures[i].collidedWith(listOfFigures[1]) && i != 1)
            return listOfFigures[i];
      return null;
   }

   public void resetList()
   {
      for (int i = 0; i < figCount; i++)
         listOfFigures[i].hide();
      figCount = 0;
   }

   public void drawAll()
   {
      hideAll();
      for (int i = 0; i < figCount; i++)
      {
         listOfFigures[i].move();
         listOfFigures[i].draw();
      }
      avoidFlicker();
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
