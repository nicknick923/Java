
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;

/**

 @author Nick Sosinski
 @author Jake Ira
 */
public class goalFigure extends PFigure
{

   private Image img;

   public goalFigure(Panel p)
   {
      super(0, 0, 92, 108, 0, p);
      try
      {
         File file = new File("goal.png");
         img = ImageIO.read(file);
      }
      catch (Exception e)
      {
         System.out.println("Crashing: " + e);
      }
   }

   @Override
   public boolean collidedWith(PFigure p)
   {
      if (p == null)
         return false;
      return (x + width / 2) >= p.x && (p.x + p.width / 2) >= x && (y + height / 2) >= p.y && (p.y + p.height / 2) >= y;
   }

   @Override
   public void move()
   {
      x = panel.getSize().width - width - 5;
      y = panel.getSize().height / 2 - height / 2;
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
}
