
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.util.Random;

/**

 @author Nick Sosinski
 @author Jake Ira
 */
public class deathBox extends enemyFigure
{

   private static final int boxLength = 100;
   
   public deathBox(Panel p)
   {
      super(0, 0, boxLength, boxLength, 1, p);
      int startingX = super.getRandom(0, p.getWidth()-boxLength);
      int startingY = super.getRandom(0, p.getHeight()-boxLength);
      move(startingX, startingY);
      xVelocity = super.getRandom(-10,10);
      yVelocity = super.getRandom(-10,10);
   }

   @Override
   public void draw()
   {
      Graphics g = panel.getGraphics();
      g.setColor(Color.orange);
      g.fillRect(x, y, width, height);
   }

}
