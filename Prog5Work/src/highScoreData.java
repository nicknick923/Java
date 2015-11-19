
/**

 @author Nick Sosinski
 @author Jake Ira
 */
public class highScoreData
{

   private String userName;
   private String gameMode;
   private int level, deaths, time;

   public highScoreData(String name, String mode, int levelBeat, int numberOfDeaths, int timeTaken)
   {
      userName = name;
      gameMode = mode;
      level = levelBeat;
      deaths = numberOfDeaths;
      time = timeTaken;
   }

   public String getName()
   {
      return userName;
   }

   public String getMode()
   {
      return gameMode;
   }

   public int getLevel()
   {
      return level;
   }

   public int getDeaths()
   {
      return deaths;
   }

   public int getTime()
   {
      return time;
   }

   public String endlessString()
   {
      return (userName + " lasted " + ((double) time / Game.MILISECONDS_IN_A_SECOND) + " seconds in endless mode.");
   }

   @Override
   public String toString()
   {
      if (deaths == 1)
         return (userName + " beat level " + level + " with 1 death in " + ((double) time / Game.MILISECONDS_IN_A_SECOND) + " seconds");
      else
         return (userName + " beat level " + level + " with " + deaths + " deaths in " + ((double) time / Game.MILISECONDS_IN_A_SECOND) + " seconds");
   }
}
