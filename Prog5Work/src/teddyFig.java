
import java.awt.*;

public class teddyFig extends PFigure
{

   public teddyFig(Panel p)
   {
      super(200, 100, 80, 80, 1, p);
   }

   @Override
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

   @Override
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

   @Override
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
   }

}
