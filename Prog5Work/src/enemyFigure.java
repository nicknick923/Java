
import java.awt.Panel;

/**

 @author Nick Sosinski
 @author Jake Ira
 */
public abstract class enemyFigure extends PFigure
{

   public enemyFigure(int xStart, int yStart, int width, int height,
         int enemyStrenght, Panel p)
   {
      super(xStart, yStart, width, height, enemyStrenght, p);
   }
}
