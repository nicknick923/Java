class TB extends TA
{

   private final int b1;

   public TB(int i, int j)
   {
      super(i);
      b1 = j;
   }
@Override
   public void doIt1()
   {
      System.out.println(a1);
      System.out.println("B's doit1");
   }

   public void doIt2()
   {
      System.out.println("B's doit2");
   }
}
