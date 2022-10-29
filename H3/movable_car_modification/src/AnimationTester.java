import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
   This program implements an animation that moves
   a car shape.
*/
public class AnimationTester
{
   public static void main(String[] args)
   {
      ShapeIcon.objImplementsMS = new ArrayList<>();

      JFrame frame = new JFrame("My frame");
      // created a JPanel which is a simpler item than a JFrame
      JPanel panel = new JPanel();

      MovableShape shape[] = new MovableShape[4];
      for(int i = 0; i < 4; i++) {
         final CarShape tempCarShape = new CarShape(0, i, CAR_WIDTH);
         shape[i] = tempCarShape;
      }

      ShapeIcon icon[] = new ShapeIcon[4];
      for(int i = 0; i < shape.length; i++){
         final ShapeIcon tempShapeIcon = new ShapeIcon(shape[i], ICON_WIDTH, ICON_HEIGHT);
         icon[i] = tempShapeIcon;
      }

      JLabel label[] = new JLabel[4];
      for(int i = 0; i < shape.length; i++){
         final JLabel templabel = new JLabel(icon[i]);
         label[i] = templabel;
         panel.add(label[i]);
      }

      System.out.println("There are " + ShapeIcon.objImplementsMS.size() +
              " classes initialized that implement MovableShape. There addresses are:");
      for( int i = 0; i < ShapeIcon.objImplementsMS.size(); i++) {
         System.out.println(ShapeIcon.objImplementsMS.get(i));
      }
      // set the layout of the panel to a BoxLayout that is formulated for change of Y axis
      panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

      // add the panel to the frame
      frame.add(panel);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

      final int DELAY = 100;
      // Milliseconds between timer ticks
      Timer t = new Timer(DELAY, new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               for(int i = 0; i < shape.length; i++){
                  shape[i].translate(3, 0);
                  label[i].repaint();
               }

            }
         });
      t.start();
   }

   private static final int ICON_WIDTH = 400;
   private static final int ICON_HEIGHT = 100;
   private static final int CAR_WIDTH = 100;
}
