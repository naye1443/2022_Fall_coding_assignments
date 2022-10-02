import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class Frame {

    public static void main(String[] args){

        JFrame frame = new JFrame();

        frame.setVisible(true); // set to visible

        // set layout
        frame.setLayout(new FlowLayout());

        // add rectangle for the label
        // add 3 buttons for the label
        JButton yellow = new JButton("YellowButton");
        JButton Red = new JButton("RedButton");
        JButton Blue = new JButton("BlueButton");

        Rectangle MyRect = new Rectangle(ICON_WIDTH,ICON_HEIGHT,ICON_SIZE);
        JLabel label = new JLabel(MyRect);

        Red.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                MyRect.changeColor(Color.RED);// change color
                label.repaint();
            }
        });




        frame.add(label);
        frame.add(yellow);
        frame.add(Red);
        frame.add(Blue);


        frame.pack();   // sets smallest size to display components

        // set on close condition
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // listen to button changes
    }
    // pixel measurements
    private static final int ICON_WIDTH = 400;
    private static final int ICON_HEIGHT = 100;
    private static final int ICON_SIZE = 100;
}
