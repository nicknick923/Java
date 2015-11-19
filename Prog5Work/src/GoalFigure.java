
/**
 This class represents the goal in the rounds mode where when the user
 collides with it, the user wins that round.

 @author Nick Sosinski
 @author Jake Ira
 */
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;

public class GoalFigure extends PFigure
{

   private Image img;
   private static final int GOAL_WIDTH = 92;
   private static final int GOAL_HEIGHT = 108;
   private static final int DISTANCE_FROM_RIGHT_EDGE = 5;
   private static final double AMMOUNT_NEEDED_TO_BEAT_LEVEL = .5;

   /**
    This constructor creates the goal with the size specified by the constants
    and a calculated location relative to the size of the panel that is passed
    as a parameter, and finally it attempts to open the goal image.

    @param p The panel for which the game is played on.
    */
   public GoalFigure(Panel p)
   {
      super(0, 0, GOAL_WIDTH, GOAL_HEIGHT, 0, p);
      x = panel.getSize().width - width - DISTANCE_FROM_RIGHT_EDGE;
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
      return (x + width * AMMOUNT_NEEDED_TO_BEAT_LEVEL) >= p.x
            && (p.x + p.width * AMMOUNT_NEEDED_TO_BEAT_LEVEL) >= x
            && (y + height * AMMOUNT_NEEDED_TO_BEAT_LEVEL) >= p.y
            && (p.y + p.height * AMMOUNT_NEEDED_TO_BEAT_LEVEL) >= y;
   }

   @Override
   public void move()
   {
      x = panel.getSize().width - width - DISTANCE_FROM_RIGHT_EDGE;
      y = panel.getSize().height / 2 - height / 2;
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
