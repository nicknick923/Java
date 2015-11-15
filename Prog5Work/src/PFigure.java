// You need to properly comment and fully understand this file!

// You are only allowed to change things if it is NECESSARY to do your project,
// in which case you must comment what you changed and why.
// Expect to lose significant points otherwise!
// You don't have to finish any code in this file - just comment it well!
// Be sure to remove and/or rewrite my comments!
import java.awt.*;

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

   // Can use this in "battles", which figures is "greater"
   public int compareTo(Object o)
   {
      if (o instanceof PFigure)
         return priority - ((PFigure) o).priority;
      return Integer.MAX_VALUE;
   }

   // Has "this" figure collided with p?
   public boolean collidedWith(PFigure p)
   {
      if (p == null)
         return false;

      return (x + width) >= p.x && (p.x + p.width) >= x
            && (y + height) >= p.y && (p.y + p.height) >= y;
   }

   // Can be used for moving by keyboard or mouse
   public void move(int deltaX, int deltaY)
   {
      x = x + deltaX;
      y = y + deltaY;
   }

   public void hide()
   {
      Graphics g = panel.getGraphics();
      Color oldColor = g.getColor();
      g.setColor(panel.getBackground());
      g.fillRect(x, y, width, height);
      g.setColor(oldColor);
   }

   // Can be automatic move, for example, called based on timer
   public void move()
   {
   }

   /**
    This method will draw the figure at location x,y with the respective width
    and height values stored in this class.
    */
   abstract public void draw();

}
