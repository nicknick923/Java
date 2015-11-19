
/**
 This class manipulates the high score with methods that will set the users
 name, read in data from the input file, and determine and set the high score.

 @author Nick Sosinski
 @author Jake Ira
 */
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.awt.*;

public class HighScoreDataManagement
{

   private static Scanner highScoreScanner;
   private static final String HIGH_SCORE_FILE = "HS.dat";
   private static PrintWriter pw;
   private HighScoreData[] highScores = new HighScoreData[100];
   private int highScoreCount = 0;
   private int numberOfScoresToShow = 5;
   private int endlessCount;
   private static String user;

   /**
    This constructor creates and opens an output file for the high score.
    */
   public HighScoreDataManagement()
   {
      try
      {
         highScoreScanner = new Scanner(new File("HS.dat"));
      }
      catch (Exception e)
      {
         System.err.println("Cound not open High Score File");
      }
   }

   /**
    This method takes the inputed name and sets it as the user

    @param inName The current user.
    */
   public static void setPlayerName(String inName)
   {
      user = inName;
   }

   /**
    This method reads data from the input file and inputs it into the high
    scores array.
    */
   private void readData()
   {
      try
      {
         highScoreScanner = new Scanner(new File("HS.dat"));
      }
      catch (Exception e)
      {
         System.err.println("Cound not open High Score File");
      }
      StringTokenizer tokenizer;
      while (highScoreScanner.hasNext())
      {
         highScoreCount = 0;
         String score = highScoreScanner.nextLine();
         try
         {
            if (score.charAt(0) != '#')
            {
               tokenizer = new StringTokenizer(score, ",");
               //userName,gameMode,levelBeat,deathsOnLevel,timeOnLevel
               String name = tokenizer.nextToken();
               String gameMode = tokenizer.nextToken();
               int levelBeat = Integer.parseInt(tokenizer.nextToken());
               int deathsOnLevel = Integer.parseInt(tokenizer.nextToken());
               int timeOnLevel = Integer.parseInt(tokenizer.nextToken());
               highScores[highScoreCount++] = new HighScoreData(name, gameMode, levelBeat, deathsOnLevel, timeOnLevel);
            }
         }
         catch (Exception e)
         {
         }
      }
      for (int i = 0; i < highScoreCount; i++)
         System.out.println(highScores[i].getLevel());
   }

   /**
    This method checks to see that the current high score has the fewest
    deaths and if there is a high score with a lower death it sets that as the
    new high score.

    @param level The level that the user just beat.
    @return The high score according to fewest deaths for the level.
    */
   public HighScoreData getLeastDeathsForLevel(int level)
   {
      int leastDeathIndex = 0;
      int leastDeaths = Integer.MAX_VALUE;
      int leastTime = Integer.MAX_VALUE;
      for (int i = 0; i < highScoreCount; i++)
         if (highScores[i].getMode().equals("rounds") && highScores[i].getLevel() == level && highScores[i].getDeaths() <= leastDeaths && highScores[i].getTime() <= leastTime)
         {
            leastDeathIndex = i;
            leastDeaths = highScores[i].getDeaths();
            leastTime = highScores[i].getTime();
         }
      return highScores[leastDeathIndex];
   }

   /**
    This method returns the top numberOfScoresToShow scores from the endless
    game mode in an array of highScores.

    @return The high score for endless mode.
    */
   private HighScoreData[] getTopSurvival()
   {
      HighScoreData[] data = new HighScoreData[5];
      endlessCount = 0;
      for (int i = 0; i < highScoreCount; i++)
         if (highScores[i].getMode().equals("endless"))
            swap(endlessCount++, i);
      for (int pass = 0; pass < endlessCount - 1; pass++)
      {
         int maxIndex = pass;
         for (int count = pass + 1; count < endlessCount; count++)
            if (highScores[count].getTime() > highScores[maxIndex].getTime())
               maxIndex = count;
         swap(maxIndex, pass);
      }
      for (int i = 0; i < numberOfScoresToShow && i < endlessCount; i++)
         data[i] = highScores[i];
      return data;
   }

   /**
    This method takes the data in the first index and swaps it with the data
    in index two.

    @param index1 First index to be swapped.
    @param index2 Second index to be swapped.
    */
   private void swap(int index1, int index2)
   {
      HighScoreData temp = highScores[index1];
      highScores[index1] = highScores[index2];
      highScores[index2] = temp;
   }

   /**
    This method adds the scores in the array of data to the list while there
    is more room to add data and more scores to add.

    @param l The list where the scores will be added.
    @param data The scores to be added.
    */
   private void addScoresToList(List l, HighScoreData[] data)
   {
      readData();
      for (int i = 0; i < numberOfScoresToShow && i < endlessCount; i++)
         l.add(data[i].endlessString());
   }

   public void addScoresToList(List l, String mode)
   {
      readData();
      int highestLevel = getHighestLevel();
      if (mode.equals("rounds"))
         for (int i = 1; i <= highestLevel; i++)
            l.add(getLeastDeathsForLevel(i).roundString());
      else
         addScoresToList(l, getTopSurvival());
   }

   private int getHighestLevel()
   {
      int highestLevel = Integer.MIN_VALUE;
      for (int i = 0; i < highScoreCount; i++)
         if (highScores[i].getLevel() > highestLevel)
            highestLevel = highScores[i].getLevel();
      return highestLevel;
   }

   public void writeScore(String gameMode, int level, int numDeathsOnLevel, int timeOnLevel)
   {
      try
      {
         pw = new PrintWriter(new FileWriter(HIGH_SCORE_FILE, true));
         pw.println();
         pw.print(user + "," + gameMode + "," + level + "," + numDeathsOnLevel + "," + timeOnLevel);
         pw.close();
      }
      catch (Exception e)
      {
         System.err.println("Cound not open High Score File");
      }

   }

}
