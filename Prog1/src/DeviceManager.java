
/**
 This class creates a list of devices that can be managed by the user, with 
 commands such as adding, deleting, outputting, printing, and updating.

 @author Jacob Ira
 */
import java.util.Scanner;

public class DeviceManager
{

   final int NOT_FOUND = -1;
   final int MAX_DEVICES = 5;
   private Device list[] = new Device[MAX_DEVICES];    // Array of devices
   private int numDevices = 0;    // Number of Devices currently in the list
   // "Valid" Devices are stored in cells 0 - (numDevices - 1)

   Scanner stdin;  // read from stdin

   /**
    Determines which method to run based off the input character. This method 
    runs an if statement that uses the command that the user has entered to
    determine which method to run.

    @throws java.io.IOException
    */
   public void run() throws java.io.IOException
   {
      stdin = new Scanner(System.in);
      String command = stdin.next();
      while (!command.equalsIgnoreCase("Q"))
      {
         if (command.equalsIgnoreCase("A"))
            addDevice();
         else if (command.equalsIgnoreCase("D"))
            deleteDevice();
         else if (command.equalsIgnoreCase("O"))
            outputDevice();
         else if (command.equalsIgnoreCase("P"))
            printDevices();
         else if (command.equalsIgnoreCase("U"))
            updateDevice();
         command = stdin.next();
      }
      System.out.println("Normal Termination of Program 1");
   }

   /**
    This method adds a device to the list if it is not full.
    The new device will be added to the next open spot in the list.
    If the list is full it will output an error message.
    */
   private void addDevice()
   {
      String name = stdin.next();
      int num_readings = stdin.nextInt();
      float inital_value = stdin.nextFloat();
      if (numDevices == MAX_DEVICES)
         System.out.println("The list was full. " + name
               + " not added to the list.");
      else
      {
         list[numDevices++] = new Device(name, num_readings, inital_value);
         System.out.println(name + " device has been added to the list.");
      }
   }

   /**
    This method deletes the device with the name inputed by the user.
    If the name is not found it will return an error message saying it was not
    in the list.
    After the device is deleted it will shift the other devices up to replace 
    the missing device and decrease numDevices by one.
    */
   private void deleteDevice()
   {
      String name = stdin.next();
      int index = findDevice(name);
      if (index == NOT_FOUND)
         System.out.println(name + " not deleted.  It is not in the list.");
      else
      {
         numDevices--;
         for (int i = index; i < numDevices; i++)
            list[i] = list[i + 1];
         System.out.println(name + " was deleted from the list.");
      }
   }

   /**
    Searches through the array for the device if found returns the index of
    the device if it is not found it returns -1.

    @param device_name the name of the device
    @return index of the device
    */
   private int findDevice(String device_name)
   {
      for (int i = 0; i < numDevices; i++)
         if (list[i].getName().equalsIgnoreCase(device_name))
            return i;
      return NOT_FOUND;
   }

   /**
    Outputs all devices in the array.
    */
   private void printDevices()
   {
      System.out.println("The list of Devices is:");
      for (int i = 0; i < numDevices; i++)
         System.out.println(list[i].toString());
   }

   /**
    Calls to the find method to determine if the device is in the list and if
    found will then print out a message with the device and the reading, but
    if not found it will return a message saying it wasn't in the list.
    */
   private void outputDevice()
   {
      String name = stdin.next();
      int index = findDevice(name);
      if (index == NOT_FOUND)
         System.out.println(name + " not outputted.  It is not in the list.");
      else
      {
         System.out.println("Device " + name + " reads "
               + list[index].returnReading());
      }
   }

   /**
    This method adds a reading to the device in storeReading by calling the
    storeReading method.
    If the device is not found it will output an error message.
    */
   private void updateDevice()
   {
      String name = stdin.next();
      float reading = stdin.nextFloat();
      int index = findDevice(name);
      if (index == NOT_FOUND)
         System.out.println(name + " not updated.  It is not in the list.");
      else
      {
         list[index].storeReading(reading);
         System.out.println("Device " + name + " updated with " + reading);
      }
   }
}
