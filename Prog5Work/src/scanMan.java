
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;

public class scanMan extends PFigure
{

   private Image img;

   public scanMan(Panel p)
   {
      super(50, 50, 80, 150, 1, p);
      try
      {
         File file = new File("scanMan.jpg");
         img = ImageIO.read(file);
      }
      catch (Exception e)
      {
         System.out.println("Crashing: " + e);
      }
   }

   @Override
   public void draw()
   {

      if (img != null)
      {
         Graphics g = panel.getGraphics();
         g.drawImage(img, x, y, width, height, null);
      }
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
      Point userData = Prog5GUI.getUserInputData();
      super.move(10 * userData.x, 10 * userData.y);
      if (x < 0)
         x = 0;
      else if ((x + width) > panel.getWidth())
         x = panel.getWidth() - width;
      if (y < 0)
         y = 0;
      else if ((y + height) > panel.getHeight())
         y = panel.getHeight() - height;
   }
}
