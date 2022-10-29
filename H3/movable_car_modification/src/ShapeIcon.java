import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
   An icon that contains a moveable shape.
*/
public class ShapeIcon implements Icon
{
   public ShapeIcon(MovableShape shape,
      int width, int height)
   {
      this.shape = shape;
      this.width = width;
      this.height = height;
      objImplementsMS.add(shape);
   }
   
   public int getIconWidth()
   {
      return width;
   }

   public int getIconHeight()
   {
      return height;
   }

   public void paintIcon(Component c, Graphics g, int x, int y)
   {
      Graphics2D g2 = (Graphics2D) g;
      shape.draw(g2);
   }

   // get the other objects that impelment MovableShape

   private int width;
   private int height;
   private MovableShape shape;

   public static ArrayList<MovableShape> objImplementsMS;
}


