
/**

 @author Nick Sosinski
 @author Jake Ira
 */
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.*;

public class Prog5GUI extends java.awt.Frame implements java.awt.event.ActionListener
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
   private final listOfPFigures figureList;
   private final javax.swing.Timer moveTimer = new javax.swing.Timer(gameSpeed, this);
   private final String levelWinSoundFile = "tada.wav";
   private final String playerDeathSoundFile = "Windows Critical Stop.wav";
   private final String pauseSoundFile = "Speech Sleep.wav";
   private final String unpauseSoundFile = "Speech On.wav";
   private final String highScoreFile = "HS.dat";
   private String user = "default";
   private PrintWriter pw;
   private boolean wasPaused;

   /**
    This constructor creates and displays the Prog5GUI then sets up the figure
    list, starts the timer, and sets up the first level.
    */
   public Prog5GUI()
   {
      initComponents();
      try
      {
         pw = new PrintWriter(new FileWriter(highScoreFile, true));
      }
      catch (Exception e)
      {
      }
      userNameTextField.setText(user);
      figureList = new listOfPFigures(gamePanel);
      moveTimer.start();
      componetResized(null);
      setLevel();
      updateDeathInfo();
   }

   /**
    This method is called from within the constructor to initialize the form.
    WARNING: Do NOT modify this code. The content of this method is always
    regenerated by the Form Editor.
    */
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents()
   {

      gamePanel = new java.awt.Panel();
      deathCountField = new java.awt.TextField();
      timeField = new java.awt.TextField();
      userNameTextField = new java.awt.TextField();

      setMinimumSize(new java.awt.Dimension(1130, 700));
      addComponentListener(new java.awt.event.ComponentAdapter()
      {
         public void componentResized(java.awt.event.ComponentEvent evt)
         {
            componetResized(evt);
         }
      });
      addWindowListener(new java.awt.event.WindowAdapter()
      {
         public void windowClosing(java.awt.event.WindowEvent evt)
         {
            exitForm(evt);
         }
      });
      setLayout(null);

      gamePanel.setBackground(new java.awt.Color(200, 200, 200));
      gamePanel.addKeyListener(new java.awt.event.KeyAdapter()
      {
         public void keyPressed(java.awt.event.KeyEvent evt)
         {
            gamePanelKeyDown(evt);
         }
         public void keyReleased(java.awt.event.KeyEvent evt)
         {
            gamePanelKeyUp(evt);
         }
      });
      gamePanel.setLayout(null);
      add(gamePanel);
      gamePanel.setBounds(10, 60, 760, 230);

      deathCountField.setEditable(false);
      deathCountField.setName("deathCountField"); // NOI18N
      deathCountField.addFocusListener(new java.awt.event.FocusAdapter()
      {
         public void focusGained(java.awt.event.FocusEvent evt)
         {
            deathCountFieldtransferFocus(evt);
         }
      });
      add(deathCountField);
      deathCountField.setBounds(10, 40, 120, 20);

      timeField.setBackground(new java.awt.Color(240, 240, 240));
      timeField.setEditable(false);
      timeField.setName("timeField"); // NOI18N
      timeField.addFocusListener(new java.awt.event.FocusAdapter()
      {
         public void focusGained(java.awt.event.FocusEvent evt)
         {
            timeFieldTransferFocus(evt);
         }
      });
      add(timeField);
      timeField.setBounds(140, 40, 150, 20);

      userNameTextField.setName("userNameTextField"); // NOI18N
      userNameTextField.setText("User Name");
      userNameTextField.addFocusListener(new java.awt.event.FocusAdapter()
      {
         public void focusGained(java.awt.event.FocusEvent evt)
         {
            userNameTextFocused(evt);
         }
         public void focusLost(java.awt.event.FocusEvent evt)
         {
            userTextLostFocus(evt);
         }
      });
      userNameTextField.addActionListener(new java.awt.event.ActionListener()
      {
         public void actionPerformed(java.awt.event.ActionEvent evt)
         {
            userNameTextFieldActionPerformed(evt);
         }
      });
      userNameTextField.addTextListener(new java.awt.event.TextListener()
      {
         public void textValueChanged(java.awt.event.TextEvent evt)
         {
            userNameTextChanged(evt);
         }
      });
      add(userNameTextField);
      userNameTextField.setBounds(300, 40, 70, 20);

      pack();
   }// </editor-fold>//GEN-END:initComponents

   /**
    Exit the Application
    */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
       pw.close();
       System.exit(0);
    }//GEN-LAST:event_exitForm

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

   private void gamePanelKeyDown(java.awt.event.KeyEvent evt)//GEN-FIRST:event_gamePanelKeyDown
   {//GEN-HEADEREND:event_gamePanelKeyDown
      if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ESCAPE || evt.getKeyCode() == java.awt.event.KeyEvent.VK_SPACE)
         if (moveTimer.isRunning())
            pause();
         else
            unpause();
      else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_HOME)
         userWonLevel();
      else
         scanMan.keyDownReciver(evt);
   }//GEN-LAST:event_gamePanelKeyDown

   private void gamePanelKeyUp(java.awt.event.KeyEvent evt)//GEN-FIRST:event_gamePanelKeyUp
   {//GEN-HEADEREND:event_gamePanelKeyUp
      scanMan.keyUpReciver(evt);
   }//GEN-LAST:event_gamePanelKeyUp

   private void componetResized(java.awt.event.ComponentEvent evt)//GEN-FIRST:event_componetResized
   {//GEN-HEADEREND:event_componetResized
      gamePanel.setSize(getWidth() - 20, getHeight() - 70);
   }//GEN-LAST:event_componetResized

   private void deathCountFieldtransferFocus(java.awt.event.FocusEvent evt)//GEN-FIRST:event_deathCountFieldtransferFocus
   {//GEN-HEADEREND:event_deathCountFieldtransferFocus
      gamePanel.requestFocus();
   }//GEN-LAST:event_deathCountFieldtransferFocus

   private void timeFieldTransferFocus(java.awt.event.FocusEvent evt)//GEN-FIRST:event_timeFieldTransferFocus
   {//GEN-HEADEREND:event_timeFieldTransferFocus
      gamePanel.requestFocus();
   }//GEN-LAST:event_timeFieldTransferFocus

   private void userNameTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_userNameTextFieldActionPerformed
   {//GEN-HEADEREND:event_userNameTextFieldActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_userNameTextFieldActionPerformed

   private void userNameTextChanged(java.awt.event.TextEvent evt)//GEN-FIRST:event_userNameTextChanged
   {//GEN-HEADEREND:event_userNameTextChanged
      if (!userNameTextField.getText().equals(""))
         user = userNameTextField.getText();
   }//GEN-LAST:event_userNameTextChanged

   private void userNameTextFocused(java.awt.event.FocusEvent evt)//GEN-FIRST:event_userNameTextFocused
   {//GEN-HEADEREND:event_userNameTextFocused
      wasPaused = !moveTimer.isRunning();
      if (moveTimer.isRunning())
         pause();
   }//GEN-LAST:event_userNameTextFocused

   private void userTextLostFocus(java.awt.event.FocusEvent evt)//GEN-FIRST:event_userTextLostFocus
   {//GEN-HEADEREND:event_userTextLostFocus
      if (!wasPaused)
         unpause();
   }//GEN-LAST:event_userTextLostFocus
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
    This method increments the level, resets the timeSpentOnLevel counter, and
    calls to set up the next level.
    */
   private void userWonLevel()
   {
      pw.println(user + ", " + level + ", " + deathsThisLevel + ", " + (timeSpentOnLevel / milisecondsInASecond));
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
   private void setLevel()
   {
      figureList.resetList();
      figureList.addFigure(new scanMan(gamePanel));
      figureList.addFigure(new goalFigure(gamePanel));
      for (int i = 0; i < numberOfEnimies(); i++)
         if (Math.random() > .5)
            figureList.addFigure(new deathDroid(gamePanel));
         else
            figureList.addFigure(new deathApple(gamePanel));
   }

   /**
    This method is the main method of the program and it creates and runs the
    program.

    @param args the command line arguments (not used).
    */
   public static void main(String args[])
   {
      java.awt.EventQueue.invokeLater(new Runnable()
      {
         public void run()
         {
            new Prog5GUI().setVisible(true);
         }
      });
   }

   /**
    This method is called every time the timer ticks and it increments both
    the time on the level and total time played by the timer interval, updates
    the time info, draws all of the figures, and checks for user collisions..

    @param ae The events data (not used).
    */
   @Override
   public void actionPerformed(ActionEvent ae)
   {
      timePlayed += gameSpeed;
      timeSpentOnLevel += gameSpeed;
      updateTimeInfo();
      figureList.drawAll(alternateDrawMethod);
      userCollideCheck();
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
            deaths++;
            deathsThisLevel++;
            updateDeathInfo();
            playSound(playerDeathSoundFile);
            setLevel();
         }
   }
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private java.awt.TextField deathCountField;
   private java.awt.Panel gamePanel;
   private java.awt.TextField timeField;
   private java.awt.TextField userNameTextField;
   // End of variables declaration//GEN-END:variables
}
