
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

   public enemyFigure(int xStart, int yStart, int inWidth, int inHeight,
         int enemyStrenght, Panel p)
   {
      super(xStart, yStart, inWidth, inHeight, enemyStrenght, p);
   }

   protected int getRandom(int min, int max)
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
         xVelocity = -1 * xVelocity;
      else if ((x + width) > panel.getWidth())
         xVelocity = -1 * xVelocity;
      if (y < 0)
         yVelocity = -1 * yVelocity;
      else if ((y + height) >= panel.getHeight())
         yVelocity = -1 * yVelocity;
   }
}
