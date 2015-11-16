
/**

 @author Nick Sosinski
 @author Jake Ira
 */
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;

public class goalFigure extends PFigure
{

   private Image img;
   private static final int goalWidth = 92;
   private static final int goalHeight = 108;
   private static final int pxDistanceFromRightEdge = 5;

   /**
    This constructor creates the goal with the size specified by the constants
    and a calculated location relative to the size of the panel that is passed
    as a parameter, and finally it attempts to open the goal image.

    @param p The panel for which the game is played on.
    */
   public goalFigure(Panel p)
   {
      super(0, 0, goalWidth, goalHeight, 0, p);
      x = panel.getSize().width - width - pxDistanceFromRightEdge;
      y = panel.getSize().height / 2 - height / 2;
      try
      {
         File file = new File("goal.png");
         img = ImageIO.read(file);
      }
      catch (Exception e)
      {
         System.out.println("Crashing: " + e);
      }
   }

   /**
    This method returns a boolean value indicating whether or not the called
    PFigure has collided with more than 1/2 the x or y distance with another
    PFigure, p.

    @param p The PFigure that the method checks against collision.
    @return True if they have collided enough, false if they haven't or if p
    is null.
    */
   @Override
   public boolean collidedWith(PFigure p)
   {
      if (p == null)
         return false;
      return (x + width / 2) >= p.x
            && (p.x + p.width / 2) >= x
            && (y + height / 2) >= p.y
            && (p.y + p.height / 2) >= y;
   }

   /**
    This method will draw the goal at location x,y with the respective width
    and height values stored in this class, if the image was opened.
    */
   @Override
   public void draw()
   {
      if (img != null)
      {
         Graphics g = panel.getGraphics();
         g.drawImage(img, x, y, width, height, null);
      }
   }
}
