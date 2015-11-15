
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.io.File;
import javax.imageio.ImageIO;

/**

 @author Nick Sosinski
 @author Jake Ira
 */
public class deathApple extends enemyFigure
{

   
   private Image img;
   private static final int boxLength = 75;

   public deathApple(Panel p)
   {
      super(boxLength, boxLength, 1, p, 5);
      try
      {
         File file = new File("apple logo.png");
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

}
