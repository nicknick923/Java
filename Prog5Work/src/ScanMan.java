
/**
 This class controls everything with the users character, with things such as
 moving the figure around the screen, and drawing the character.

 @author Nick Sosinski
 @author Jake Ira
 */
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;

public class ScanMan extends PFigure
{

   private static final Point userInputData = new Point(0, 0);
   private static final int playerStartX = 50;
   private static final int playerStartY = 50;
   private static final int playerImageWidth = 80;
   private static final int playerImageHeight = 150;
   private final int playerMoveSpeed = 10;
   private Image img;

   /**
    This constructor creates a scanMan PFigure with the starting location and
    size specified by the constants that lives on the panel which is passed as
    a parameter.

    @param p The panel for which the game is played on.
    */
   public ScanMan(Panel p)
   {
      super(playerStartX, playerStartY, playerImageWidth, playerImageHeight,
            0, p);
      try
      {
         File file = new File("scanMan.jpg");
         img = ImageIO.read(file);
      }
      catch (Exception e)
      {
         System.err.println("Error: " + e);
      }
   }

   /**
    This method receives data on what keys are pressed and stores player
    directional information to a point. <br>Up arrow = (0, -1)<br>Down arrow =
    (0, 1)<br>Left arrow = (-1, 0)<br>Right arrow = (1, 0)

    @param evt The information about what key was pressed.
    */
   public static void keyDownReciver(java.awt.event.KeyEvent evt)
   {
      if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN)
         userInputData.y = 1;
      else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_UP)
         userInputData.y = -1;
      else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_LEFT)
         userInputData.x = -1;
      else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_RIGHT)
         userInputData.x = 1;
   }

   /**
    This method receives data on what keys are pressed and stores player
    directional information to a point, just like keyDownReciver, however when
    a key is let up, it assigns the corresponding axis to 0.

    @param evt The information about what key was released.
    */
   public static void keyUpReciver(java.awt.event.KeyEvent evt)
   {
      if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN)
         userInputData.y = 0;
      else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_UP)
         userInputData.y = 0;
      else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_LEFT)
         userInputData.x = 0;
      else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_RIGHT)
         userInputData.x = 0;
   }

   /**
    This method will draw ScanMan at location x,y with the respective width
    and height values stored in this class, if the image was opened.
    */
   @Override
   public void draw()
   {
      if (img != null)
      {
         Graphics g = panel.getGraphics();
         g.drawImage(img, x, y, width, height, null);
      }
   }

   /**
    This method moves the player figure at in the x and y direction depending
    upon what the value of x and y are in userInputData. If the player figure
    hits a wall, it refuses to let the player go further in the direction of
    the wall it hit, and if necessary moves it back onto the panel.
    */
   @Override
   public void move()
   {
      super.move(playerMoveSpeed * userInputData.x, playerMoveSpeed * userInputData.y);
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
