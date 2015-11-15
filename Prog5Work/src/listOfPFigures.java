
/**

 @author Nick Sosinski
 @author Jake Ira
 */
import java.awt.*;

public class listOfPFigures
{

   private final int figMax = 50;
   private final PFigure[] listOfFigures = new PFigure[figMax];
   private int figCount = 0;
   private final Panel workingPanel;

   public listOfPFigures(Panel p)
   {
      workingPanel = p;
   }

   public boolean userHitGoal()
   {
      return listOfFigures[0].collidedWith(listOfFigures[1]);
   }

   public boolean userHitDeathObject()
   {
      for (int i = 2; i < figCount; i++)
         if (listOfFigures[1].collidedWith(listOfFigures[i]))
            return true;
      return false;
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
