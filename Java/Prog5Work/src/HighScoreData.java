
/**
 This class takes in information from the game such as the players name, game
 mode, level, total deaths, and the time spent on that level, then outputs the
 information to the scoreboard.

 @author Nick Sosinski
 @author Jake Ira
 */
public class HighScoreData
{

   private String userName;
   private String gameMode;
   private int level, deaths, time;

   /**
    This constructor reads in the information from the game such as the
    players name, game mode, level, total deaths, and the time spent on that
    level.

    @param name The players name.
    @param mode The game mode user is playing.
    @param levelBeat The level that the user just beat.
    @param numberOfDeaths The total number of deaths for the user.
    @param timeTaken The total time elapsed during that level.
    */
   public HighScoreData(String name, String mode, int levelBeat, int numberOfDeaths, int timeTaken)
   {
      userName = name;
      gameMode = mode;
      level = levelBeat;
      deaths = numberOfDeaths;
      time = timeTaken;
   }

   /**
    This method returns the name of the player.

    @return The name of the player.
    */
   public String getName()
   {
      return userName;
   }

   /**
    This method returns the game mode that the user is playing.

    @return The game mode that the user is playing.
    */
   public String getMode()
   {
      return gameMode;
   }

   /**
    This method returns the current level that the user is on.

    @return The current level that the user is on.
    */
   public int getLevel()
   {
      return level;
   }

   /**
    This method returns the total number of times that the user has died.

    @return The total number of times that the user has died.
    */
   public int getDeaths()
   {
      return deaths;
   }

   /**
    This method returns the time that the user has spent on that level.

    @return The time that the user has spent on that level.
    */
   public int getTime()
   {
      return time;
   }

   /**
    This method returns the concatenation of the players name and how long
    they lasted in survival mode.

    @return The concatenation of the players name and how long they lasted in
    survival mode.
    */
   public String endlessString()
   {
      return (userName + " lasted " + ((double) time / Game.MILISECONDS_IN_A_SECOND) + " seconds in endless mode.");
   }

   /**
    This method creates an output string for the rounds high score board.

    @return The concatenation of the players name and how long they lasted in
    round mode.
    */
   public String roundString()
   {
      if (deaths == 1)
         return (userName + " beat level " + level + " with 1 death in " + ((double) time / Game.MILISECONDS_IN_A_SECOND) + " seconds");
      else
         return (userName + " beat level " + level + " with " + deaths + " deaths in " + ((double) time / Game.MILISECONDS_IN_A_SECOND) + " seconds");
   }
}
