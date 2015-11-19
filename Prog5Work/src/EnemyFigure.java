
/**

 @author Nick Sosinski
 @author Jake Ira
 */
import java.awt.Panel;
import java.util.Random;

public abstract class EnemyFigure extends PFigure
{

   //The velocities for each EnemyFigure

   protected int xVelocity;
   protected int yVelocity;

   private final int SAFETY_BOARDER = 100;

   /**
    This is the constructor that creates an enemyFigure and randomizes its
    velocity based on passed in values and randomizes location based on the
    panel size. If randomized location is in the safety boarder, it will be
    regenerated until it is no loner in the safety boarder.

    @param inWidth The width of the enemy figure.
    @param inHeight The height of the enemy figure.
    @param maxVelocity The maximum random velocity the enemy figure should
    have.
    @param p The panel the enemy figure lives on.
    @param player The players PFigure.
    */
   public EnemyFigure(int inWidth, int inHeight, int maxVelocity, Panel p, PFigure player)
   {
      super(0, 0, inWidth, inHeight, 0, p);
      int startingX = getRandom(0, p.getWidth() - inWidth);
      int startingY = getRandom(0, p.getHeight() - inHeight);
      while ((startingX + width + SAFETY_BOARDER >= player.x && startingX - SAFETY_BOARDER - player.width <= player.x)
            && (startingY + height + SAFETY_BOARDER >= player.y && startingY - SAFETY_BOARDER - player.height <= player.y))
      {
         startingX = getRandom(0, p.getWidth() - inWidth);
         startingY = getRandom(0, p.getHeight() - inHeight);
      }
      move(startingX, startingY);
      xVelocity = getRandom(-maxVelocity, maxVelocity);
      yVelocity = getRandom(-maxVelocity, maxVelocity);
   }

   /**
    This method generates a random integer between the passed values of min
    and max excluding the values min and max.

    @param min The minimum excluding value.
    @param max The maximum excluding value.
    @return A randomized integer between min and max exclusive of min and max.
    */
   private static int getRandom(int min, int max)
   {
      Random randGen = new Random();
      double randVal = randGen.nextDouble();
      randVal = randVal * (double) (max - min);
      randVal = randVal + (double) (min - 1);
      return (((int) randVal) + 1);
   }

   /**
    This method moves the enemy figure with the distance moved in the x and y
    direction being the xVelocity and yVelocity respectively. If the enemy
    figure hits a wall, it inverts the velocity that caused it to hit, and if
    necessary moves it back onto the panel.
    */
   @Override
   public void move()
   {
      super.move(xVelocity, yVelocity);
      if (x < 0)
      {
         xVelocity = Math.abs(xVelocity);
         x = 0;
      }
      else if ((x + width) > panel.getWidth())
      {
         xVelocity = -Math.abs(xVelocity);
         x = panel.getWidth() - width;
      }
      if (y < 0)
      {
         yVelocity = Math.abs(yVelocity);
         y = 0;
      }
      else if ((y + height) >= panel.getHeight())
      {
         yVelocity = -Math.abs(yVelocity);
         y = panel.getHeight() - height;
      }
   }
}
