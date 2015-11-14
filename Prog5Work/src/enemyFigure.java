
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

   protected Random randGen = new Random();

   public enemyFigure(int xStart, int yStart, int inWidth, int inHeight,
         int enemyStrenght, Panel p)
   {
      super(xStart, yStart, inWidth, inHeight, enemyStrenght, p);
   }

   @Override
   public void move()
   {
      super.move(xVelocity, yVelocity);
      if (x < 0)
         xVelocity = -1*xVelocity;
      else if ((x + width) > panel.getSize().width)
         xVelocity = -1*xVelocity;
      if (y < 0)
         yVelocity = (-1*yVelocity);
      else if ((y + height) >= panel.getSize().height)
         yVelocity = (-1*yVelocity);
   }
}
