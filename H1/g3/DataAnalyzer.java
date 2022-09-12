//package H1.g3;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Collections;
import java.util.Iterator;

public class DataAnalyzer {
    public DataAnalyzer(LinkedList<Integer> parlist){
      numDataAnalyzer = parlist;
      Collections.sort(parlist);
      sortedDataAnalyzer = parlist;
    }

    public int calcmin(){
      this.min = sortedDataAnalyzer.getFirst();
      return this.min;
    }

    public int calcmax(){
      this.max = sortedDataAnalyzer.getLast();
      return this.max;
    }

    public double calcavg(){
      Integer avg = 0;
      ListIterator<Integer> iterator = this.sortedDataAnalyzer.listIterator();
      while (iterator.hasNext()){
        avg += iterator.next();
      }
      this.avg = (double)avg/(double) sortedDataAnalyzer.size();
      return this.avg;
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

        if(args.length == 0){
          throw new ArrayIndexOutOfBoundsException();
        }
      }catch(NumberFormatException e){
        System.out.println("This is not a number!");
        System.exit(1);
      }catch(ArrayIndexOutOfBoundsException e){
        System.out.println("You did not enter any inputs, please try again and enter values");
        System.exit(1);
      }

      DataAnalyzer objlist = new DataAnalyzer(numlist);

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

      System.out.println(numlist);
      System.out.println(filename);

      String sequstr = "The sequence is " + strnum + "\n";
      String maxstr = "The maxumum value is " + objlist.calcmax() + "\n";
      String minstr = "The minimum value is " + objlist.calcmin() + "\n";
      String avgstr = "The average of the values are " + objlist.calcavg() + "\n";

      System.out.print(sequstr);
      System.out.print(maxstr);
      System.out.print(minstr);
      System.out.print(avgstr);
    
      // write the passed variables to the file
      try{
          File linkfile = new File(strnum + ".txt");
          FileWriter linkWriter = new FileWriter(linkfile);
          linkWriter.write(sequstr);
          linkWriter.write(maxstr);
          linkWriter.write(minstr);
          linkWriter.write(avgstr);
          linkWriter.close();
      } catch (IOException e){
        System.out.println("An error occurred.");
        e.printStackTrace();
      }

    }

  private LinkedList<Integer> numDataAnalyzer;
  private LinkedList<Integer> sortedDataAnalyzer;
  private Integer min;
  private Integer max;
  private double avg;
};
