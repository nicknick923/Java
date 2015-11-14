
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;

/**

 @author Nick Sosinski
 @author Jake Ira
 */
public class deathBox extends enemyFigure
{

   private int xVelocity = getRandom(-5, 5);
   private int yVelocity = getRandom(-5, 5);

   public deathBox(Panel p)
   {
      super(0, 0, 80, 80, 1, p);
      x = getRandom(0, p.getWidth());
      y = getRandom(0, p.getHeight());

   }

   private int getRandom(int min, int max)
   {
      double randVal = Math.random();
      randVal *= (max - min);
      randVal += (min - 1);
      return ((int) randVal) + 1;
   }

   @Override
   public void draw()
   {
      Graphics g = panel.getGraphics();
      g.setColor(Color.orange);
      g.drawRect(x, y, width, height);
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

   @Override
   public void move()
   {
      super.move(xVelocity, yVelocity);
      if (x < 0)
         x = panel.getSize().width - width;
      else if ((x + width) > panel.getSize().width)
         x = 0;
      if (y < 0)
         y = panel.getSize().height - height;
      else if ((y + height) > panel.getSize().height)
         y = 0;
   }
}
