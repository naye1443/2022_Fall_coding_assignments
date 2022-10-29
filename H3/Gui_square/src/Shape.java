import javax.swing.Icon;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public interface Shape extends Icon{

    /**
     * @precondition, none
     * @postcondition, Current Icons height is returned
     * @return, returns Icons height in pixels
     */
    public int getIconHeight();
    /**
     * @precondition, none
     * @postcondition, Current Icons width is returned
     * @return, returns Icons width in pixels
     */
    public int getIconWidth();
    /**
     * @precondition, the icon has a color, (initially yellow)
     * @postcondition, the icons color will be changed to the given Color value
     * @return, none
     */
    public void changeColor(Color C);
    /**
     * @precondition, Icon needs to be initalized
     * @postcondition, The Icon needs to be painted and held within a Jlabel object
     * @return, none
     */
    public void paintIcon(Component c, Graphics g, int x, int y);

}
