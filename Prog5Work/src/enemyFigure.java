
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;

/**

 @author Nick Sosinski
 @author Jake Ira
 */
public abstract class enemyFigure extends PFigure
{

   protected int xVelocity;
   protected int yVelocity;

   public enemyFigure(int xStart, int yStart, int width, int height,
         int enemyStrenght, Panel p)
   {
      super(xStart, yStart, width, height, enemyStrenght, p);
      x = getRandom(0, p.getWidth());
      y = getRandom(0, p.getHeight());
   }

   protected int getRandom(int min, int max)
   {
      double randVal = Math.random();
      randVal *= (max - min);
      randVal += (min - 1);
      return ((int) randVal) + 1;
   }

   @Override
   public void move()
   {
      super.move(xVelocity, yVelocity);
      if (x < 0)
         xVelocity = -xVelocity;
      else if ((x + width) > panel.getSize().width)
         xVelocity = -xVelocity;
      if (y < 0)
         yVelocity = -yVelocity;
      else if ((y + height) > panel.getSize().height)
         yVelocity = -yVelocity;
   }
   
    @Override
   public void hide()
   {
      Graphics g = panel.getGraphics();
      Color oldColor = g.getColor();
      g.setColor(panel.getBackground());
      g.fillRect(x, y, width, height);
      g.setColor(oldColor);
   }
}
