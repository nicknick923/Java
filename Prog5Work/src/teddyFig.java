
import java.awt.*;

public class teddyFig extends PFigure
{

   public teddyFig(Panel p)
   {
      super(200, 100, 80, 80, 1, p);
   }

   public void move(int deltaX, int deltaY)
   {
      super.move(deltaX, deltaY);
      if (x < -width)
         x = panel.getSize().width - width;
      else if ((x + width) > panel.getSize().width)
         x = -width;
      if (y < -height / 2)
         y = panel.getSize().height - height / 2;
      else if ((y + height / 2) > panel.getSize().height)
         y = -height / 2;
   }

   public void move()
   {
      super.move(-5, -5);
      if (x < 0)
         x = panel.getSize().width - width;
      else if ((x + width) > panel.getSize().width)
         x = 0;
      if (y < 0)
         y = panel.getSize().height - height;
      else if ((y + height) > panel.getSize().height)
         y = 0;
   }

   public void draw()
   {
      Graphics g = panel.getGraphics();
      g.setColor(Color.red);
      g.drawRect(x, y, width, height);
      g.setColor(Color.blue);
      g.drawOval(x, y, width / 2, height / 2);
      g.setColor(Color.green);
      g.drawOval(x + width / 2, y, width / 2, height / 2);
      g.setColor(Color.magenta);
      g.drawOval(x, y + height / 2, width / 2, height / 2);
      g.setColor(Color.cyan);
      g.drawOval(x + width / 2, y + height / 2, width / 2, height / 2);
      /*
       g.drawOval(x + (width / 4) , y + (1), width / 2, height / 2);
       g.setColor(Color.red);
       g.drawLine( x + width / 2, y + height / 2 + 1, x + width / 2, y + 3 * height / 4 );
       g.setColor(Color.green);
       g.drawLine( x + width / 4, y + 5 * height / 8 + 1, x + 3 * width / 4, y + 5 * height / 8 + 1);
       g.setColor(Color.blue);
       g.drawLine( x + width / 2, y + 3 * height / 4, x + width / 4, y + 7 * height / 8 );
       g.drawLine( x + width / 2, y + 3 * height / 4, x + 3 * width / 4, y + 7 * height / 8 );
       */

   }

}
