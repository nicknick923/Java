
import java.awt.Panel;
import java.util.Random;

/**

 @author Nick Sosinski
 @author Jake Ira
 */
public abstract class enemyFigure extends PFigure
{

   //The velocities for each enemyFigure
   protected int xVelocity;
   protected int yVelocity;
   //The safeZone is a zone where enemyFigures are not allowed to spawn
   private final int safeZoneX = 180;
   private final int safeZoneY = 220;

   /**
    This is the constructor that creates an enemyFigure and randomizes its
    velocity based on passed in values and randomizes location based on the
    panel size. If randomized location is in the safe zone, it will be
    regenerated until it is no loner in the safe zone.

    @param inWidth The width of the enemy figure.
    @param inHeight The height of the enemy figure.
    @param maxVelocity The maximum random velocity the enemy figure should
    have.
    @param p The panel the enemy figure lives on.
    */
   public enemyFigure(int inWidth, int inHeight, int maxVelocity, Panel p)
   {
      super(0, 0, inWidth, inHeight, 0, p);
      int startingX = getRandom(0, p.getWidth() - inWidth);
      int startingY = getRandom(0, p.getHeight() - inHeight);
      while (startingY <= safeZoneY && startingX <= safeZoneX)
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
    and max including the values min and max.

    @param min The minimum inclusive value.
    @param max The maximum inclusive value.
    @return A randomized integer between min and max inclusive of min and max.
    */
   private int getRandom(int min, int max)
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
         yVelocity = Math.abs(xVelocity);
         y = 0;
      }
      else if ((y + height) >= panel.getHeight())
      {
         yVelocity = -Math.abs(xVelocity);
         y = panel.getHeight() - height;
      }
   }
}
