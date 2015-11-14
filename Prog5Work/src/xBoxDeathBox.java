
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Polygon;

/**

 @author Nick Sosinski
 @author Jake Ira
 */
public class xBoxDeathBox extends enemyFigure
{

   private static final int boxWidth = 300;
   private static final int boxHeight = 354;

   public xBoxDeathBox(Panel p)
   {
      super(0, 0, boxWidth, boxHeight, 1, p);
      int startingX = super.getRandom(0, p.getWidth() - boxWidth);
      int startingY = super.getRandom(0, p.getHeight() - boxHeight);
      //move(startingX, startingY);
      xVelocity = super.getRandom(-10, 10);
      yVelocity = super.getRandom(-10, 10);
      xVelocity = 0;
      yVelocity = 0;
   }

   @Override
   public void draw()
   {
      Graphics g = panel.getGraphics();
      g.setColor(Color.red);
      g.drawRect(x, y, width, height);
      g.setColor(Color.green);
      //Draw the Body
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

      //Draw the Left Arm
      g.fillRoundRect(
            (int) (x),
            (int) (y + (height * ((double) 209 / 646))),
            (int) (width * ((double) 81 / 547)),
            (int) (height * ((double) 247 / 646)),
            (int) (width * ((double) 81 / 547)),
            (int) (width * ((double) 81 / 547)));

      //Draw the Right Arm
      g.fillRoundRect(
            (int) (x + (width * ((double) 467 / 547))),
            (int) (y + (height * ((double) 209 / 646))),
            (int) (width * ((double) 81 / 547)),
            (int) (height * ((double) 247 / 646)),
            (int) (width * ((double) 81 / 547)),
            (int) (width * ((double) 81 / 547)));

      //Draw the Left Foot
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

      //Draw the Right Foot
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

      //Draw the Head
      g.fillArc(
            (int) (x + (width * ((double) 92 / 547))),
            (int) (y + (height * ((double) 20 / 646))),
            (int) (width * ((double) 359 / 547)),
            (int) (height * ((double) 359 / 646)),
            0,
            180);

      //Draw the Left Antenna
      Polygon leftAntenna = new Polygon();
      leftAntenna.addPoint(
            (int) (width * ((double) 154 / 547)),
            (int) (height * ((double) 10 / 646)));
      leftAntenna.addPoint(
            (int) (width * ((double) 168 / 547)),
            (int) (height * ((double) 5 / 646)));
      leftAntenna.addPoint(
            (int) (width * ((double) 198 / 547)),
            (int) (height * ((double) 59 / 646)));
      leftAntenna.addPoint(
            (int) (width * ((double) 189 / 547)),
            (int) (height * ((double) 64 / 646)));
      g.fillPolygon(leftAntenna);

      //Draw the Right Antenna
      Polygon rightAntenna = new Polygon();
      rightAntenna.addPoint(
            (int) (width * ((double) 388 / 547)),
            (int) (height * ((double) 10 / 646)));
      rightAntenna.addPoint(
            (int) (width * ((double) 379 / 547)),
            (int) (height * ((double) 5 / 646)));
      rightAntenna.addPoint(
            (int) (width * ((double) 349 / 547)),
            (int) (height * ((double) 59 / 646)));
      rightAntenna.addPoint(
            (int) (width * ((double) 358 / 547)),
            (int) (height * ((double) 64 / 646)));
      g.fillPolygon(rightAntenna);

      //Draw the Left Eye
      g.setColor(Color.white);
      g.fillArc(
            (int) (x + (width * ((double) 176 / 547))),
            (int) (y + (height * ((double) 106 / 646))),
            (int) (width * ((double) 32 / 547)),
            (int) (height * ((double) 32 / 646)),
            0,
            360);

      //Draw the Right Eye
      g.fillArc(
            (int) (x + (width * ((double) 340 / 547))),
            (int) (y + (height * ((double) 106 / 646))),
            (int) (width * ((double) 32 / 547)),
            (int) (height * ((double) 32 / 646)),
            0,
            360);
   }

}
