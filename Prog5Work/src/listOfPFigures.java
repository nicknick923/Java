
import java.awt.Color;
import java.awt.Graphics;


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

   public void removeAllFigures(Panel p)
   {
      for (int i = 0; i < figCount; i++)
         listOfFigures[i].hide();
      figCount = 0;
       
      Graphics g = p.getGraphics();
      Color oldColor = g.getColor();
      g.setColor(p.getBackground());
      g.fillRect(0, 0, p.getWidth(), p.getHeight());
      g.setColor(oldColor);
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
