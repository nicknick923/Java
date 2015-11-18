
/**

 @author Nick Sosinski
 @author Jake Ira
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Game implements java.awt.event.ActionListener
{

   private int deaths = 0;
   private int deathsThisLevel = 0;
   private int level = 1;  //start user at level 1
   private int timeSpentOnLevel = 0;
   private int timePlayed = 0;
   private final int gameSpeed = 100;
   private final int milisecondsInASecond = 1000;
   private final int levelOffset = 5;
   private final int enemiesPerLevel = 2;
   private final boolean alternateDrawMethod = true;
   private final PFigureList figureList;
   private final String levelWinSoundFile = "tada.wav";
   private final String playerDeathSoundFile = "Windows Critical Stop.wav";
   private final String pauseSoundFile = "Speech Sleep.wav";
   private final String unpauseSoundFile = "Speech On.wav";
   private final highScoreDataManagement highScoreManager = new highScoreDataManagement();
   private final String gameMode;
   private static String user = "default";

   private final javax.swing.Timer moveTimer;
   private final Panel gamePanel;
   private final TextField deathCountField;
   private final TextField timeField;

   public Game(Prog5GUI gui, Panel p, java.awt.TextField inTimeField, java.awt.TextField deathField, String inGameMode)
   {
      gameMode = inGameMode;
      moveTimer = new javax.swing.Timer(gameSpeed, gui);
      moveTimer.addActionListener(new java.awt.event.ActionListener()
      {
         /**
          This method is called every time a timer ticks and will call the
          game managers timer ticked method to let the game know the timer has
          ticked.

          @param ae The events data (not used).
          */
         @Override
         public void actionPerformed(ActionEvent ae)
         {
            timerTicked();
         }
      });
      gamePanel = p;
      deathCountField = deathField;
      timeField = inTimeField;
      figureList = new PFigureList(p);
      moveTimer.start();
      setLevel();
      updateDeathInfo();
   }
   
   public void actionPerformed(ActionEvent ae)
   {
   }

   private void pause()
   {
      moveTimer.stop();
      playSound(pauseSoundFile);
   }

   private void unpause()
   {
      moveTimer.start();
      playSound(unpauseSoundFile);
   }

   public void keyDownHandler(java.awt.event.KeyEvent evt)
   {
      if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ESCAPE || evt.getKeyCode() == java.awt.event.KeyEvent.VK_SPACE)
         if (moveTimer.isRunning())
            pause();
         else
            unpause();
      else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_F9)
         userWonLevel();
      else
         scanMan.keyDownReciver(evt);
   }

   public static void setScoreName(String name)
   {
      user = name;
   }

   /**
    This method increments the level, resets the timeSpentOnLevel counter, and
    calls to set up the next level.
    */
   public void userWonLevel()
   {
      highScoreManager.writeScore(user, gameMode, level, deathsThisLevel, timeSpentOnLevel);
      level++;
      timeSpentOnLevel = 0;
      deathsThisLevel = 0;
      updateDeathInfo();
      setLevel();
   }

   /**
    This method sets the death information text.
    */
   private void updateDeathInfo()
   {
      if (deaths == 1)
         deathCountField.setText("Level " + level + ", 1 Death");
      else
         deathCountField.setText("Level " + level + ", " + deaths + " Deaths");
   }

   private void updateTimeInfo()
   {
      timeField.setText("Total:" + (timePlayed / milisecondsInASecond)
            + "/This Level:" + (timeSpentOnLevel / milisecondsInASecond));
   }

   /**
    This method calculates the number of enemies the current level should
    have.

    @return The number of enemies the current level should have.
    */
   private int numberOfEnimies()
   {
      /*
       Examples if levelOffset = 5 and enemiesPerLevel = 2:
       level 1: ((1+5)*2)-2 = (6*2)-2 = 12-2 = 10
       level 2: ((2+5)*2)-2 = (7*2)-2 = 14-2 = 12
       level 3: ((3+5)*2)-2 = (8*2)-2 = 16-2 = 14
       */
      return ((level + levelOffset) * enemiesPerLevel) - 2;
   }

   /**
    This method prepares the panel for playing based on what the level is. It
    does this by reseting the figure list, adding the player figure, the goal
    figure, then randomly creates the correct number of enemies, which are
    randomly either deathDroid's or deathApple's.
    */
   public void setLevel()
   {
      figureList.resetList();
      if (gameMode.equals("rounds"))
      {
         figureList.addFigure(new scanMan(gamePanel));
         figureList.addFigure(new goalFigure(gamePanel));
         for (int i = 0; i < numberOfEnimies(); i++)
            if (Math.random() > .5)
               figureList.addFigure(new deathDroid(gamePanel));
            else
               figureList.addFigure(new deathApple(gamePanel));
      }
      else
      {
         level = 5;
         figureList.addFigure(new scanMan(gamePanel));
         for (int i = 0; i < numberOfEnimies(); i++)
            if (Math.random() > .5)
               figureList.addFigure(new deathDroid(gamePanel));
            else
               figureList.addFigure(new deathApple(gamePanel));
      }

   }

   /**
    This method tries to play the sound file that is passed in, and if it
    cant, it outputs the error to the error output.

    @param filePath The sound files path.
    */
   private static void playSound(String filePath)
   {
      try
      {
         java.io.File soundFile = new java.io.File(filePath);
         javax.sound.sampled.AudioInputStream audioIn = javax.sound.sampled.AudioSystem.getAudioInputStream(soundFile);
         javax.sound.sampled.Clip clip = javax.sound.sampled.AudioSystem.getClip();
         clip.open(audioIn);
         clip.start();
      }
      catch (IOException e)
      {
         System.err.println("Minor problem: File could not be played:");
         System.err.println(e.toString() + "\n");
      }
      catch (Exception e)
      {
         System.err.println("Other problem:\n" + e.toString());
      }
   }

   /**
    This method is called every time the timer ticks and it increments both
    the time on the level and total time played by the timer interval, updates
    the time info, draws all of the figures, and checks for user collisions.
    */
   public void timerTicked()
   {
      timePlayed += gameSpeed;
      timeSpentOnLevel += gameSpeed;
      updateTimeInfo();
      figureList.drawAll(alternateDrawMethod);
      userCollideCheck();
      if (timeSpentOnLevel % 5000 == 0 && !gameMode.equals("rounds"))
         if (Math.random() > .5)
            figureList.addFigure(new deathDroid(gamePanel));
         else
            figureList.addFigure(new deathApple(gamePanel));
   }

   /**
    This method checks to see if the user hit any PFigures and if so, it
    responds with the appropriate actions: If the user hit the goal, it plays
    the win sound and calls the userWonLevel method, if it hit an enemyFigure,
    it increments deaths, updates death info, plays the death sound, and
    resets the level.
    */
   private void userCollideCheck()
   {
      PFigure hitObject = figureList.userHitObject();
      if (hitObject != null)
         if (hitObject instanceof goalFigure)
         {
            playSound(levelWinSoundFile);
            userWonLevel();
         }
         else if (hitObject instanceof enemyFigure)
         {
            if (gameMode.equals("rounds"))
            {
               deaths++;
               deathsThisLevel++;
               updateDeathInfo();
            }
            else
            {
               highScoreManager.writeScore(user, gameMode, level, deathsThisLevel, timeSpentOnLevel);
               timeSpentOnLevel = 0;
            }
            playSound(playerDeathSoundFile);
            setLevel();
         }
   }

}
