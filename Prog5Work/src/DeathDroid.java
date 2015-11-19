
/**
 This class is an enemy PFigure which is a graphically drawn image with a
 method that allows it to be drawn.

 @author Nick Sosinski
 @author Jake Ira
 */
import java.awt.*;

public class DeathDroid extends EnemyFigure
{

   private static final int FIGURE_WIDTH = 75;
   private static final int FIGURE_HEIGHT = 90;
   private static final int MAX_VELOCITY = 5;

   /**
    This constructor creates a deathDroid with the size and max velocity
    specified by the constants that lives on the panel which is passed as a
    parameter.

    @param p The panel for which the game is played on.
    @param player The players PFigure.
    */
   public DeathDroid(Panel p, PFigure player)
   {
      super(FIGURE_WIDTH, FIGURE_HEIGHT, MAX_VELOCITY, p, player);
   }

   /**
    This method will draw the android figure at location x,y with the
    respective width and height values stored in this class.
    */
   @Override
   public void draw()
   {
      Graphics g = panel.getGraphics();
      g.setColor(Color.green);
      //<editor-fold defaultstate="collapsed" desc="Graphics fill method parameter helper">
      /*
       fillArc parameters:
       x - the x coordinate of the upper-left corner of the arc to be filled.
       y - the y coordinate of the upper-left corner of the arc to be filled.
       width - the width of the arc to be filled.
       height - the height of the arc to be filled.
       startAngle - the beginning angle.
       arcAngle - the angular extent of the arc, relative to the start angle.
      
       fillRoundRect parameters:
       x - the x coordinate of the rectangle to be filled.
       y - the y coordinate of the rectangle to be filled.
       width - the width of the rectangle to be filled.
       height - the height of the rectangle to be filled.
       arcWidth - the horizontal diameter of the arc at the four corners.
       arcHeight - the vertical diameter of the arc at the four corners.
       */
      //</editor-fold>

      //<editor-fold defaultstate="collapsed" desc="Draw the Body">       
      g.fillRoundRect(
            (int) (x + (width * ((double) 95 / 547))),
            (int) (y + (height * ((double) 217 / 646))),
            (int) (width * ((double) 359 / 547)),
            (int) (height * ((double) 303 / 646)),
            (int) ((double) width / 10),
            (int) ((double) height / 10));
      g.fillRect(
            (int) (x + (width * ((double) 95 / 547))),
            (int) (y + (height * ((double) 217 / 646))),
            (int) (width * ((double) 359 / 547)),
            (int) (height * ((double) 303 / 646)) / 2);
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Draw the Left Arm">
      g.fillRoundRect(
            (int) (x),
            (int) (y + (height * ((double) 209 / 646))),
            (int) (width * ((double) 81 / 547)),
            (int) (height * ((double) 247 / 646)),
            (int) (width * ((double) 81 / 547)),
            (int) (width * ((double) 81 / 547)));
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Draw the Right Arm">
      g.fillRoundRect(
            (int) (x + (width * ((double) 467 / 547))),
            (int) (y + (height * ((double) 209 / 646))),
            (int) (width * ((double) 81 / 547)),
            (int) (height * ((double) 247 / 646)),
            (int) (width * ((double) 81 / 547)),
            (int) (width * ((double) 81 / 547)));
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Draw the Left Foot">
      g.fillRoundRect(
            (int) (x + (width * ((double) 167 / 547))),
            (int) (y + (height * ((double) 519 / 646))),
            (int) (width * ((double) 80 / 547)),
            (int) (height * ((double) 127 / 646)),
            (int) ((double) width / 10),
            (int) ((double) height / 10));
      g.fillRect(
            (int) (x + (width * ((double) 167 / 547))),
            (int) (y + (height * ((double) 519 / 646))),
            (int) (width * ((double) 80 / 547)),
            (int) (height * ((double) 127 / 646)) / 2);
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Draw the Right Foot">
      g.fillRoundRect(
            (int) (x + (width * ((double) 300 / 547))),
            (int) (y + (height * ((double) 519 / 646))),
            (int) (width * ((double) 80 / 547)),
            (int) (height * ((double) 127 / 646)),
            (int) ((double) width / 10),
            (int) ((double) height / 10));
      g.fillRect(
            (int) (x + (width * ((double) 300 / 547))),
            (int) (y + (height * ((double) 519 / 646))),
            (int) (width * ((double) 80 / 547)),
            (int) (height * ((double) 127 / 646)) / 2);
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Draw the Head">
      g.fillArc(
            (int) (x + (width * ((double) 92 / 547))),
            (int) (y + (height * ((double) 20 / 646))),
            (int) (width * ((double) 359 / 547)),
            (int) (height * ((double) 359 / 646)),
            0,
            180);
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Draw the Left Antenna">
      Polygon leftAntenna = new Polygon();
      leftAntenna.addPoint(
            (int) (x + (width * ((double) 154 / 547))),
            (int) (y + (height * ((double) 10 / 646))));
      leftAntenna.addPoint(
            (int) (x + (width * ((double) 168 / 547))),
            (int) (y + (height * ((double) 5 / 646))));
      leftAntenna.addPoint(
            (int) (x + (width * ((double) 198 / 547))),
            (int) (y + (height * ((double) 59 / 646))));
      leftAntenna.addPoint(
            (int) (x + (width * ((double) 189 / 547))),
            (int) (y + (height * ((double) 64 / 646))));
      g.fillPolygon(leftAntenna);
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Draw the Right Antenna">

      Polygon rightAntenna = new Polygon();
      rightAntenna.addPoint(
            (int) (x + (width * ((double) 388 / 547))),
            (int) (y + (height * ((double) 10 / 646))));
      rightAntenna.addPoint(
            (int) (x + (width * ((double) 379 / 547))),
            (int) (y + (height * ((double) 5 / 646))));
      rightAntenna.addPoint(
            (int) (x + (width * ((double) 349 / 547))),
            (int) (y + (height * ((double) 59 / 646))));
      rightAntenna.addPoint(
            (int) (x + (width * ((double) 358 / 547))),
            (int) (y + (height * ((double) 64 / 646))));
      g.fillPolygon(rightAntenna);
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Draw the Left Eye">
      g.setColor(Color.white);
      g.fillArc(
            (int) (x + (width * ((double) 176 / 547))),
            (int) (y + (height * ((double) 106 / 646))),
            (int) (width * ((double) 32 / 547)),
            (int) (height * ((double) 32 / 646)),
            0,
            360);
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Draw the Right Eye">
      g.fillArc(
            (int) (x + (width * ((double) 340 / 547))),
            (int) (y + (height * ((double) 106 / 646))),
            (int) (width * ((double) 32 / 547)),
            (int) (height * ((double) 32 / 646)),
            0,
            360);
      //</editor-fold>
   }

}
