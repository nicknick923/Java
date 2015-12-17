
public abstract class Figure{
   protected int x, y;         // Fixed Point
   public Figure(int inX, int inY)
   {
      x = inX;
      y = inY;
   }
   public abstract float area();
}

public class rectangle extends Figure
{
   public rectangle(int x, int y)
   {
         super(x, y);
   }
   @Override
   public float area()
   {
      return x * y;
   }
}
