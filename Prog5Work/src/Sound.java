
/**
 This class controls anything related to sound in the program.

 @author Nick Sosinski
 @author Jake Ira
 */
import java.io.IOException;
import javax.sound.sampled.Clip;

public class Sound
{

   private static Clip gameMusic;
   private static Clip sound;

   /**
    This method tries to play the sound file that is passed in, and if it cant
    it outputs the error to the error output.

    @param filePath The sound files path.
    */
   public static void playSound(String filePath)
   {
      try
      {
         java.io.File soundFile = new java.io.File(filePath);
         javax.sound.sampled.AudioInputStream audioIn
               = javax.sound.sampled.AudioSystem.getAudioInputStream(soundFile);
         javax.sound.sampled.Clip sound
               = javax.sound.sampled.AudioSystem.getClip();
         sound.open(audioIn);
         sound.start();
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
    This method tries to play the sound file that is passed in on an endless
    loop, and if it cant play the file it outputs the error to the error
    output.

    @param filePath The sound files path.
    */
   public static void playGameMusic(String filePath)
   {
      try
      {
         java.io.File soundFile = new java.io.File(filePath);
         javax.sound.sampled.AudioInputStream audioIn
               = javax.sound.sampled.AudioSystem.getAudioInputStream(soundFile);
         gameMusic = javax.sound.sampled.AudioSystem.getClip();
         gameMusic.open(audioIn);
         gameMusic.start();
         gameMusic.loop(Clip.LOOP_CONTINUOUSLY);
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

   public static void stopGameMusic()
   {
      gameMusic.stop();
   }

}
