/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**

 @author Jacob
 */
public class ListOfFractionTest
{

   public ListOfFractionTest()
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
    Test of add method, of class ListOfFraction.
    */
   @org.junit.Test
   public void testAdd()
   {
      System.out.println("add");
      Fraction firstFraction = new Fraction("1/4");
      ListOfFraction instance = new ListOfFraction();
      instance.add(firstFraction);

      boolean expResult = true;
      boolean result = instance.delete(firstFraction);
      assertEquals(expResult, result);

      expResult = false;
      result = instance.delete(firstFraction);
      assertEquals(expResult, result);
   }

   /**
    Test of product method, of class ListOfFraction.
    */
   @Test
   public void testProduct()
   {
      System.out.println("product");
      Fraction firstFraction = new Fraction("1/4");
      Fraction secondFraction = new Fraction("1/2");
      ListOfFraction instance = new ListOfFraction();
      instance.add(firstFraction);
      instance.add(secondFraction);
      Fraction expResult = new Fraction("1/8");
      Fraction result = instance.product();
      assertEquals(expResult, result);

      instance.add(firstFraction);
      instance.add(secondFraction);
      expResult = new Fraction("1/64");
      result = instance.product();
      assertEquals(expResult, result);
   }

   /**
    Test of delete method, of class ListOfFraction.
    */
   @org.junit.Test
   public void testDelete()
   {
      System.out.println("delete");
      Fraction inFraction = new Fraction("1/4");
      ListOfFraction instance = new ListOfFraction();
      instance.add(inFraction);
      boolean expResult = true;
      boolean result = instance.delete(inFraction);
      assertEquals(expResult, result);

      expResult = false;
      result = instance.delete(inFraction);
      assertEquals(expResult, result);
   }

   /**
    Test of print method, of class ListOfFraction.
    */
   @org.junit.Test
   public void testPrint()
   {
      System.out.println("print");
      int numPerLine = 3;
      ListOfFraction instance = new ListOfFraction();
      Fraction firstFraction = new Fraction("1/2");
      Fraction secondFraction = new Fraction("1/4");
      Fraction thirdFraction = new Fraction("1/8");
      Fraction fourthFraction = new Fraction("1/16");
      instance.print(numPerLine);
      instance.add(firstFraction);
      instance.print(numPerLine);
      instance.add(secondFraction);
      instance.print(numPerLine);
      instance.add(thirdFraction);
      instance.print(numPerLine);
      instance.add(fourthFraction);
      instance.print(numPerLine);
   }

   /**
    Test of sum method, of class ListOfFraction.
    */
   @Test
   public void testSum()
   {
      System.out.println("sum");
      ListOfFraction instance = new ListOfFraction();
      Fraction expResult = new Fraction("0/1");
      Fraction result = instance.sum();
      assertEquals(expResult, result);

   }

}
