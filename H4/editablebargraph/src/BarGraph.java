import javax.swing.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.*;

// creates BarGraph Icon
public class BarGraph implements Icon {

  // Sets BarGraph color, height, width
  BarGraph(Color C, int Height, int Width, int maxval){
    barColor = C;
    this.maxval = maxval;
    this.Height = Height;
    this.Width = Width;
    this.rect = new Rectangle(Width, Height, Width * Height);
  }

  // paints the BarIcon color Red
  public void paintIcon(Component c, Graphics g, int x, int y) {
    rect.changeColor(barColor);
    rect.paintIcon(c, g, x, y);
  }

  public int getIconWidth(){return Width;};
  public int getIconHeight(){return Height;};


  private Color barColor;
  private int maxval;
  private int Height;
  private int Width;
  private Rectangle rect;
}
