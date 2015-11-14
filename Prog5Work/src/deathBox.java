
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.util.Random;

/**

 @author Nick Sosinski
 @author Jake Ira
 */
public class deathBox extends PFigure
{

   private int xVelocity = 10;
   private int yVelocity = 10;

   protected Random randGen = new Random();

   public deathBox(Panel p)
   {
      super(0, 0, 200, 200, 1, p);
      int startingX = getRandom(p.getWidth());
      int startingY = getRandom(p.getHeight());
      move(startingX, startingY);
      xVelocity = getRandom(200) - 100;
      yVelocity = getRandom(200) - 100;
   }

   private int getRandom(int max)
   {
      Random randomGenerator = new Random();
      return randomGenerator.nextInt(max);
      /*
       randGen.setSeed(++seed);
       double randVal = randGen.nextDouble();
       randVal = randVal * (double) (max - min);
       randVal = randVal + (double) (min - 1);
       return (((int) randVal) + 1);
       */

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
         yVelocity = -1*yVelocity;
      else if ((y + height) >= panel.getSize().height)
         yVelocity = -1*yVelocity;
   }

   /*
   
    public deathBox(Panel p)
    {
    super(0, 0, 200, 200, 1, p);
    int startingX = getRandom(0, p.getWidth());
    int startingY = getRandom(0, p.getHeight());
    move(startingX, startingY);
    xVelocity = getRandom(-100, 100);
    yVelocity = getRandom(-100, 100);
    }
    */
   @Override
   public void draw()
   {
      Graphics g = panel.getGraphics();
      g.setColor(Color.orange);
      g.fillRect(x, y, width, height);
   }

}
