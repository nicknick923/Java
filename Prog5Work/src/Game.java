
/**

 @author Nick Sosinski
 @author Jake Ira
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game implements java.awt.event.ActionListener
{

   private scanMan player;
   private int deaths = 0;
   private int deathsThisLevel = 0;
   private int level = 1;  //start user at level 1
   private int timeSpentOnLevel = 0;
   private int timePlayed = 0;
   private final int GAME_SPEED = 100;
   private final int MILISECONDS_FOR_EACH_ENDLESS_SPAWN = 5000;
   private final int LEVEL_OFFSET = 5;
   private final int ENIMIES_PER_LEVEL = 2;

   public static final int MILISECONDS_IN_A_SECOND = 1000;

   private final boolean USE_ALTERNATE_DRAW_METHOD = true;

   private String gameMode;
   private final String LEVEL_WON_SOUND_FILE = "tada.wav";
   private final String PLAYER_DEATH_SOUND_FILE = "Windows Critical Stop.wav";
   private final String PAUSE_SOUND_FILE = "Speech Sleep.wav";
   private final String UNPAUSE_SOUND_FILE = "Speech On.wav";
   private static String user = "default";

   private highScoreDataManagement highScoreManager = new highScoreDataManagement();
   private PFigureList figureList;

   private javax.swing.Timer moveTimer;
   private Panel gamePanel;
   private TextField deathCountField;
   private TextField timeField;

   /**
    This constructor creates and displays the Prog5GUI then sets up the figure
    list, starts the timer, and sets up the first level.

    @param gui
    @param p
    @param inTimeField
    @param deathField
    @param inGameMode
    */
   public Game(ActionListener gui, Panel p, java.awt.TextField inTimeField, java.awt.TextField deathField, String inGameMode)
   {
      gameMode = inGameMode;
      moveTimer = new javax.swing.Timer(GAME_SPEED, gui);
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
      Sound.playSound(PAUSE_SOUND_FILE);
   }

   private void unpause()
   {
      moveTimer.start();
      Sound.playSound(UNPAUSE_SOUND_FILE);
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

   /**
    This method increments the level, resets the timeSpentOnLevel counter, and
    calls to set up the next level.
    */
   public void userWonLevel()
   {
      highScoreManager.writeScore(gameMode, level, deathsThisLevel, timeSpentOnLevel);
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
      timeField.setText("Total:" + (timePlayed / MILISECONDS_IN_A_SECOND)
            + "/This Level:" + (timeSpentOnLevel / MILISECONDS_IN_A_SECOND));
   }

   /**
    This method calculates the number of enemies the current level should
    have.

    @return The number of enemies the current level should have.
    */
   private int numberOfEnimies()
   {
      /*
       Examples if LEVEL_OFFSET = 5 and ENIMIES_PER_LEVEL = 2:
       level 1: ((1+5)*2)-2 = (6*2)-2 = 12-2 = 10
       level 2: ((2+5)*2)-2 = (7*2)-2 = 14-2 = 12
       level 3: ((3+5)*2)-2 = (8*2)-2 = 16-2 = 14
       */
      return ((level + LEVEL_OFFSET) * ENIMIES_PER_LEVEL) - 2;
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
      player = new scanMan(gamePanel);
      if (gameMode.equals("rounds"))
      {
         figureList.addFigure(player);
         figureList.addFigure(new goalFigure(gamePanel));
         for (int i = 0; i < numberOfEnimies(); i++)
            if (Math.random() > .5)
               figureList.addFigure(new deathDroid(gamePanel, player));
            else
               figureList.addFigure(new deathApple(gamePanel, player));
      }
      else
      {
         level = LEVEL_OFFSET;
         figureList.addFigure(new scanMan(gamePanel));
         for (int i = 0; i < numberOfEnimies(); i++)
            if (Math.random() > .5)
               figureList.addFigure(new deathDroid(gamePanel, player));
            else
               figureList.addFigure(new deathApple(gamePanel, player));
      }

   }

   /**
    This method is called every time the timer ticks and it increments both
    the time on the level and total time played by the timer interval, updates
    the time info, draws all of the figures, and checks for user collisions.
    */
   public void timerTicked()
   {
      timePlayed += GAME_SPEED;
      timeSpentOnLevel += GAME_SPEED;
      updateTimeInfo();
      figureList.drawAll(USE_ALTERNATE_DRAW_METHOD);
      userCollideCheck();
      if (timeSpentOnLevel % MILISECONDS_FOR_EACH_ENDLESS_SPAWN == 0
            && !gameMode.equals("rounds"))
         if (Math.random() > .5)
            figureList.addFigure(new deathDroid(gamePanel, player));
         else
            figureList.addFigure(new deathApple(gamePanel, player));
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
            Sound.playSound(LEVEL_WON_SOUND_FILE);
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
               highScoreManager.writeScore(gameMode, level,
                     deathsThisLevel, timeSpentOnLevel);
               timeSpentOnLevel = 0;
            }
            Sound.playSound(PLAYER_DEATH_SOUND_FILE);
            setLevel();
         }
   }

}
