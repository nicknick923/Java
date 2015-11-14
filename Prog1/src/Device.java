
/**
This class stores and changes information for a device including a string for
the devices name, an array of readings, and an index for the program to know
where the next reading goes.

@author Jacob Ira
 */
public class Device
{

   private String name;           // name of the device
   private float readings[];      // array of readings for the device
   private int curIndex;          // index where next reading goes

   /**
   Default constructor for Device class which initializes name to device name
   and curIndex to 0.
  
   @param deviceName string type parameter to store devices name
   @param numReadings integer parameter to store the number of readings
   @param initValue a float parameter that hold the initial value of readings 
   */
   public Device(String deviceName, int numReadings, float initValue)
   {
      name = deviceName;
      readings = new float[numReadings];
      for (int i = 0; i < numReadings; i++)
         readings[i] = initValue;
      curIndex = 0;
   }
/**
   Returns the name of the device.
   
   @return device name
   */
   public String getName()
   {
      return name;
   }
/**
   This method returns a string with the name and average value of the
   readings
   
   @return name and average of the readings
   */
   @Override
   public String toString()
   {
      String temp = name + ": " + curIndex;
      for (int i = 0; i < readings.length; i++)
         temp += "," + readings[i];
      return temp;
   }
/**
   This method stores the value in the array in to the devices reading, and if
   the list is full it returns to the start of the list.
   
   @param readValue the value being stored
   */
   public void storeReading(float readValue)
   {
      readings[curIndex++] = readValue;
      if (curIndex == readings.length)
         curIndex = 0;
   }
/**
   This method returns the average of the readings, and if there is nothing it
   returns 0.
   
   @return if there are readings it returns the average otherwise it 
   returns 0.
   */
   public float returnReading()
   {
      float sum = 0;
      if (readings.length != 0)
      {
         for (int i = 0; i < readings.length; i++)
            sum += readings[i];
         return sum/readings.length;
      }
      return 0;
   }

}
