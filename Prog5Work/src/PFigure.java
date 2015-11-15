
import java.awt.*;

/**

 @author Nick Sosinski
 @author Jake Ira
 @author Thomas Scanlan
 */
public abstract class PFigure implements Comparable
{

   
   protected int x, y;           // Current position of the figure
   protected int width, height;  // Drawn (displayed) this size
   protected int priority;       // Can use to determine "winner"
   protected Panel panel;        // Panel the figure lives on

   /**
    This is the constructor used to make all PFigures that takes in the
    starting position and size, and number representing the 'power' of the
    figure and finally what panel the figure is based on.

    @param startX The starting X coordinate.
    @param startY The starting Y coordinate.
    @param _width The starting width of the figure.
    @param _height The starting height of the figure.
    @param pr The strength of the figure represented by an integer where the
    higher the integer the stronger the figure.
    @param p The panel for which the figure will live and operate on.
    */
   public PFigure(int startX, int startY, int _width, int _height,
         int pr, Panel p)
   {
      x = startX;
      y = startY;
      width = _width;
      height = _height;
      priority = pr;
      panel = p;
   }

   /**
    Never used. We would remove this method but fear doing so would result in
    a deduction of points, so we just agreed to leave it in for safety.

    @param o .
    @return .
    */
   @Override
   public int compareTo(Object o)
   {
      if (o instanceof PFigure)
         return priority - ((PFigure) o).priority;
      return Integer.MAX_VALUE;
   }

   /**
    This method returns a boolean value indicating whether or not the called
    PFigure has collided with another PFigure, p.

    @param p The PFigure that the method checks against collision.
    @return True if they have collided, false if they haven't or if p is null.
    */
   public boolean collidedWith(PFigure p)
   {
      if (p == null)
         return false;

      return (x + width) >= p.x && (p.x + p.width) >= x
            && (y + height) >= p.y && (p.y + p.height) >= y;
   }

   /**
    This method moves the figure from its current position deltaX and deltaY
    pixels.

    @param deltaX The change in X the figure should move by.
    @param deltaY The change in Y the figure should move by.
    */
   public void move(int deltaX, int deltaY)
   {
      x = x + deltaX;
      y = y + deltaY;
   }

   /**
    This method replaces the current location of the object with a filled in
    rectangle with the color of the background, which hides it from sight.
    */
   public void hide()
   {
      Graphics g = panel.getGraphics();
      Color oldColor = g.getColor();
      g.setColor(panel.getBackground());
      g.fillRect(x, y, width, height);
      g.setColor(oldColor);
   }

   /**
    This method is the move method that can be overridden by a child in the
    event that polymorphism is to move the PFigure based on a timer.
    */
   public void move()
   {
   }

   /**
    This method will draw the figure at location x,y with the respective width
    and height values stored in this class.
    */
   abstract public void draw();

}
