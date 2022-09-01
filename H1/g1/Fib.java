import java.util.*;
import java.math.BigInteger;

public class Fib{

  // Constructor
  public Fib(/*int f0, int f1*/){
  }

  // Fibonacci numbers iteratively
  int fib_itr(int n){

    // Creats needed variables as BigIntegers
    int i = 0;
    BigInteger F_1 = new BigInteger("0");
    BigInteger F_2 = new BigInteger("1");
    BigInteger new1 = new BigInteger("0");
    while(i < n){
      if(i == 0){ // If first Fibonacci operation, use f(0) and f(1) as 0 and 1
        new1 = F_1.add(F_2);
      }else{
        BigInteger tempF_1 = new1;
        new1 = new1.add(F_1);
        F_1 = tempF_1;
      }
      i++;
    }

    System.out.println("The Fibonacci number at i = " + i + " is " + new1);
    System.out.println("Iteratively Fibonacci works");
    
    return 0;
  }

  // Fibonacci numbers recursively

  // Takes user input
  public int userInput(){
    // Initalizes variables and control variables
    int strn = 0;
    boolean correcVal = true;

    while(correcVal){
      // Takes in user input
      Scanner in = new Scanner(System.in);
      String n = in.nextLine();
      // Try to test if the string lined is an integer by trying to turn string into an int
      try{
        strn = Integer.parseInt(n);
      } catch (Exception e){
        System.out.println("This value is not a integer");
        continue;
      }
      // If The converted string to int is a number, make sure the value is greater than 0
      if (strn < 0){
        try{
          throw new ArithmeticException("This number is not greater than 0.");
        } catch (ArithmeticException e ){
          System.out.println("You can not have a number lower than 0");
          continue;
        }
      }

      in.close(); // Activate GC
      correcVal = false;
    }
    return strn;

  }


  // Main function to call different versions for Fibonacci number calculation
  public static void main(String[] args){
    System.out.print("Please enter the n-Ith Fibonacci number you would like:");

    Fib tempfib = new Fib();

    int input = tempfib.userInput();

    tempfib.fib_itr(input);

    System.out.println("End of main function");
    return;
  }
};