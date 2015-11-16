
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

   /**
    This method returns the PFigure the player collided with, or null if no
    there was no collision.

    @return The PFigure the player collided with or null if no there was no
    collision.
    */
   public PFigure userHitObject()
   {
      for (int i = 1; i < figCount; i++)
         if (listOfFigures[i].collidedWith(listOfFigures[0]))
            return listOfFigures[i];
      return null;
   }

   /**
    This method resets the list, sets the figure count to 0, and hides all of
    the previous figures.
    */
   public void resetList()
   {
      hideAll();
      figCount = 0;
      listOfFigures = new PFigure[figMax];
   }

   /**
    This method draws all of the figures in the list of figures in one of two
    ways depending upon the value of the boolean parameter that is passed
    in:<br>It hides them all at once, then goes through each element moving
    and drawing each one<br>OR<br>It goes through all of the elements one at a
    time and hides, moves, and draws them for each element.


    @param alternateDrawMethod Set true do draw the way described first, or
    false for the other.
    */
   public void drawAll(boolean alternateDrawMethod)
   {
      if (alternateDrawMethod)
      {
         if (!Prog5GUI.funnyDraw)
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

   /**
    This method draws a rectangle over the panel that is the background color,
    making it simply visually hide all of the figures on the panel.
    */
   public void hideAll()
   {
      Graphics g = workingPanel.getGraphics();
      Color oldColor = g.getColor();
      g.setColor(workingPanel.getBackground());
      g.fillRect(0, 0, workingPanel.getWidth(), workingPanel.getHeight());
      g.setColor(oldColor);
   }

   /**
    This method prevents the last element in the list of figures from
    flickering by drawing something else after any visually important draw
    command is issued.
    */
   private void avoidFlicker()
   {
      Graphics g = workingPanel.getGraphics();
      g.setColor(workingPanel.getBackground());
      g.fillRect(0, 0, 0, 0);
   }

   /**
    This method adds a PFigure to the list of figures and increments the
    figure count.

    @param inFigure The figure to be added to the list.
    */
   public void addFigure(PFigure inFigure)
   {
      if (figCount < figMax)
         listOfFigures[figCount++] = inFigure;
   }

}
