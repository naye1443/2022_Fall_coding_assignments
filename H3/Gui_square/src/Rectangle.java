import javax.swing.Icon;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rectangle implements Icon{

    public Rectangle(int width, int height, int size){
        this.width = width;
        this.height = height;
        this.size = size;
        this.CurrColor = Color.yellow;
    }

    public int getIconHeight(){
        return height;
    }

    public int getIconWidth(){
        return width;
    }

    public void changeColor(Color C){
        this.CurrColor = C;
    }

    public void paintIcon(Component c, Graphics g, int x, int y){
        Graphics2D g1 = (Graphics2D) g; // typecast abstract graphics to 2D graphics
        Rectangle2D.Double box = new Rectangle2D.Double(x, y, size, size);  // create rectangle
        g1.setColor(CurrColor);
        g1.fill(box);
    }
    private int width;
    private int height;
    private int size;

    private Color CurrColor;

}
