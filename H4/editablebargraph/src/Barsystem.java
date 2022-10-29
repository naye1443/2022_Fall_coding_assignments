import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Barsystem{

  public static void main(String[] args){

    // Create a Jframe
    JFrame myFrame = new JFrame();
    JPanel panel = new JPanel();

    // craete BarGraph and attatch to Jlabel
    BarGraph graph = new BarGraph(Color.RED, 100, 100, 150);
    JLabel box = new JLabel(graph);


    // create a JTextField
    JTextField barnum = new JTextField();
    barnum.addKeyListener( new KeyAdapter(){

      public void KeyPressed(KeyEvent ke){
        String value = barnum.getText();
        System.out.println(value);
        if(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'){
          barnum.setEditable(true);
        }else{
          barnum.setEditable(false);
        }

      }

    });

    panel.add(box);
    panel.add(barnum);

    panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS) );

    myFrame.add(panel);
    myFrame.pack();   // sets smallest size to display components
    myFrame.setVisible(true);
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set on close condition
  }

//  JPanel createGraphandField(Color c, int Width, int maxval){
//
//
//  }

}