import javax.swing.Icon;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Rectangle implements Shape, Icon{
    /**
     * @precondition none
     * @postcondition new Rectangle Icon that's color is yellow
     * Initiates Rectangle with width, height, size, and rectangle color to yellow
     * @param width, width of object in pixels
     * @param height, height of object in pixels
     * @param size, area of object in pixels
     */
    public Rectangle(int width, int height, int size){
        this.width = width;
        this.height = height;
        this.size = size;
        this.CurrColor = Color.yellow;
    }

    /**
     * @precondition, none
     * @postcondition, Current Icons height is returned
     * @return, returns Icons height in pixels
     */
    public int getIconHeight(){
        return height;
    }

    /**
     * @precondition, none
     * @postcondition, Current Icons width is returned
     * @return, returns Icons width in pixels
     */
    public int getIconWidth(){
        return width;
    }
    /**
     * @precondition, the icon has a color, (initially yellow)
     * @postcondition, the icons color will be changed to the given Color value
     * @return, none
     */
    public void changeColor(Color C){
        this.CurrColor = C;
    }
    /**
     * @precondition, Icon needs to be initalized
     * @postcondition, The Icon needs to be painted and held within a Jlabel object
     * @return, none
     */
    public void paintIcon(Component c, Graphics g, int x, int y){
        Graphics2D g1 = (Graphics2D) g; // typecast abstract graphics to 2D graphics
        Rectangle2D.Double box = new Rectangle2D.Double(x, y, width, height);  // create rectangle
        g1.setColor(CurrColor);
        g1.fill(box);
    }

    // draws rectangle shape
    public void draw(Graphics2D g){
        g.draw(new Rectangle2D.Double(0,0, width, height));
    }
    private int width;
    private int height;
    private int size;

    private Color CurrColor;

    @Override
    public java.awt.Rectangle getBounds() {
        return null;
    }

    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }

    @Override
    public boolean contains(double x, double y) {
        return false;
    }

    @Override
    public boolean contains(Point2D p) {
        return false;
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        return false;
    }

    @Override
    public boolean intersects(Rectangle2D r) {
        return false;
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        return false;
    }

    @Override
    public boolean contains(Rectangle2D r) {
        return false;
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        return null;
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return null;
    }

}
