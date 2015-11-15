
import java.awt.Panel;
import java.util.Random;

/**

 @author Nick Sosinski
 @author Jake Ira
 */
public abstract class enemyFigure extends PFigure
{
 
   
   
   protected int xVelocity;
   protected int yVelocity;

   private final int safeZoneX = 180;
   private final int safeZoneY = 220;

   public enemyFigure(int inWidth, int inHeight,
         int enemyStrenght, Panel p, int maxVel)
   {
      super(0, 0, inWidth, inHeight, enemyStrenght, p);
      int startingX = getRandom(0, p.getWidth() - inWidth);
      int startingY = getRandom(0, p.getHeight() - inHeight);
      while (startingY <= safeZoneY && startingX <= safeZoneX)
         startingX = getRandom(0, p.getWidth() - inWidth);
      while (startingY <= safeZoneY && startingX <= safeZoneX)
         startingY = getRandom(0, p.getHeight() - inHeight);
      move(startingX, startingY);
      xVelocity = randVelocity(maxVel);
      yVelocity = randVelocity(maxVel);
   }

   private int randVelocity(int value)
   {
      return getRandom(-value, value);
   }

   private int getRandom(int min, int max)
   {
      Random randGen = new Random();
      double randVal = randGen.nextDouble();
      randVal = randVal * (double) (max - min);
      randVal = randVal + (double) (min - 1);
      return (((int) randVal) + 1);
   }

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
