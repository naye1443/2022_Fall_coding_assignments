import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class Frame{
    /**
     * Is Entry point into program
     * @param args
     */
    public static void main(String[] args){

        JFrame frame = new JFrame();
        Frame myframe = new Frame();

        frame.setVisible(true); // set to visible

        frame.setLayout(new FlowLayout()); // set layout



        // add rectangle for the label
        Rectangle MyRect = new Rectangle(ICON_WIDTH,ICON_HEIGHT,ICON_SIZE);
        JLabel label = new JLabel(MyRect);

        // add 3 buttons for the label
        JButton Buttons[] = new JButton[3];
        for(int i = 0; i < 3; i++){
            final Color c = myframe.Colors[i];
            Buttons[i] = myframe.createButton(i, MyRect, label);
        }

        // add buttons and labels
        frame.add(label);
        for(int i = 0; i < 3; i++){
            frame.add(Buttons[i]);
        }

        frame.pack();   // sets smallest size to display components

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set on close condition

    }

    /**
     * This function takes the index of an array. The button with the related actionlistener is returned
     * @param i
     * @return
     */
    public JButton createButton(int i, Rectangle MyRect, JLabel label){
        String colorname = "";
        final Color colorchoice = Colors[i];
        if(i == 0) {
            colorname = "Red";
        }
        else if(i == 1) {
            colorname = "Blue";
        }
        else{
            colorname = "Yellow";
        }
        JButton newButton = new JButton(colorname);
        newButton.addActionListener(createchangeColorListener(colorchoice, MyRect, label));
        return newButton;
    }

    // helper method for adding button listeners
    public static ActionListener createchangeColorListener(Color C, Rectangle MyRect, JLabel label){
        return new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                MyRect.changeColor(C);  // change color
                label.repaint();
            }
        };
    }

    // pixel measurements
    private static final int ICON_WIDTH = 100;
    private static final int ICON_HEIGHT = 100;
    private static final int ICON_SIZE = 10000;

    public Color[] Colors = {Color.RED, Color.BLUE, Color.YELLOW};
}
