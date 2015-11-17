
/**

 @author Nick Sosinski
 @author Jake Ira
 */
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class highScoreDataManagement
{

   private static Scanner highScoreScanner;
   private static final String highScoreFile = "HS.dat";
   private static PrintWriter pw;
   private highScoreData[] highScores = new highScoreData[100];
   private int highScoreCount = 0;

   public highScoreDataManagement()
   {
      try
      {
         highScoreScanner = new Scanner(new File("HS.dat"));
               readData();
      }
      catch (Exception e)
      {
         System.err.println("Cound not open High Score File");
      }
   }

   private void readData()
   {
      StringTokenizer tokenizer;
      while (highScoreScanner.hasNext())
      {
         String score = highScoreScanner.nextLine();
         if (score.charAt(0) != '#')
         {
            tokenizer = new StringTokenizer(score, ",");
            //userName,gameMode,levelBeat,deathsOnLevel,timeOnLevel
            String name = tokenizer.nextToken();
            String gameMode = tokenizer.nextToken();
            int levelBeat = Integer.parseInt(tokenizer.nextToken());
            int deathsOnLevel = Integer.parseInt(tokenizer.nextToken());
            int timeOnLevel = Integer.parseInt(tokenizer.nextToken());
            highScores[highScoreCount++] = new highScoreData(name, gameMode, levelBeat, deathsOnLevel, timeOnLevel);
         }
      }
      for (int i = 0; i < highScoreCount; i++)
         System.out.println(highScores[i].getLevel());
   }

   public void writeScore(String user, String gameMode, int level, int numDeathsOnLevel, int timeOnLevel)
   {
      try
      {
         pw = new PrintWriter(new FileWriter(highScoreFile, true));
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
