
/**

 @author Nick Sosinski
 @author Jake Ira
 */
public class highScoreData
{

   private final String userName;
   private final String gameMode;
   private final int level, deaths, time;

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
}
