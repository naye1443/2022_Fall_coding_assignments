//package H1.g3;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Collections;
import java.util.Iterator;

public class Linklist {
    public Linklist(){

    }

    public static void main(String[] args){

                // creates a string of numbers as the users input
        String strnum = "";
        LinkedList<Integer> numlist = new LinkedList<>();
        try {
            for(int i = 0; i < args.length ;i++){
              numlist.add(Integer.parseInt(args[i]));
              strnum = strnum + args[i] + " ";
            }
          }catch(NumberFormatException e){
            System.out.println("This is not a number!");
            System.exit(1);
          }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("You have entered too many inputs");
            System.exit(1);
          }

        // creates file named the input of the user
        String filename = "";
        try {
            File linkfile = new File(strnum + ".txt");
            if (linkfile.createNewFile()){
                filename = linkfile.getName();
                System.out.println("File " + linkfile.getName() + " created");
            } else{
                System.out.println("File already exists.");
            }
        } catch (IOException e){
            System.out.println("An error Occurred.");
            e.printStackTrace();
        }

        // sort list to easier get max, min, avg
        Collections.sort(numlist);

        System.out.println(numlist);
        System.out.println(filename);

        Integer avg = 0;
        ListIterator<Integer> iterator = numlist.listIterator();
        while (iterator.hasNext()){
          avg += iterator.next();
        }

        avg = avg/numlist.size();

        // write the passed variables to the file
        try{
            File linkfile = new File(strnum + ".txt");
            FileWriter linkWriter = new FileWriter(linkfile);
            linkWriter.write("The sequence is " + strnum + "\n");
            linkWriter.write("The max value is " + numlist.getLast() + "\n");
            linkWriter.write("The minimum value is " + numlist.getFirst() + "\n");
            linkWriter.write(" The average of the values are " + avg);
            linkWriter.close();
        } catch (IOException e){
          System.out.println("An error occurred.");
          e.printStackTrace();
        }




    }
}
