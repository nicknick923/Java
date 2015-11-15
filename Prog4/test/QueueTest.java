
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**

 @author Nick Sosinski
 @author Jake Ira
 */
public class QueueTest
{

   private final int TEST_QUEUE_SIZE = 10;

   public QueueTest()
   {
   }

   @BeforeClass
   public static void setUpClass()
   {
   }

   @AfterClass
   public static void tearDownClass()
   {
   }

   @Before
   public void setUp()
   {
   }

   @After
   public void tearDown()
   {
   }

   /**
    Test of all methods of class Queue. If it fails, see which test below also
    failed.
    */
   @Test
   public void testAll()
   {
      Queue<String> q = new Queue(10);
      for (int i = 0; i < 10; i++)
      {
         assertFalse(q.isFull());
         q.add("Item: " + i);
      }
      assertTrue(q.isFull());
      for (int i = 0; i < 10; i++)
      {
         assertFalse(q.isEmpty());
         assertEquals("Item: " + i, q.remove());
      }
      assertTrue(q.isEmpty());
   }

   /**
    Test of isEmpty method, of class Queue.
    */
   @Test
   public void testIsEmpty()
   {
      System.out.println("isEmpty");
      Queue<String> instance = new Queue(TEST_QUEUE_SIZE);
      for (int i = 0; i < TEST_QUEUE_SIZE; i++)
         instance.add("Item: " + i);
      for (int i = 0; i < TEST_QUEUE_SIZE; i++)
      {
         assertFalse(instance.isEmpty());
         assertEquals("Item: " + i, instance.remove());
      }
      assertTrue(instance.isEmpty());
   }

   /**
    Test of isFull method, of class Queue.
    */
   @Test
   public void testIsFull()
   {
      System.out.println("isFull");
      Queue<String> instance = new Queue(TEST_QUEUE_SIZE);
      for (int i = 0; i < TEST_QUEUE_SIZE; i++)
      {
         assertFalse(instance.isFull());
         instance.add("Item: " + i);
      }
      assertTrue(instance.isFull());
   }

   /**
    Test of add method, of class Queue.
    */
   @Test
   public void testAdd()
   {
      System.out.println("add");
      Queue<String> instance = new Queue(TEST_QUEUE_SIZE);
      instance.add("testString1");
      String expResult = "testString1";
      String result = instance.remove();
      assertEquals(expResult, result);
   }

   /**
    Test of remove method, of class Queue.
    */
   @Test
   public void testRemove()
   {
      System.out.println("remove");
      Queue<String> instance = new Queue(TEST_QUEUE_SIZE);
      instance.add("testString1");
      String expResult = "testString1";
      String result = instance.remove();
      assertEquals(expResult, result);
   }

}
