
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;

/**

 @author Nick Sosinski
 @author Jake Ira
 */
public class deathBox extends enemyFigure
{

   public deathBox(Panel p)
   {
      super(0, 0, 200, 200, 1, p);
      int startingX = getRandom(0, p.getWidth());
      int startingY = getRandom(0, p.getHeight());
<<<<<<< HEAD
      xVelocity = getRandom(-10, 10);
      yVelocity = getRandom(-10, 10);
      move(startingX, startingY);
=======
      move(startingX, startingY);
      xVelocity = getRandom(-100, 100);
      yVelocity = getRandom(-100, 100);
>>>>>>> f285597eaeacce3f8096a970a8690613d6ccfc2a
   }

   @Override
   public void draw()
   {
      Graphics g = panel.getGraphics();
      g.setColor(Color.orange);
      g.fillRect(x, x, width, height);
   }

}
